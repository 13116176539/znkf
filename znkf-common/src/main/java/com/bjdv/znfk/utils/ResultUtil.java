package com.bjdv.znfk.utils;

/**
 * @author ResultUtil
 * @date 2018/8/20 10:19
 */

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * 〈〉
 *
 * @author hanxulei
 * @create 2018/8/20
 * @since 1.0.0
 */
@Data
public class ResultUtil extends Exception {

    /**
     * 成功且带数据
     *
     * @param object
     * @return
     */
    public static String success(Object object) {
        Result result = new Result();
        result.setCode( ResultEnum.SUCCESS.getCode() );
        result.setMessage( ResultEnum.SUCCESS.getMsg() );
        result.setData( object );
        return JSON.toJSONString( result );
    }

    /**
     * 成功但不带数据
     *
     * @return
     */
    public static String success() {
        return success( null );
    }

    /**
     * 失败
     *
     * @param code
     * @param msg
     * @return
     */
    public static String error(Integer code, String msg) {
        Result result = new Result();
        result.setCode( code );
        result.setMessage( msg );
        return JSON.toJSONString( result );
    }
}
