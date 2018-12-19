package com.bjdv.znkf.pojo;

/**
 * @param
 * @return
 * @author hanxulei
 * @create 2018/9/10
 */

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * 〈文件路径地址〉
 *
 * @author hanxulei
 * @create 2018/9/10
 * @since 1.0.0
 */
@Data
public class Upload implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    //文件路径
    private String url;
    //访客id
    private int visitorId;
    //坐席id
    private int agentId;
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
