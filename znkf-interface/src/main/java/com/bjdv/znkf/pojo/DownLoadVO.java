package com.bjdv.znkf.pojo;


import lombok.Data;

import java.io.Serializable;

/**
 * 〈〉
 *
 * @author hanxulei
 * @create 2019/1/9
 * @since 1.0.0
 */
@Data
public class DownLoadVO implements Serializable {
    private static final long serialVersionUID = 1L;
    String fileName;

    String realPath;
}
