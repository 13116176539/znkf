package com.bjdv.znkf.controller;


import com.alibaba.fastjson.JSONObject;
import com.bjdv.znfk.utils.*;
import com.bjdv.znkf.pojo.DownLoadVO;
import com.bjdv.znkf.pojo.UploadDTO;
import com.bjdv.znkf.pojo.Upload_demo;
import com.bjdv.znkf.service.FileInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
        System.out.println( "file name = " + file.getOriginalFilename() );
        try {
            File targetFile = new File( basePath );
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            //得到的文件并将其保存在某个地方;
            byte[] bytes = file.getBytes();
            // 获取文件名
            String fileNames = file.getOriginalFilename();
            //获取文件的后缀名
            String suffixName = fileNames.substring( fileNames.lastIndexOf( "." ) );
            String newFileName = UUIDUtil.getUUIDStr() + suffixName;
            System.out.println( newFileName );
            String fileAdd = FileUtils.isMeetConditions( suffixName, basePath );
            Path path = Paths.get( fileAdd + newFileName );
            Files.write( path, bytes );
            Upload_demo u = new Upload_demo();
            u.setVisitorId( 4 );
            u.setTag( "V" );
            u.setAgentId( 2 );
            u.setFileName( newFileName );
            u.setUrl( fileAdd );
            u.setExtensionName( suffixName );
            u.setDate( TimeUilt.getNowDate( new Date() ) );
            u.setDelDate( null );
            u.setDelState( "1" );
            List <Upload_demo> list = fileuploadService.fileUpload( u );
            return ResultUtil.success( list );
        } catch (Exception e1) {
            e1.printStackTrace();
            return ResultUtil.error( ResultEnum.UPLOAD_FILE_ERROR, "上传文件失败" );
        }
    }

    @RequestMapping("/download")
    public String downloadFile(@RequestBody DownLoadVO downLoadVO, HttpServletRequest request, HttpServletResponse response) {
        String fileName = downLoadVO.getFileName();
        System.out.println( fileName );
        Upload_demo upload_demo = fileuploadService.downloadFile( fileName );
        String realPath = upload_demo.getUrl();
        if (fileName != null) {
            File file = new File( realPath, fileName );
            if (file.exists()) {
                // 设置强制下载不打开
                response.setContentType( "application/force-download" );
                // 设置文件名
                response.addHeader( "Content-Disposition", "attachment;fileName=" + fileName );
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream( file );
                    bis = new BufferedInputStream( fis );
                    OutputStream os = response.getOutputStream();
                    int i = bis.read( buffer );
                    while (i != -1) {
                        os.write( buffer, 0, i );
                        i = bis.read( buffer );
                    }
                    System.out.println( "success" );
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
        return null;
    }
}

