package link.yifu.service;

import link.yifu.dto.Result;

import java.util.List;
import java.util.Map;

/*
 @Author: ZongbaoZhu
 @Description: ${DESCRIPTION}
 @Date: 2020/4/3 16:19
 @Version: 1.0
*/
public interface BaseService<T> {
    boolean add(T t);

    boolean add(List<T> tList);

    boolean update(T t);

    boolean delete(T t);

    Result<T> get(Map<String, String> map);

    T getByEntity(T t);
}
