package link.yifu.service;

import link.yifu.entity.PersonEntity;

/*
 @Author: ZongbaoZhu
 @Description: ${DESCRIPTION}
 @Date: 2020/4/3 16:36
 @Version: 1.0
*/
public interface PersonService extends BaseService<PersonEntity>{
    public String addUser(PersonEntity personEntity);
}
