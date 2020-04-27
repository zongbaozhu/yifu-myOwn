package link.yifu.entity;

import link.yifu.base.entity.BaseEntity;
import lombok.Data;

/*
 @Author: ZongbaoZhu
 @Description: ${DESCRIPTION}
 @Date: 2020/4/24 15:04
 @Version: 1.0
*/
@Data
public class RolePermissionEntity extends BaseEntity {
    private Integer roleID;
    private String roleName;
    private Integer permissionID;
    private String permissionName;
}
