package link.yifu.service.impl;

import link.yifu.dao.RoleDAO;
import link.yifu.base.service.impl.BaseServiceImpl;
import link.yifu.dto.Result;
import link.yifu.entity.RoleEntity;
import link.yifu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/*
 @Author: ZongbaoZhu
 @Description: ${DESCRIPTION}
 @Date: 2020/4/24 15:26
 @Version: 1.0
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl extends BaseServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public boolean add(RoleEntity roleEntity) {
        return isTrue(roleDAO.add(roleEntity));
    }

    @Override
    public boolean add(List<RoleEntity> roleEntities) {
        return isTrue(roleDAO.addBatch(roleEntities));
    }

    @Override
    public boolean update(RoleEntity roleEntity) {
        return isTrue(roleDAO.update(roleEntity));
    }

    @Override
    public boolean delete(RoleEntity roleEntity) {
        return isTrue(roleDAO.delete(roleEntity));
    }

    @Override
    public Result<RoleEntity> get(Map<String, String> map) {
        Result<RoleEntity> result = new Result<RoleEntity>();
        result.setData(roleDAO.get(map));
        if(isPage(map)){
            int total = roleDAO.getCount(map);
            result.setTotal(total);
        }
        return result;
    }

    @Override
    public RoleEntity getByEntity(RoleEntity roleEntity) {
        return roleDAO.getByEntity(roleEntity);
    }
}
