package link.yifu.enums;

import lombok.Getter;

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
    ERROR("500", "网络连接异常");

    private String code;
    private String msg;

    ExceptionEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
