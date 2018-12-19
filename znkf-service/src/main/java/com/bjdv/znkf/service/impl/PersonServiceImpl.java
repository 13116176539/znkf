package com.bjdv.znkf.service.impl;


import com.bjdv.znkf.dao.PersonRepository;
import com.bjdv.znkf.pojo.Person;
import com.bjdv.znkf.service.PersonService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 〈〉
 *
 * @author hanxulei
 * @create 2018/9/24
 * @since 1.0.0
 */
@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Resource
    private PersonRepository personRepository;

    @Override
    public List <Person> findAll() {
        //根据id排序,升序.
        Sort sort = new Sort( Sort.Direction.ASC, "id" );
        List <Person> list = personRepository.findAll( sort );
        List <Person> people = new ArrayList <>();
        for (int i = 0; i < list.size(); i++) {
            //System.out.println( list.get( i ) );
            if (list.get( i ).getDelState() != 0) {
                people.add( list.get( i ) );
            }
        }
        return people;
    }

    @Override
    public Optional <Person> findById(Person person) {
        Optional <Person> p = personRepository.findById( person.getId() );
        return p;
    }

    @Override
    public Person findByName(Person person) {
        Person p = personRepository.findByName( person.getName() );
        return p;
    }

    @Override
    public List <Person> findByNameLike(Person person) {
        // List <Person> list = personRepository.findByNameLike( person.getName() );
        List <Person> list = personRepository.findByNameContaining( person.getName() );
        return list;
    }

    @Override
    public Person findnameandaddress(Person person) {
        return personRepository.findByNameAndAddress( person.getName(), person.getAddress() );
    }

    @Override
    public void updateById(Person id) {
//            personRepository.updateById( id.getId(), id.getName() );
        Person person = new Person();
        person.setId( id.getId() );
        person.setName( id.getName() );
        person.setSex( id.getSex() );
        person.setAddress( id.getAddress() );
        person.setBirth( id.getBirth() );
        person.setZip( id.getZip() );
        person.setDelState( 1 );

        personRepository.save( person );
    }

    @Override
    public List <Person> delectById(Person person) {
        Person person1 = new Person();
        person1.setId( person.getId() );
        person1.setName( person.getName() );
        person1.setSex( person.getSex() );
        person1.setAddress( person.getAddress() );
        person1.setBirth( person.getBirth() );
        person1.setZip( person.getZip() );
        person1.setDelState( 0 );
        personRepository.save( person1 );
        List <Person> list = findAll();
        return list;
    }

    @Override
    public void saveInfo(Person person) {
        person.setDelState( 1 );
        personRepository.save( person );
    }

    @Override
    public List <Person> deleteAllInBatch(List <Integer> id) {
        int p = personRepository.batchUpdate( 0, id );
        //System.out.println( p );
        List <Person> list = findAll();
        return list;
    }


}
