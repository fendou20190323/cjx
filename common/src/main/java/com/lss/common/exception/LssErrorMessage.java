package com.lss.common.exception;

public interface LssErrorMessage {
    /**
     * 公共模块名
     */
    String MODULE_NAME = "lssplatform";

    /**
     * 通用错误信息
     */
    String ERROR_MESSAGE_CODE = "000000";


    /**
     * 插入错误信息
     */
    String NOT_INSERT_CODE = "000001";
    String NOT_INSERT_MESSAGE = "没有插入任何数据";

    /**
     * 更新错误信息
     */
    String NOT_UPDATE_CODE = "000002";
    String NOT_UPDATE_MESSAGE = "没有更新任何数据";

    /**
     * 逻辑删除错误信息
     */
    String NOT_DELETE_CODE = "000003";
    String NOT_DELETE_MESSAGE = "没有删除任何数据";

    /**
     * 插入失败错误
     */
    String CODE_CREATE_CODE = "000004";
    String CODE_CREATE_MESSAGE = "数据插入失败";

    /**
     * 编码生成错误
     */
    String CODE_CREATETIMEOUT_CODE = "000005";
    String CODE_CREATETIMEOUT_MESSAGE = "编码生成超时";

    /**
     * 卡密不正确
     */
    String CARDPWD_ERROR_CODE = "000006";
    String CARDPWD_ERROR_MESSAGE = "卡密不正确";

    /**
     * 充值卡已经被其他用户使用
     */
    String CARDWRITE_ERROR_CODE = "000007";
    String CARDWRITE_ERROR_MESSAGE = "充值卡已经被其他用户使用";

    /**
     * 找不到信息错误
     */
    String NOT_FIND_CODE = "000008";
    String NOT_FIND_MESSAGE = "当前条件找不到数据";

    /**
     * 找不到信息错误
     */
    String UPDATE_ORDERTYPE_CODE = "000009";
    String UPDATE_ORDERTYPE_MESSAGE = "更新订单状态失败";

    /**
     * 找不到信息错误
     */
    String MONEY_NOTEQUAL_CODE = "000010";
    String MONEY_NOTEQUAL_MESSAGE = "金额不匹配";

    /**
     * 插入错误信息
     */
    String DOUBLE_INSERT_CODE = "000011";
    String DOUBLE_INSERT_MESSAGE = "编码重复";

    /**
     * 无可用数据操作
     */
    String NOT_OPERATION_CODE = "000012";
    String NOT_OPERATION_MESSAGE = "无可用数据可以操作";

    /**
     * 未找到错误编码对应的消息
     */
    String NOT_FOUND_MESSAGE = "未找到此错误编码信息，请到【{0}-message.properties】中进行配置";


    /**
     * 文件[{0}]读取/写入失败
     */
    String FILE_IO_ERROR = "100001";
    /**
     * 读取的[{0}]文件不存在
     */
    String FILE_NOT_FOUND_ERROR = "100002";
    /**
     * 缓存引擎{0}初始化失败，对应实现类{1}无法创建
     */
    String CACHE_ERROR_100101 = "100101";
    /**
     * 缓存配置文件{0}加载失败
     */
    String CACHE_ERROR_100102 = "100102";
    /**
     * 缓存引擎未初始化
     */
    String CACHE_ERROR_100103 = "100103";
    /**
     * 缓存项目{0}对应的缓存容器{1}未配置
     */
    String CACHE_ERROR_100104 = "100104";
    /**
     * 缓存引擎{0}初始化失败，对应实现类{1}不存在
     */
    String CACHE_ERROR_100105 = "100105";
    /**
     * 缓存项目{0}未在classpath的[cfgCache.xml]配置文件中配置
     */
    String CACHE_ERROR_100106 = "100106";
    /**
     * 从{0}缓存引擎中读取缓存项目{1}失败
     */
    String CACHE_ERROR_100107 = "100107";

    ////////////////////////////////////
    /**
     * [{0}]报文转换错误
     */
    String ERROR_MESSAGE_100201 = "100201";
    /**
     * {0}不是有效的{1}编码
     */
    String ERROR_MESSAGE_100202 = "100202";
    /**
     * XmlBean初始化，XmlNode不能为null
     */
    String ERROR_MESSAGE_100301 = "100301";
    /**
     * XmlBean初始化，XmlNode长度必须为1
     */
    String ERROR_MESSAGE_100302 = "100302";
    /**
     * 空字符串不能初始化XmlBean
     */
    String ERROR_MESSAGE_100303 = "100303";
    /**
     * Xml字符串构造XmlBean错误，xml字符串为[{0}]
     */
    String ERROR_MESSAGE_100304 = "100304";
    /**
     * XmlBean中格式化时间[{0}]异常
     */
    String ERROR_MESSAGE_100305 = "100305";

}
