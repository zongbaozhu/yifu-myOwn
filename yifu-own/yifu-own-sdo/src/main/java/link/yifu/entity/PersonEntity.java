package link.yifu.entity;

import lombok.Data;
import javax.validation.constraints.NotNull;

/*
 @Author: ZongbaoZhu
 @Description: ${DESCRIPTION}
 @Date: 2020/4/3 14:45
 @Version: 1.0
*/
@Data
public class PersonEntity extends BaseEntity{
    @NotNull(message = "用户name不为空")
    private String name;
    private Integer age;
}
