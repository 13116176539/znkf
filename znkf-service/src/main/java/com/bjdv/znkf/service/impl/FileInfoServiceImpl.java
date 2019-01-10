package com.bjdv.znkf.service.impl;


import com.bjdv.znfk.utils.TimeUilt;
import com.bjdv.znkf.dao.FileInfoRepository;
import com.bjdv.znkf.pojo.UploadDTO;
import com.bjdv.znkf.pojo.Upload_demo;
import com.bjdv.znkf.service.FileInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
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
     * @param u
     * @return
     */
    @Override
    public List <Upload_demo> fileUpload(Upload_demo u) {
        Upload_demo upload = fileInfoRepository.save( u );
        List <Upload_demo> list = new ArrayList();
        list.add( upload );
        return list;
    }

    /**
     * 文集下载
     *
     * @param fileName
     * @return
     */
    @Override
    public Upload_demo downloadFile(String fileName) {
        Upload_demo upload_demo = fileInfoRepository.findByFileNameOrderByDateDesc( fileName );
        System.out.println( upload_demo );
        return upload_demo;
    }


}
