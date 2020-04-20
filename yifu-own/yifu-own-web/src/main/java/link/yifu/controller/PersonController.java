package link.yifu.controller;

import link.yifu.dto.Result;
import link.yifu.entity.PersonEntity;
import link.yifu.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/*
 @Author: ZongbaoZhu
 @Description: ${DESCRIPTION}
 @Date: 2020/4/3 16:49
 @Version: 1.0
*/
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/get")
    public Result get(@RequestParam Map map){
        return personService.get(map);
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody @Valid PersonEntity personEntity) {
        return personService.addUser(personEntity);
    }
    @GetMapping("/getUser")
    public PersonEntity getUser(){
        PersonEntity entity = new PersonEntity();
        System.out.println("1111112");
        entity.setId(1);
        entity.setName("xx");
        entity.setAge(28);
        System.out.println("1121112");
        return entity;
    }
}
