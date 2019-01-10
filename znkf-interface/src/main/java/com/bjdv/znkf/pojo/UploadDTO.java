package com.bjdv.znkf.pojo;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 〈〉
 *
 * @author hanxulei
 * @create 2019/1/8
 * @since 1.0.0
 */
@Data
public class UploadDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
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
