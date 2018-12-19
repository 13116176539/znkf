package com.bjdv.znkf.service;



import com.bjdv.znkf.pojo.Person;

import java.util.List;
import java.util.Optional;

/**
 * 〈〉
 *
 * @author hanxulei
 * @create 2018/9/24
 * @since 1.0.0
 */
public interface PersonService {

    List <Person> findAll();

    Optional <Person> findById(Person person);

    Person findByName(Person person);

    void updateById(Person id);

    List <Person> delectById(Person id);

    void saveInfo(Person person);

    List <Person> deleteAllInBatch(List <Integer> id);

    //使用like查询,name必须包含like中的%或者?
    List <Person> findByNameLike(Person person);

    Person findnameandaddress(Person person);
}
