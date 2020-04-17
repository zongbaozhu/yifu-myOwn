package link.yifu.util;

/*
 @Author: ZongbaoZhu
 @Description: ${DESCRIPTION}
 @Date: 2020/4/3 15:49
 @Version: 1.0
*/
public class PageUtil {

    public static final int PAGE_SIZE = 10;

    public static int getTotalPage(int totalCount){
        int size = totalCount / PAGE_SIZE;
        int size_ = totalCount % PAGE_SIZE;
        size = size_ > 0 ? size + 1 : size;
        return size;
    }
}
