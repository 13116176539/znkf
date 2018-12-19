package com.bjdv.znkf.dao;


import com.bjdv.znkf.pojo.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * 〈〉
 *
 * @author hanxulei
 * @create 2018/9/24
 * @since 1.0.0
 */
@Repository
@Transactional
public interface PersonRepository extends JpaRepository<Person, Integer>, JpaSpecificationExecutor<Person> {

    @Query(value = "update Person p set p.name = ?1  where p.id = ?2", nativeQuery = true)
    @Modifying
    void updateById(String name, int id);

    /*模糊查询方法一*/
    @Query("SELECT u.name FROM Person u WHERE u.name LIKE CONCAT('%',:username,'%')")
    List <Person> findByNameLike(@Param("username") String username);

    /*模糊查询方法二*/
    List <Person> findByNameContaining(String name);

    //nativeQuery = true(本机查询-Spring Data JPA目前不支持对本机查询进行动态排序，因为它必须操纵声明的实际查询，这对于本机SQL无法可靠地执行。但是，您可以通过自己指定计数查询来使用本机查询进行分页)
    @Query(value = "select p from Person p where p.id=?1")
    Optional <Person> findById(int s);

    Person findByName(String name);

    Person findByNameAndAddress(String name, String address);

    //Page <Person> findById(String id, Pageable pageable);

    @Modifying
    @Transactional
    @Query("update Person a set a.delState = ?1  where a.id in ?2")
    int batchUpdate(Integer delState, List <Integer> id);


}
