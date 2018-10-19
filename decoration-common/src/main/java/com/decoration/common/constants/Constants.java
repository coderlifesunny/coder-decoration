package com.decoration.common.constants;

/**
 * Description:
 *
 * @Author Guangcai.xu
 * @Date 2018/10/19 15:47
 */
public class Constants {

    /**
     * 业务异常编码
     */
    public static class ReturnCode {
        /**
         * 正常code
         */
        public final static String SUCCESS = "2000";

        /**
         * 业务异常
         */
        public final static String BUSINESS_EXCEPTION_ERR = "3000";

        /**
         * 参数错误
         */
        public final static String PARAM_EXCEPTION_ERR = "4000";

        /**
         * 没有权限
         */
        public final static String PERMISSION_EXCEPTION_ERR = "4001";


        /**
         * 资源not found
         */
        public final static String NOT_FOUND_ERR = "4004";
        /**
         * 系统异常
         */
        public final static String SYSTEM_ERR = "5000";

        /**
         * 接口异常
         */
        public final static String RPC_EXCEPTION_ERR = "5004";
    }
}