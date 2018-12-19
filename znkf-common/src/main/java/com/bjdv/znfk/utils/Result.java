package com.bjdv.znfk.utils;

/**
 * @author BaseResult
 * @date 2018/8/20 9:09
 */

import lombok.Data;

/**
 * 〈统一接口返回信息格式〉
 *
 * @author hanxulei
 * @create 2018/8/20
 * @since 1.0.0
 */
@Data
public class Result<T> {

    //状态码
    private Integer code;

    //提示信息
    private String message;

    //具体内容
    private T data;



}
