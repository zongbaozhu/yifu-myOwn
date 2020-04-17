package link.yifu.aop;

import link.yifu.enums.ExceptionEnum;
import link.yifu.exception.APIException;
import link.yifu.vo.ResultVO;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
 @Author: ZongbaoZhu
 @Description: ${DESCRIPTION}
 @Date: 2020/4/14 11:03
 @Version: 1.0
*/
@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return  new ResultVO<String>(ExceptionEnum.VALIDATE_FAILED, objectError.getDefaultMessage());
    }
    @ExceptionHandler(APIException.class)
    public ResultVO<String> APIExceptionHandler(APIException e){
        return new ResultVO<String>(ExceptionEnum.FAILED,e.getMsg());//e.getMsg();
    }
}
