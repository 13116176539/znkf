package com.bjdv.znkf.dao;

import com.bjdv.znkf.pojo.Person;
import com.bjdv.znkf.pojo.Upload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 〈文件上传〉
 *
 * @author hanxulei
 * @create 2018/12/7
 * @since 1.0.0
 */
@Repository
public interface FileInfoRepository extends JpaRepository <Upload, Long>, JpaSpecificationExecutor <Upload> {

}
