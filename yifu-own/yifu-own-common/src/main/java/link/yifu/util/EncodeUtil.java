package link.yifu.util;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;

/*
 @Author: ZongbaoZhu
 @Description: ${DESCRIPTION}
 @Date: 2020/4/26 16:56
 @Version: 1.0
*/
@Slf4j
public class EncodeUtil {

    public static String md5Encode(String str) {
        MessageDigest md5 = null;
        byte[] byteArray = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byteArray = str.getBytes("UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.toString());
        }
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
}
