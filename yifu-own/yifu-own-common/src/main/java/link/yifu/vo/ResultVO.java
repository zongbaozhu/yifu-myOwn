package link.yifu.vo;

import link.yifu.enums.ExceptionEnum;
import lombok.Getter;

/*
 @Author: ZongbaoZhu
 @Description: ${DESCRIPTION}
 @Date: 2020/4/14 9:10
 @Version: 1.0
*/
@Getter
public class ResultVO<T> {

    private String code;
    private String msg;
    private T data;

    public ResultVO(T data) {
        this(ExceptionEnum.SUCCESS,data);
    }

    public ResultVO(ExceptionEnum exceptionEnum, T data) {

        this.code = exceptionEnum.getCode();
        this.msg = exceptionEnum.getMsg();
        this.data = data;
    }
}
