package link.yifu.service.impl;

import link.yifu.dao.PermissionDAO;
import link.yifu.base.service.impl.BaseServiceImpl;
import link.yifu.dto.Result;
import link.yifu.entity.PermissionEntity;
import link.yifu.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/*
 @Author: ZongbaoZhu
 @Description: ${DESCRIPTION}
 @Date: 2020/4/24 15:27
 @Version: 1.0
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class PermissionServiceImpl extends BaseServiceImpl implements PermissionService {

    @Autowired
    private PermissionDAO permissionDAO;

    @Override
    public boolean add(PermissionEntity permissionEntity) {
        return isTrue(permissionDAO.add(permissionEntity));
    }

    @Override
    public boolean add(List<PermissionEntity> permissionEntities) {
        return isTrue(permissionDAO.addBatch(permissionEntities));
    }

    @Override
    public boolean update(PermissionEntity permissionEntity) {
        return isTrue(permissionDAO.update(permissionEntity));
    }

    @Override
    public boolean delete(PermissionEntity permissionEntity) {
        return isTrue(permissionDAO.delete(permissionEntity));
    }

    @Override
    public Result<PermissionEntity> get(Map<String, String> map) {
        Result<PermissionEntity> result = new Result<PermissionEntity>();
        result.setData(permissionDAO.get(map));
        if(isPage(map)){
            int total = permissionDAO.getCount(map);
            result.setTotal(total);
        }
        return result;
    }

    @Override
    public PermissionEntity getByEntity(PermissionEntity permissionEntity) {
        return permissionDAO.getByEntity(permissionEntity);
    }
}
