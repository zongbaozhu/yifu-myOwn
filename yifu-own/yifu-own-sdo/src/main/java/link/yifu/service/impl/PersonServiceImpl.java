package link.yifu.service.impl;

import link.yifu.dao.PersonDAO;
import link.yifu.dto.Result;
import link.yifu.entity.PersonEntity;
import link.yifu.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/*
 @Author: ZongbaoZhu
 @Description: ${DESCRIPTION}
 @Date: 2020/4/3 16:37
 @Version: 1.0
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class PersonServiceImpl extends BaseServiceImpl implements PersonService {

    @Autowired
    private PersonDAO personDAO;

    @Override
    public boolean add(PersonEntity personEntity) {
        return isTrue(personDAO.add(personEntity));
    }

    @Override
    public boolean add(List<PersonEntity> personEntities) {
        return isTrue(personDAO.addBatch(personEntities));
    }

    @Override
    public boolean update(PersonEntity personEntity) {
        return isTrue(personDAO.update(personEntity));
    }

    @Override
    public boolean delete(PersonEntity personEntity) {
        return isTrue(personDAO.delete(personEntity));
    }

    @Override
    public Result<PersonEntity> get(Map<String, String> map) {
        Result<PersonEntity> result = new Result<>();
        result.setData(personDAO.get(map));
        if(isPage(map)){
            int total = personDAO.getCount(map);
            result.setTotal(total);
        }
        return result;
    }

    @Override
    public PersonEntity getByEntity(PersonEntity personEntity) {
        return personDAO.getByEntity(personEntity);
    }


    @Override
    public String addUser(PersonEntity personEntity) {
        return "success";
    }
}
