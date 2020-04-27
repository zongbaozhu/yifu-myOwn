package link.yifu.service.impl;

import link.yifu.dao.RolePermissionDAO;
import link.yifu.base.service.impl.BaseServiceImpl;
import link.yifu.dto.Result;
import link.yifu.entity.RolePermissionEntity;
import link.yifu.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/*
 @Author: ZongbaoZhu
 @Description: ${DESCRIPTION}
 @Date: 2020/4/24 15:30
 @Version: 1.0
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class RolePermissionServiceImpl extends BaseServiceImpl implements RolePermissionService {

    @Autowired
    private RolePermissionDAO rolePermissionDAO;

    @Override
    public boolean add(RolePermissionEntity rolePermissionEntity) {
        return isTrue(rolePermissionDAO.add(rolePermissionEntity));
    }

    @Override
    public boolean add(List<RolePermissionEntity> rolePermissionEntities) {
        return isTrue(rolePermissionDAO.addBatch(rolePermissionEntities));
    }

    @Override
    public boolean update(RolePermissionEntity rolePermissionEntity) {
        return isTrue(rolePermissionDAO.update(rolePermissionEntity));
    }

    @Override
    public boolean delete(RolePermissionEntity rolePermissionEntity) {
        return isTrue(rolePermissionDAO.delete(rolePermissionEntity));
    }

    @Override
    public Result<RolePermissionEntity> get(Map<String, String> map) {
        Result<RolePermissionEntity> result = new Result<RolePermissionEntity>();
        result.setData(rolePermissionDAO.get(map));
        if(isPage(map)){
            int total = rolePermissionDAO.getCount(map);
            result.setTotal(total);
        }
        return result;
    }

    @Override
    public RolePermissionEntity getByEntity(RolePermissionEntity rolePermissionEntity) {
        return rolePermissionDAO.getByEntity(rolePermissionEntity);
    }
}
