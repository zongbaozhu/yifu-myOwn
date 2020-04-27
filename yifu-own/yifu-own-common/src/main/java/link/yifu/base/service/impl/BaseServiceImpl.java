package link.yifu.base.service.impl;


import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/*
 @Author: ZongbaoZhu
 @Description: ${DESCRIPTION}
 @Date: 2020/4/3 16:20
 @Version: 1.0
*/
public class BaseServiceImpl {

    protected Boolean isTrue(Integer count){
        try{
            if(count != null && count > 0){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    protected Boolean isPage(Map<String,String> map){
        if(StringUtils.isBlank(map.get("start")) && StringUtils.isBlank(map.get("limit"))){
            return true;
        }
        return false;
    }
}
