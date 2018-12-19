package com.bjdv.znkf.pojo;


import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 〈〉
 *
 * @author hanxulei
 * @create 2018/9/24
 * @since 1.0.0
 */
@Entity
@Table(name = "person")
@Data
@DynamicUpdate
@DynamicInsert
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "sex")
    private String sex;

    @Column(name = "birth")//出生日期
    private String birth;

    @Column(name = "address")//地址
    private String address;

    @Column(name = "zip")//邮编
    private String zip;

    @Column(name = "del_State")//删除状态
    private Integer delState;



}
