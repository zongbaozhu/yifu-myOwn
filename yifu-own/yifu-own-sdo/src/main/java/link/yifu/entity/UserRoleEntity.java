package link.yifu.entity;

import link.yifu.base.entity.BaseEntity;
import lombok.Data;

/*
 @Author: ZongbaoZhu
 @Description: ${DESCRIPTION}
 @Date: 2020/4/24 14:57
 @Version: 1.0
*/
@Data
public class UserRoleEntity extends BaseEntity {
    private Integer userID;
    private String userName;
    private Integer roleID;
    private String roleName;
}
