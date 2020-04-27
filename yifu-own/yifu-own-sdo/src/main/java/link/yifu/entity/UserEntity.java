package link.yifu.entity;

import link.yifu.base.entity.BaseEntity;
import lombok.Data;

import java.util.Set;

/*
 @Author: ZongbaoZhu
 @Description: ${DESCRIPTION}
 @Date: 2020/4/24 14:53
 @Version: 1.0
*/
@Data
public class UserEntity extends BaseEntity {
    private String account;
    private String name;
    private String password;
    private String email;
    private String phone;
    private Set<RoleEntity> roleLists;
    private Set<PermissionEntity> permissionLists;
}
