package link.yifu.controller;

import link.yifu.config.BaseController;
import link.yifu.entity.UserEntity;
import link.yifu.enums.ExceptionEnum;
import link.yifu.exception.APIException;
import link.yifu.service.UserService;
import link.yifu.shiro.JWTUtil;
import link.yifu.util.EncodeUtil;
import link.yifu.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/*
 @Author: ZongbaoZhu
 @Description: ${DESCRIPTION}
 @Date: 2020/4/24 15:44
 @Version: 1.0
*/
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/add")
    public Object add(UserEntity userEntity){
        return userService.add(userEntity);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Object delete(UserEntity userEntity){
        return userService.delete(userEntity);
    }

    @ResponseBody
    @RequestMapping("update")
    public Object update(UserEntity userEntity){
        return userService.update(userEntity);
    }

    @ResponseBody
    @RequestMapping("/get")
    public Object get(){
        Map<String, String> map = this.getParam();
        return userService.get(map);
    }

    @ResponseBody
    @RequestMapping("/me/get")
    public Object get(UserEntity userEntity){
        return userService.getByEntity(userEntity);
    }

    @ResponseBody
    @RequestMapping("/login")
    public Object login(UserEntity userEntity){
        //userEntity.setAccount(userEntity.getAccount());
        UserEntity entity = userService.getByEntity(userEntity);
        if(entity != null){
            if(entity.getPassword() == null){
                System.out.println("用户名错误！！！");
                throw new APIException("用户名错误！！！");
            }else if(!entity.getPassword().equals(EncodeUtil.md5Encode(userEntity.getPassword()))){
                System.out.println("密码错误！！！");
                throw new APIException("密码错误！！！");
            }
        }
        return JWTUtil.createToken(userEntity.getName());
    }
}
