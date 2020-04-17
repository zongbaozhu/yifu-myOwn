package link.yifu.entity;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

/*
 @Author: ZongbaoZhu
 @Description: 实体类基类
 @Date: 2020/4/3 15:15
 @Version: 1.0
*/
@Data
public abstract class BaseEntity {

    @NotNull
    private Integer id;
    private Integer status;
    private Date createdTime;
    private Date lastModifiedTime;
}
