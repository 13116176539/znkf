package com.bjdv.znkf.dao;

import com.bjdv.znkf.pojo.Upload_demo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 〈文件上传〉
 *
 * @author hanxulei
 * @create 2018/12/7
 * @since 1.0.0
 */
@Repository
public interface FileInfoRepository extends MongoRepository<Upload_demo, String> {

    Upload_demo findByFileNameOrderByDateDesc(String fileName);
}
