package link.yifu.base.dao;

import java.util.List;
import java.util.Map;

/*
 @Author: ZongbaoZhu
 @Description: ${DESCRIPTION}
 @Date: 2020/4/3 15:23
 @Version: 1.0
*/
public interface BaseDao<T> {
    Integer add(T t);

    Integer addBatch(List<T> tList);

    Integer delete(T t);

    Integer deleteBatch(List<T> tList);

    Integer update(T t);

    List<T> get(Map map);

    Integer getCount(Map map);

    T getByEntity(T t);
}
