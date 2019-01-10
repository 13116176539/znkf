package com.bjdv.znkf.service;

import com.bjdv.znkf.pojo.UploadDTO;
import com.bjdv.znkf.pojo.Upload_demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 〈文件上传/下载〉
 *
 * @author hanxulei
 * @create 2018/12/7
 * @since 1.0.0
 */
public interface FileInfoService {


    /**
     * 2.13 文件上传
     * <p>
     * ,int visitorId, int agentId, String tag
     *
     * @return
     */
    List <Upload_demo> fileUpload(Upload_demo uploadDTO);


    Upload_demo downloadFile(String fileName);


}
