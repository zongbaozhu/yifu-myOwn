package link.yifu.aop;



import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

/*
 @Author: ZongbaoZhu
 @Description: ${DESCRIPTION}
 @Date: 2020/4/14 11:55
 @Version: 1.0
*/
@Aspect
@Component
@Slf4j
public class LogAspect {
    //private final Logger logger = LogManager.getLogger(LogControllerAdvice.class);;
    //这个方法会拦截com.ssrtest02.controller项目包所有类的所有方法
    @Pointcut("execution(public * link.yifu.controller..*.*(..))")
    public void webLog() {
    }

    /**
     *使用AOP的前置通知拦截请求参数信息
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        //  接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //  记录下请求内容
        log.info("Request URL: " + request.getRequestURL().toString());
        log.info("Request Method: " + request.getMethod());
        log.info("User-Agent: " + request.getHeader("User-Agent"));
        log.info("Class Method: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("Cookies: " + request.getCookies());
        log.info("Params: " + Arrays.toString(joinPoint.getArgs()));
        Enumeration<String> enums = request.getParameterNames();
        while (enums.hasMoreElements()) {
            String paraName = enums.nextElement();
            log.info(paraName + ":" + request.getParameter(paraName));
        }

    }

    /**
     *使用AOP的后置通知
     */
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        //  处理完请求，返回内容
        log.info("RESPONSE : " + ret);
    }

}
