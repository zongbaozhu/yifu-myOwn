package link.yifu.shiro;

import link.yifu.entity.PermissionEntity;
import link.yifu.entity.RoleEntity;
import link.yifu.entity.UserEntity;
import link.yifu.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/*
 @Author: ZongbaoZhu
 @Description: ${DESCRIPTION}
 @Date: 2020/4/24 14:13
 @Version: 1.0
*/
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;


    /**
     * 必须重写此方法，不然会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /*主要用来权限认证，把数据库角色和权限都遍历放入到SimpleAuthorizationInfo*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("============权限认证==============");
        UserEntity userEntity = (UserEntity)principals.getPrimaryPrincipal();
        UserEntity user = userService.selectUserByMap(userEntity.getName());
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<RoleEntity> roleLists = user.getRoleLists();
        Set<String> roleNames = new HashSet<>();
        for(RoleEntity role:roleLists){
            if(StringUtils.isNotBlank(role.getName())){
                roleNames.add(role.getName());
            }
        }
        Set<PermissionEntity> permissionLists = user.getPermissionLists();
        Set<String> permissionNames = new HashSet<>();
        for(PermissionEntity permission:permissionLists){
            if(StringUtils.isNotBlank(permission.getName())){
                permissionNames.add(permission.getName());
            }
        }
        authorizationInfo.setRoles(roleNames);
        authorizationInfo.setStringPermissions(permissionNames);
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("==========身份认证==========");
        String token = (String) authenticationToken.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUserNameByToken(token);
        if (username == null || !JWTUtil.verify(token, username)) {
            throw new AuthenticationException("token认证失败！");
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setName(username);
        String password = userService.getByEntity(userEntity).getPassword();
        if (password == null) {
            throw new AuthenticationException("该用户不存在！");
        }
        return new SimpleAuthenticationInfo(token, token, "MyRealm");
    }
}
