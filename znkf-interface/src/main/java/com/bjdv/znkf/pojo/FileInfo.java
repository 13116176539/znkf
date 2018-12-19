package com.bjdv.znkf.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.bjdv.znfk.utils.DateUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "file_info")
public class FileInfo extends BasePo implements Serializable {
    private static final long serialVersionUID = 1L;

    //文件资源ID ，绑定业务来源的ID
    @NonNull
    @Column(name = "resource_id")
    private String resourceId;

    @NonNull//上传后的文件名
    @Column(name = "file_name")
    private String fileName;

    @NonNull//原文件名
    @Column(name = "file_origin_name")
    private String fileOriginName;

    @JsonIgnore//文件路径
    @Column(name = "file_path")
    private String filePath;

    @Column(name = "md5")
    private String md5;

    @JsonIgnore//文件类型
    @Column(name = "file_type")
    private String fileType;

    @Column(nullable = false, name = "size")
    private Long size; //文件大小

    // 文件是否后效 true/1: 有效 ; false/0 : 无效
    @JsonIgnore
    @Column(length = 2, name = "valid")
    private Boolean valid = true;

    // 是否删除文件
    @JsonIgnore
    @Column(length = 2, name = "is_delete")
    private Boolean isDelete = false;

    @NonNull//图片上传时间
    @Column(name = "upload_time")
    private String uploadTime = DateUtils.getDateString( new Date() );

    @NonNull//图片删除时间
    @Column(name = "delete_time")
    private String deleteTime;

    @JSONField(serialize = false)
    @Transient
    private InputStream content;
}
