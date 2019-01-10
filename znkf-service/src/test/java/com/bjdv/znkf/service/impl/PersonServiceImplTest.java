package com.bjdv.znkf.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bjdv.znkf.pojo.Person;
import com.bjdv.znkf.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceImplTest {

    @Autowired
    private PersonService personServiceImpl;


    @Test
    public void findAll() {
        System.out.println( JSONObject.toJSONString( personServiceImpl.findAll() ) );
    }

    @Test
    public void findById() {
        Person person = new Person();
        person.setId( 1 );
        System.out.println( JSONObject.toJSONString( personServiceImpl.findById( person ) ) );
    }
}
