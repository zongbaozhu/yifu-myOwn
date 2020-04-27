package link.yifu.service.impl;

import link.yifu.base.service.impl.BaseServiceImpl;
import link.yifu.dao.UserDAO;
import link.yifu.dto.Result;
import link.yifu.entity.UserEntity;
import link.yifu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 @Author: ZongbaoZhu
 @Description: ${DESCRIPTION}
 @Date: 2020/4/24 15:24
 @Version: 1.0
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public boolean add(UserEntity userEntity) {
        return isTrue(userDAO.add(userEntity));
    }

    @Override
    public boolean add(List<UserEntity> userEntities) {
        return isTrue(userDAO.addBatch(userEntities));
    }

    @Override
    public boolean update(UserEntity userEntity) {
        return isTrue(userDAO.update(userEntity));
    }

    @Override
    public boolean delete(UserEntity userEntity) {
        return isTrue(userDAO.delete(userEntity));
    }

    @Override
    public Result<UserEntity> get(Map<String, String> map) {
        Result<UserEntity> result = new Result<>();
        result.setData(userDAO.get(map));
        if(isPage(map)){
            int total = userDAO.getCount(map);
            result.setTotal(total);
        }
        return result;
    }

    @Override
    public UserEntity getByEntity(UserEntity userEntity) {
        return userDAO.getByEntity(userEntity);
    }

    @Override
    public UserEntity selectUserByMap(String name) {
        Map<String,Object> map = new HashMap();
        map.put("userName", name);
        return userDAO.selectUserByMap(map);
    }
}
