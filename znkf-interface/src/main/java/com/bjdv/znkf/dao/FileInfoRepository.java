package com.bjdv.znkf.dao;

import com.bjdv.znkf.pojo.FileInfo;
import com.bjdv.znkf.pojo.Upload;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 〈文件上传〉
 *
 * @author hanxulei
 * @create 2018/12/7
 * @since 1.0.0
 */
public interface FileInfoRepository extends JpaRepository <Upload, Long> {

}
