package com.bjdv.znkf.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bjdv.znfk.utils.TimeUilt;
import com.bjdv.znkf.dao.FileInfoRepository;
import com.bjdv.znkf.pojo.UploadDTO;
import com.bjdv.znkf.pojo.Upload_demo;
import com.bjdv.znkf.service.FileInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileInfoServiceImplTest {

    @Autowired
    //@Qualifier("fileInfo")
    private FileInfoRepository fileInfoRepository;

    @Autowired
    @Qualifier("fileInfo")
    private FileInfoService fileInfoService;

    @Test
    public void fileUpload() {
        Upload_demo u = new Upload_demo();
        u.setVisitorId( 2 );
        u.setTag( "A" );
        u.setFileName( "JAS-39鹰狮战斗机飞机桌面壁纸" );
        u.setAgentId( 6 );
        u.setUrl( "F:/FileStorageF:/FileStorage/image/JAS-39鹰狮战斗机飞机桌面壁纸 - 1.jpg" );
        u.setDate( TimeUilt.getNowDate( new Date() ) );
        u.setDelDate( null );
        u.setDelState( "1" );
        u.setExtensionName( "jpg" );
        System.out.println( JSONObject.toJSONString( fileInfoService.fileUpload( u ) ) );
    }

    @Test
    public void downloadFile() {
        System.out.println( fileInfoService.downloadFile( "【周报】—韩旭雷2018年12月03日 至 12月07日.xlsx" ) );
    }
}
