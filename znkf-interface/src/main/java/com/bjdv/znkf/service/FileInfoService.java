package com.bjdv.znkf.service;

import com.bjdv.znkf.pojo.FileInfo;
import com.bjdv.znkf.pojo.Upload;
import org.springframework.web.multipart.MultipartFile;

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
    *
    * @return
    */
   List<Upload> fileUpload(MultipartFile file,int visitorId, int agentId, String tag);



   boolean downloadFile(String fileName, HttpServletRequest request, HttpServletResponse response);


}
