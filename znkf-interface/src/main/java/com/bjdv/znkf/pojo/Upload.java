package com.bjdv.znkf.pojo;

/**
 * @param
 * @return
 * @author hanxulei
 * @create 2018/9/10
 */

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 〈文件路径地址〉
 *
 * @author hanxulei
 * @create 2018/9/10
 * @since 1.0.0
 */
@Entity
@Table(name = "Upload")
@Data
public class Upload implements Serializable {
    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private String id;
    //文件路径
    @Column(name = "url")
    private String url;
    //访客id
    @Column(name = "visitor_Id")
    private Integer visitorId;
    //坐席id
    @Column(name = "agent_id")
    private Integer agentId;
    //标识
    @Column(name = "tag")
    private String tag;
    //文件名称
    @Column(name = "file_name")
    private String fileName;
    /**
     * 文件后缀名
     */
    private String extensionName;

    private String date;
    //删除时间
    private String delDate;
    //删除状态0:不可用-1:可用
    private String delState;

}
