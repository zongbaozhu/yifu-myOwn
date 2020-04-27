package link.yifu.service;

import link.yifu.base.service.BaseService;
import link.yifu.entity.UserEntity;
import link.yifu.entity.UserRoleEntity;

import java.util.Map;

/*
 @Author: ZongbaoZhu
 @Description: ${DESCRIPTION}
 @Date: 2020/4/24 15:20
 @Version: 1.0
*/
public interface UserRoleService extends BaseService<UserRoleEntity> {
    public UserEntity selectUserByMap(Map map);
}
