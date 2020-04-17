package link.yifu.dto;

import link.yifu.util.PageUtil;

import java.util.List;

/*
 @Author: ZongbaoZhu
 @Description: ${DESCRIPTION}
 @Date: 2020/4/3 15:53
 @Version: 1.0
*/
public class Result<T> {
    private int total;
    private int totalPage;
    private List<T> data;
    private Object object;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
        this.totalPage = PageUtil.getTotalPage(this.total);
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
