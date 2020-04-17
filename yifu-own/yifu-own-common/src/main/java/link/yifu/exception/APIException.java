package link.yifu.exception;

import lombok.Getter;

/*
 @Author: ZongbaoZhu
 @Description: ${DESCRIPTION}
 @Date: 2020/4/14 8:59
 @Version: 1.0
*/
@Getter
public class APIException extends RuntimeException {

    private String code;
    private String msg;

    public APIException() {
        this("501", "响应失败");
    }

    public APIException(String msg) {
        this("500", msg);
    }

    public APIException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }



}
