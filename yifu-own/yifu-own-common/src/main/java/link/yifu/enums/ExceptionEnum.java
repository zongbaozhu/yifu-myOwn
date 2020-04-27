package link.yifu.enums;

import lombok.Getter;
import org.omg.CORBA.NO_PERMISSION;

/*
 @Author: ZongbaoZhu
 @Description: ${DESCRIPTION}
 @Date: 2020/4/14 9:34
 @Version: 1.0
*/
@Getter
public enum ExceptionEnum {

    SUCCESS("200","操作成功"),
    FAILED("501", "响应失败"),
    VALIDATE_FAILED("2000", "参数校验失败"),
    ERROR("500", "网络连接异常"),
    NO_PERMISSION("401","您没有权限访问！"),
    USER_FAILED("402", "用户名错误"),
    PASSWORD_FAILED("403", "密码错误");

    private String code;
    private String msg;

    ExceptionEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
