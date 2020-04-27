package link.yifu.dao;

import link.yifu.base.dao.BaseDao;
import link.yifu.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/*
 @Author: ZongbaoZhu
 @Description: ${DESCRIPTION}
 @Date: 2020/4/24 15:19
 @Version: 1.0
*/
@Mapper
public interface UserDAO extends BaseDao<UserEntity> {

    public UserEntity selectUserByMap(Map map);
}
