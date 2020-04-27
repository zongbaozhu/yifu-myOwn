package link.yifu.service.impl;

import link.yifu.dao.UserRoleDAO;
import link.yifu.base.service.impl.BaseServiceImpl;
import link.yifu.dto.Result;
import link.yifu.entity.UserEntity;
import link.yifu.entity.UserRoleEntity;
import link.yifu.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/*
 @Author: ZongbaoZhu
 @Description: ${DESCRIPTION}
 @Date: 2020/4/24 15:28
 @Version: 1.0
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class UserRoleServiceImpl extends BaseServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleDAO userRoleDAO;

    @Override
    public boolean add(UserRoleEntity userRoleEntity) {
        return isTrue(userRoleDAO.add(userRoleEntity));
    }

    @Override
    public boolean add(List<UserRoleEntity> userRoleEntities) {
        return isTrue(userRoleDAO.addBatch(userRoleEntities));
    }

    @Override
    public boolean update(UserRoleEntity userRoleEntity) {
        return isTrue(userRoleDAO.update(userRoleEntity));
    }

    @Override
    public boolean delete(UserRoleEntity userRoleEntity) {
        return isTrue(userRoleDAO.delete(userRoleEntity));
    }

    @Override
    public Result<UserRoleEntity> get(Map<String, String> map) {
        Result<UserRoleEntity> result = new Result<UserRoleEntity>();
        result.setData(userRoleDAO.get(map));
        if(isPage(map)){
            int total = userRoleDAO.getCount(map);
            result.setTotal(total);
        }
        return result;
    }

    @Override
    public UserRoleEntity getByEntity(UserRoleEntity userRoleEntity) {
        return userRoleDAO.getByEntity(userRoleEntity);
    }

    @Override
    public UserEntity selectUserByMap(Map map) {
        return null;
    }
}
