package com.bjdv.znkf.controller;


import com.bjdv.znfk.utils.ResultEnum;
import com.bjdv.znfk.utils.ResultUtil;
import com.bjdv.znkf.pojo.Upload;
import com.bjdv.znkf.service.FileInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 〈文件上传〉
 *
 * @author hanxulei
 * @create 2018/9/7
 * @since 1.0.0
 */
@RestController
@Slf4j
public class CommonController {

    @Autowired
    @Qualifier("fileInfo")
    private FileInfoService fileuploadService;


    @Value("${basePath}")
    private String basePath;

    /**
     * 文件上传
     *
     * @param file
     * @param
     * @return
     */
    @RequestMapping("/upload_file")
    public String file(@RequestParam("file") MultipartFile file) {
        try {
            List <Upload> list = fileuploadService.fileUpload( file, 6, 2, "A" );
            return ResultUtil.success( list );
        } catch (Exception e1) {
            e1.printStackTrace();
            return ResultUtil.error( ResultEnum.UPLOAD_FILE_ERROR, "上传文件失败" );
        }
    }

    @RequestMapping("/download")
    public String downloadFile(String fileName, HttpServletRequest request, HttpServletResponse response) {
        try {
            boolean b = fileuploadService.downloadFile( fileName, request, response );
            return ResultUtil.success( b );
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error( ResultEnum.DOWNLOADFILE_FILE_ERROR, "下载文件失败" );
        }
    }
}

