package com.bjdv.znfk.utils;


/**
 * @author ResultEnum
 * @date 2018/8/20 9:32
 */
public enum ResultEnum {

    SUCCESS( 200, "SUCCESS" ), FAIL( 201, "FAIL" );

    //用户名不存在
    public final static int NAME_NOT_EXIST = 202;
    //用户名或密码错误
    public final static int NAME_OR_PASSWORD_ERROR = 203;

    //用户新建或修改数据成功
    // public final static int STATUS_CHANGE_ERROR = 201;
    //表示一个请求已经进入后天排队
    //用户删除数据成功
    public final static int LOG_OUT_ERROR = 204;
    //状态变更出错
    public final static int STATUS_CHANGE_ERROR = 205;
    //识别出错
    public final static int DISTINGUISH_ERROR = 206;
    //查询服务队列失败
    public final static int GET_QUEUE_ERROR = 207;
    //访客信息获取失败
    public final static int GET_USER_ERROR = 208;
    //编辑访客信息失败
    public final static int EDIT_USER_ERROR = 209;
    //增加工单信息出错
    public final static int ADD_ORDER_ERROR = 210;
    //上传文件失败
    public final static int UPLOAD_FILE_ERROR = 211;
    //满意度评价提交失败
    public final static int SATISFACTION_SUBMIT_ERROR = 212;
    //可转接坐席查询失败
    public final static int TRANSFERABLE_AGENT_QUERY_FAIL = 213;
    //
    public final static int LAST_CONVERSATION_QUERY_FAIL = 214;
    //历史工单查询失败
    public final static int HISTORICAL_ORDER_QUERY_FAIL = 215;
    //选择服务队列失败
    public final static int CHOOSE_QUEUE_ERROR = 216;
    /**
     * 访客留言提交失败
     */
    public final static int MESSAGE_SUBMISSION_FAILED = 217;
    //常用语查询失败
    public final static int COMMON_LANGUAGE_QUERY = 218;
    /**
     * 添加租户配置失败
     */
    public final static int SAVE_TENANT_FAIL = 219;
    //删除文件失败
    public final static int DELECT_FILE_ERROR = 220;
    /**
     * 添加租户配置失败
     */
    public final static int FIND_TENANT_FAIL = 221;
    /**
     * 初始化失败
     */
    public final static int INIT_SYSTEM_FAIL = 222;

    /**
     * 上传文件失败
     */
    public final static int DOWNLOADFILE_FILE_ERROR = 211;

    //用户发出的请求有错误，服务器没有进行新建或修改数据的操作，该操作是幂等的
    public final static int INVALID_REQUEST = 400;
    //表示用户没有权限（令牌、用户名、密码错误）
    public final static int UNAUTHORIZED = 401;
    //表示用户得到权限（与401错误相对），但是访问是被禁止的
    public final static int FORBIDDEN = 403;
    //没有找到（用户发出的请求针对的是不存在的记录，服务器没有进行操作，该操作是幂等的）
    public final static int NOT_FOUNT = 404;
    //(GET)用户请求的格式不可得（比如用户请求的json格式，但是只有XML格式）
    public final static int NOT_ACCEPTABLE = 406;
    //用户请求的资源被永久删除，且不会再得到的
    public final static int GONE = 410;
    //当创建一个对象时，发生一个验证错误
    public final static int UNPROCESABLE_ENTITY = 422;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
