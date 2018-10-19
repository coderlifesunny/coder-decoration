package com.decoration.web.base;

import com.decoration.common.constants.Constants;
import com.decoration.common.entity.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * Description: 主材料web接口
 *
 * @Author Guangcai.xu
 * @Date 2018/10/19 15:49
 */
@Slf4j
public abstract class BaseController {

    /**
     * 返回成功，用于查询操作
     * json : {
     * "success" : true,
     * "data" : {}
     * }
     *
     * @param data
     * @param <T>
     * @return
     */
    protected <T> HttpResult<T> success(String msg, T data) {
        return new HttpResult<>(Constants.ReturnCode.SUCCESS, msg, data);
    }

    /**
     * 返回成功，用于insert or update or delete相关操作
     * json :{
     * "success":true,
     * "msg":""
     * }
     *
     * @param <T>
     * @return
     */
    protected <T> HttpResult<T> success(T data) {
        return success(null, data);
    }

    /**
     * 返回成功，用于insert or update or delete相关操作
     * json :{
     * "success":true,
     * "msg":""
     * }
     *
     * @param <T>
     * @return
     */
    protected <T> HttpResult<T> success() {
        return success(null);
    }

    protected HttpResult successMsg(String msg) {
        return success(msg, null);
    }

    /**
     * 返回失败，用于系统异常
     *
     * @param
     * @param <T>
     * @return
     */
    protected <T> HttpResult<T> error(String msg) {
        return new HttpResult<>(Constants.ReturnCode.SYSTEM_ERR, msg, null);
    }

    /**
     * 返回失败，参数错误
     *
     * @param
     * @param <T>
     * @return
     */
    protected <T> HttpResult<T> errorParam(String msg) {
        return new HttpResult<>(Constants.ReturnCode.PARAM_EXCEPTION_ERR, msg, null);
    }

    /**
     * 返回失败，业务数据错误
     *
     * @param msg
     * @param <T>
     * @return
     */
    protected <T> HttpResult<T> errorBusiness(String msg) {
        return new HttpResult<>(Constants.ReturnCode.BUSINESS_EXCEPTION_ERR, msg, null);
    }

    /**
     * 返回失败，资源找不到
     *
     * @param msg
     * @param <T>
     * @return
     */
    protected <T> HttpResult<T> errorNotFound(String msg) {
        return new HttpResult<>(Constants.ReturnCode.NOT_FOUND_ERR, msg, null);
    }

    /**
     * 下载静态文件,导入模板等，文件统一放在web模块的static目录下
     *
     * @param fileName
     * @return
     */
    protected ResponseEntity<Resource> downloadStaticFile(String relativePath, String fileName) {
        Resource resource = new ClassPathResource(relativePath + fileName);
        String temp = encodeURIComponent(fileName);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment;fileName=\"" + temp + "\";" + "filename*=utf-8''" + temp).body(resource);
    }

    private static String encodeURIComponent(String value) {
        try {
            return URLEncoder.encode(value, "UTF-8").replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException e) {
            return value;
        }
    }

    /**
     * 设置附件名称
     *
     * @param response
     * @param name
     * @return
     */
    public void setAttachmentHeader(HttpServletResponse response, String name) {
        String temp = encodeURIComponent(name);
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=\"" + temp + "\";" + "filename*=utf-8''" + temp);
    }

    /**
     * 下载时
     *
     * @param response
     */
    protected void outPutStream(HttpServletResponse response, File file) {
        try (InputStream inputStream = new FileInputStream(file); OutputStream os = response.getOutputStream()) {

            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
                os.flush();
            }
        } catch (IOException e) {
            log.warn("IOException:导出数据问题：[{}]", e.getMessage(), e);
        }
    }


}
