package link.yifu.shiro;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

/*
 @Author: ZongbaoZhu
 @Description: ${DESCRIPTION}
 @Date: 2020/4/25 16:10
 @Version: 1.0
*/
@Slf4j
public class JWTUtil {

    //过期时间24小时
    public static final long EXPIRE_TIME = 24*60*60*1000;
    //密钥
    public static final String SECRET = "SHIRO+JWT";

    /**
     * 生成 token
     *
     * @param userName 用户名
     * @return 加密的token
     */
    public static String createToken(String userName){
        try{
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            return JWT.create()
                    //附带userName信息
                    .withClaim("userName",userName)
                    //到期时间
                    .withExpiresAt(date)
                    //创建一个新的JWT，并使用给定的算法进行标记
                    .sign(algorithm);
        }catch (UnsupportedEncodingException e) {
            log.error(e.getMessage());
            return null;
        }
    }

    /**
     * 校验 token 是否正确
     *
     * @param token    密钥
     * @param userName 用户名
     * @return 是否正确
     */
    public static boolean verify(String token,String userName){
        try{
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("userName", userName)
                    .build();
            //验证 token
            verifier.verify(token);
            return true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }

    /**
     * 获得token中的信息，无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getUserNameByToken(String token){
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userName").asString();
        }catch (JWTDecodeException e){
            log.error(e.getMessage());
            return null;
        }
    }

}
