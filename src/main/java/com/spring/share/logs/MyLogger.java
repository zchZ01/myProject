package com.spring.share.logs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 日志输出
 */
public class MyLogger {

    /** Logger实例 */
    static final Logger logger = LoggerFactory.getLogger(MyLogger.class);

    /**
     * 自定info
     * @param msg
     */
    public static void info(String msg){
        logger.info(msg);
    }

    /**
     * 自定warn
     * @param msg
     */
    public static void warn(String msg){
        logger.warn(msg);
    }

    /**
     * 自定error
     * @param msg
     */
    public static void error(String msg){
        logger.error(msg);
    }
}
