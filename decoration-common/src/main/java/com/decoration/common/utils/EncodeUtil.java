package com.decoration.common.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;

/**
 * Description: 加密工具类
 *
 * @Author Guangcai.xu
 * @Date 2018/11/21 16:35
 */
public class EncodeUtil {

    /**
     * md5加密
     *
     * @param str
     * @return
     */
    public static String md5Hex(String str) {
        String md5Hex = "";
        try {
            md5Hex = DigestUtils.md5Hex(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return md5Hex;

    }

    /**
     * sha1Hex加密
     *
     * @param str
     * @return
     */
    public static String sha1Hex(String str) {
        String sha1Hex = "";
        try {
            sha1Hex = DigestUtils.sha1Hex(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sha1Hex;
    }

    /**
     * base64编码
     *
     * @param str
     * @return
     */
    public static String encode64(String str) {
        try {
            Base64 base64 = new Base64();
            str = base64.encodeToString(str.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * base64解码
     *
     * @param str
     * @return
     */
    public static String decode64(String str) {
        try {
            str = new String(Base64.decodeBase64(str.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}