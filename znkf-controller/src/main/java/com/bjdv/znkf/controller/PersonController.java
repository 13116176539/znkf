package com.bjdv.znkf.controller;


import com.bjdv.znfk.utils.ResultEnum;
import com.bjdv.znfk.utils.ResultUtil;
import com.bjdv.znkf.pojo.Person;
import com.bjdv.znkf.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * 〈〉
 *
 * @author hanxulei
 * @create 2018/10/8
 * @since 1.0.0
 */
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/findAll")
    public String findAll() {
        try {
            List <Person> p = personService.findAll();
            return ResultUtil.success( p );
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error( ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getMsg() );
        }
    }

    @RequestMapping("/save")
    public String save(@RequestBody Person person) {
        try {
            personService.saveInfo( person );
            return ResultUtil.success( ResultEnum.SUCCESS );
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error( ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getMsg() );
        }
    }

    @RequestMapping("/update")
    public String updateById(@RequestBody Person person) {
        try {
            personService.updateById( person );
            return ResultUtil.success( ResultEnum.SUCCESS );
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error( ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getMsg() );
        }
    }

    @RequestMapping("/del")
    public String delById(@RequestBody Person person) {
        try {
            List <Person> list = personService.delectById( person );
            return ResultUtil.success( list );
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error( ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getMsg() );
        }
    }


    @RequestMapping("/findById")
    public String findById(@RequestBody Person person) {
        try {
            Optional <Person> p = personService.findById( person );
            //System.out.println( p );
            return ResultUtil.success( p );
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error( ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getMsg() );
        }
    }

    @RequestMapping("/findByName")
    public String findByName(@RequestBody Person person) {
        try {
            Person p = personService.findByName( person );
            System.out.println( p );
            return ResultUtil.success( p );
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error( ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getMsg() );
        }
    }

    @RequestMapping("/delAll")
    public String del(@RequestBody List <Integer> id) {
        try {
            List <Person> list = personService.deleteAllInBatch( id );
            return ResultUtil.success( list );
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error( ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getMsg() );
        }
    }

    @RequestMapping("/like")
    public String findByNameLike(@RequestBody Person person) {
        try {
            List <Person> list = personService.findByNameLike( person );
            return ResultUtil.success( list );
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error( ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getMsg() );
        }
    }

    @RequestMapping("/nameAndaddress")
    public String findByNameAndAddress(@RequestBody Person person) {
        try {
            Person list = personService.findnameandaddress( person );
            return ResultUtil.success( list );
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error( ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getMsg() );
        }
    }
}
