package link.yifu.entity;

import link.yifu.base.entity.BaseEntity;
import lombok.Data;

/*
 @Author: ZongbaoZhu
 @Description: ${DESCRIPTION}
 @Date: 2020/4/24 15:01
 @Version: 1.0
*/
@Data
public class PermissionEntity extends BaseEntity {
    private String name;
    private String icon;
    private String url;
    private Integer priority;
    private String permission;
    private Integer parentID;
    private String desc;
    private Integer type;
}
