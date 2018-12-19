package com.bjdv.znkf.service.impl;


import com.bjdv.znfk.utils.FileUtils;
import com.bjdv.znfk.utils.TimeUilt;
import com.bjdv.znkf.dao.FileInfoRepository;
import com.bjdv.znkf.pojo.FileInfo;
import com.bjdv.znkf.pojo.Upload;
import com.bjdv.znkf.service.FileInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
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

/**
 * 〈文件上传/下载〉
 *
 * @author hanxulei
 * @create 2018/12/7
 * @since 1.0.0
 */
@Slf4j
@Service
public class FileInfoServiceImpl implements FileInfoService {

    @Value("${basePath}")
    private String basePath;

    @Autowired
    private FileInfoRepository fileInfoRepository;

    /**
     * 文件上传
     *
     * @param file
     * @param visitorId
     * @param agentId
     * @param tag
     * @return
     */
    @Override
    public List <Upload> fileUpload(MultipartFile file, int visitorId, int agentId, String tag) {
        List <Upload> list = new ArrayList();
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
            String fileAdd = FileUtils.isMeetConditions( suffixName, basePath );
            Path path = Paths.get( fileAdd + fileNames );
            Files.write( path, bytes );
            Upload u = new Upload();
            u.setVisitorId( visitorId );
            u.setTag( tag );
            u.setFileName( fileNames );
            u.setAgentId( agentId );
            u.setUrl( path.toString() );
            u.setDate( TimeUilt.getNowDate( new Date() ) );
            u.setDelDate( null );
            u.setDelState( "1" );
            u.setExtensionName( suffixName );
            Upload upload = fileInfoRepository.save( u );
            list.add( upload );
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    /**
     * 文集下载
     *
     * @param fileName
     * @param request
     * @param response
     * @return
     */
    @Override
    public boolean downloadFile(String fileName, HttpServletRequest request, HttpServletResponse response) {
        // 文件名
        if (fileName != null) {
            //设置文件路径
            File file = new File( fileName );
            //File file = new File(realPath , fileName);
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
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
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
        return false;
    }


}
