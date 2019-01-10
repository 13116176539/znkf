package com.bjdv.znkf.pojo;

/**
 * @param
 * @return
 * @author hanxulei
 * @create 2018/9/10
 */

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


import javax.persistence.*;
import java.io.Serializable;

/**
 * 〈文件路径地址--存入mongodb中〉
 *
 * @author hanxulei
 * @create 2018/9/10
 * @since 1.0.0
 */
@Data
public class Upload_demo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    //文件路径
    private String url;
    //访客id
    private Integer visitorId;
    //坐席id
    private Integer agentId;
    //标识
    private String tag;
    //文件名称
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
