package link.yifu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 @Author: ZongbaoZhu
 @Description: ${DESCRIPTION}
 @Date: 2020/4/24 15:55
 @Version: 1.0
*/
@Controller
public class BaseController {

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    protected Map<String,String> getParam(){return formatParam(request.getParameterMap());}

    private Map<String,String>formatParam(Map paramMap){
        Map<String, String> map = new HashMap<String, String>();
        if (paramMap != null) {
            Set key = paramMap.keySet();
            for (Object o:key.toArray()){
                String paramKey = o.toString();
                String paramValue = ((String[])paramMap.get(o))[0];
                map.put(paramKey, paramValue);
            }
        }
        return map;
    }
}
