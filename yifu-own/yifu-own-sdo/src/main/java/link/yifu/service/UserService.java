package link.yifu.service;

import link.yifu.base.service.BaseService;
import link.yifu.entity.UserEntity;

import java.util.Map;

/*
 @Author: ZongbaoZhu
 @Description: ${DESCRIPTION}
 @Date: 2020/4/24 15:12
 @Version: 1.0
*/
public interface UserService extends BaseService<UserEntity> {
    public UserEntity selectUserByMap(String userName);
}
