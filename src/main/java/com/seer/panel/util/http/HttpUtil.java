package com.seer.panel.util.http;

import com.seer.panel.util.http.okhttp.OKHttpFactory;
import okhttp3.*;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * 网络请求接口
 * @author : ligangwei / ligangwei@seerbigdata.com
 * @version : 1.0
 */
public class HttpUtil {

    /**
     * mLogger
     */
    private final static Logger mLogger = Logger.getLogger(HttpUtil.class);

    //region 同步请求

    /**
     * HTTP 同步GET请求
     *
     * @param url url
     * @return String string
     * @throws IOException the io exception
     * @author : ligangwei / 2018-12-29
     */
    public static String httpGetString(String url) throws IOException {
        return httpGetString(url, null, null);
    }

    /**
     * HTTP 同步GET请求
     *
     * @param url url
     * @param headers header
     * @param params 请求参数
     * @return String string
     * @throws IOException the io exception
     * @author : ligangwei / 2018-12-29
     */
    public static String httpGetString(String url, Map<String, String> headers, Map<String, String> params) throws
            IOException {
        OkHttpClient okHttpClient = OKHttpFactory.INSTANCE.getOkHttpClient();
        Request.Builder builder = new Request.Builder();
        if (headers != null && headers.size()>0){
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                builder.addHeader(entry.getKey(), entry.getValue());
            }
        }

        StringBuilder urlBuilder = new StringBuilder(url);
        if (params != null && params.size() >0){
            urlBuilder.append("?");
            for (Map.Entry<String, String> entry : params.entrySet()) {
                urlBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            urlBuilder.substring(0, urlBuilder.length()-1);
        }
        mLogger.info(String.format("======>request url:%s", urlBuilder.toString()));
        builder.url(urlBuilder.toString());

        Response response = okHttpClient.newCall(builder.build()).execute();
        if (response.isSuccessful()){
            return response.body().string();
        }
        return null;
    }

    /**
     * HTTP 同步GET请求
     *
     * @param url url
     * @return inputStream input stream
     * @throws IOException the io exception
     * @author : ligangwei / 2018-12-29
     */
    public static InputStream httpGetInputStream(String url) throws IOException {
        return httpGetInputStream(url, null, null);
    }

    /**
     * HTTP 同步GET请求
     *
     * @param url url
     * @param headers header
     * @param params 请求参数
     * @return inputStream input stream
     * @throws IOException the io exception
     * @author : ligangwei / 2018-12-29
     */
    public static InputStream httpGetInputStream(String url, Map<String, String> headers, Map<String, String> params) throws
            IOException {
        OkHttpClient okHttpClient = OKHttpFactory.INSTANCE.getOkHttpClient();
        Request.Builder builder = new Request.Builder();
        if (headers != null && headers.size()>0){
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                builder.addHeader(entry.getKey(), entry.getValue());
            }
        }

        StringBuilder urlBuilder = new StringBuilder(url);
        if (params != null && params.size() >0){
            urlBuilder.append("?");
            for (Map.Entry<String, String> entry : params.entrySet()) {
                urlBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            urlBuilder.substring(0, urlBuilder.length()-1);
        }
        mLogger.info(String.format("======>request url:%s", urlBuilder.toString()));
        builder.url(urlBuilder.toString());

        Response response = okHttpClient.newCall(builder.build()).execute();
        if (response.isSuccessful()){
            return response.body().byteStream();
        }
        return null;
    }

    /**
     * HTTP 同步GET请求
     *
     * @param url url
     * @param headers header
     * @param params 请求参数
     * @return response response
     * @throws IOException the io exception
     * @author : ligangwei / 2018-12-29
     */
    public static Response httpGetResponse(String url, Map<String, String> headers, Map<String, String> params) throws
            IOException {
        OkHttpClient okHttpClient = OKHttpFactory.INSTANCE.getOkHttpClient();
        Request.Builder builder = new Request.Builder();
        if (headers != null && headers.size()>0){
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                builder.addHeader(entry.getKey(), entry.getValue());
            }
        }

        StringBuilder urlBuilder = new StringBuilder(url);
        if (params != null && params.size() >0){
            urlBuilder.append("?");
            for (Map.Entry<String, String> entry : params.entrySet()) {
                urlBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            urlBuilder.substring(0, urlBuilder.length()-1);
        }
        mLogger.info(String.format("======>request url:%s", urlBuilder.toString()));
        builder.url(urlBuilder.toString());

        Response response = okHttpClient.newCall(builder.build()).execute();
        return response;
    }

    /**
     * HTTP 同步POST请求
     *
     * @param url url
     * @param mediaType Content-Type
     * @param postBody 请求体(字符串)
     * @return String string
     * @throws IOException the io exception
     * @author : ligangwei / 2018-12-29
     */
    public static String httpPostString(String url, String mediaType, String postBody) throws IOException {
        return httpPostString(url, mediaType, postBody, null, null);
    }

    /**
     * HTTP 同步POST请求
     *
     * @param url url
     * @param mediaType Content-Type
     * @param postBody 请求体(字符串)
     * @param params the params
     * @param headers header
     * @return String string
     * @throws IOException the io exception
     * @author : ligangwei / 2018-12-29
     */
    public static String httpPostString(String url, String mediaType, String postBody, Map<String, String> params, Map<String, String> headers) throws
            IOException {
        MediaType mime = MediaType.parse(mediaType);
        if (mime == null){
            mLogger.info("======>Media type parse failed");
            return null;
        }
        OkHttpClient okHttpClient = OKHttpFactory.INSTANCE.getOkHttpClient();
        //Header
        Request.Builder builder = new Request.Builder();
        if (headers != null && headers.size()>0){
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                builder.addHeader(entry.getKey(), entry.getValue());
            }
        }
        //URL
        StringBuilder urlBuilder = new StringBuilder(url);
        if (params != null && params.size() > 0){
            urlBuilder.append("?");
            for (Map.Entry<String, String> entry : params.entrySet()) {
                urlBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            urlBuilder.substring(0, urlBuilder.length() - 1);
        }
        builder.url(urlBuilder.toString());

        //Post body
        RequestBody requestBody = RequestBody.create(mime, postBody);
        builder.post(requestBody);

        Response response = okHttpClient.newCall(builder.build()).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        }
        return null;
    }

    /**
     * HTTP 同步POST请求
     *
     * @param url url
     * @param mediaType Content-Type
     * @param postBody 请求体(字节流)
     * @return String string
     * @throws IOException the io exception
     * @author : ligangwei / 2018-12-29
     */
    public static String httpPostStream(String url, String mediaType, byte[] postBody) throws IOException {
        return httpPostStream(url, mediaType, postBody, null, null);
    }

    /**
     * HTTP 同步POST请求
     *
     * @param url url
     * @param mediaType Content-Type
     * @param postBody 请求体(字节流)
     * @param params the params
     * @param headers header
     * @return String string
     * @throws IOException the io exception
     * @author : ligangwei / 2018-12-29
     */
    public static String httpPostStream(String url, String mediaType, byte[] postBody, Map<String, String> params, Map<String, String> headers) throws
            IOException {
        MediaType mime = MediaType.parse(mediaType);
        if (mime == null){
            mLogger.info("======>Media type parse failed");
            return null;
        }

        OkHttpClient okHttpClient = OKHttpFactory.INSTANCE.getOkHttpClient();
        //Header
        Request.Builder builder = new Request.Builder();
        if (headers != null && headers.size()>0){
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                builder.addHeader(entry.getKey(), entry.getValue());
            }
        }
        //URL
        StringBuilder urlBuilder = new StringBuilder(url);
        if (params != null && params.size() > 0){
            urlBuilder.append("?");
            for (Map.Entry<String, String> entry : params.entrySet()) {
                urlBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            urlBuilder.substring(0, urlBuilder.length() - 1);
        }
        builder.url(urlBuilder.toString());
        //Post body
        RequestBody requestBody = RequestBody.create(mime, postBody);
        builder.post(requestBody);

        Response response = okHttpClient.newCall(builder.build()).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        }
        return null;
    }

    /**
     * HTTP 同步POST请求
     *
     * @param url url
     * @param mediaType Content-Type
     * @param file 请求体(文件)
     * @return String string
     * @throws IOException the io exception
     * @author : ligangwei / 2018-12-29
     */
    public static String httpPostFile(String url, String mediaType, File file) throws IOException {
        return httpPostFile(url, mediaType, file, null, null);
    }

    /**
     * HTTP 同步POST请求
     *
     * @param url url
     * @param mediaType Content-Type
     * @param file 请求体(文件)
     * @param params the params
     * @param headers header
     * @return String string
     * @throws IOException the io exception
     * @author : ligangwei / 2018-12-29
     */
    public static String httpPostFile(String url, String mediaType, File file, Map<String, String> params, Map<String, String> headers) throws
            IOException {
        MediaType mime = MediaType.parse(mediaType);
        if (mime == null){
            mLogger.info("======>Media type parse failed");
            return null;
        }

        OkHttpClient okHttpClient = OKHttpFactory.INSTANCE.getOkHttpClient();
        //Header
        Request.Builder builder = new Request.Builder();
        if (headers != null && headers.size()>0){
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                builder.addHeader(entry.getKey(), entry.getValue());
            }
        }
        //URL
        StringBuilder urlBuilder = new StringBuilder(url);
        if (params != null && params.size() > 0){
            urlBuilder.append("?");
            for (Map.Entry<String, String> entry : params.entrySet()) {
                urlBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            urlBuilder.substring(0, urlBuilder.length() - 1);
        }
        builder.url(urlBuilder.toString());
        //Post body
        RequestBody requestBody = RequestBody.create(mime, file);
        builder.post(requestBody);

        Response response = okHttpClient.newCall(builder.build()).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        }
        return null;
    }

    /**
     * HTTP 同步POST请求
     *
     * @param url url
     * @param formData 请求体(表单)
     * @return String string
     * @throws IOException the io exception
     * @author : ligangwei / 2018-12-29
     */
    public static String httpPostForm(String url, Map<String, String> formData) throws IOException {
        return httpPostForm(url, formData, null, null);
    }

    /**
     * HTTP 同步POST请求
     *
     * @param url url
     * @param formData 请求体(表单)
     * @param params the params
     * @param headers header
     * @return String string
     * @throws IOException the io exception
     * @author : ligangwei / 2018-12-29
     */
    public static String httpPostForm(String url, Map<String, String> formData, Map<String, String> params, Map<String, String> headers) throws
            IOException {
        OkHttpClient okHttpClient = OKHttpFactory.INSTANCE.getOkHttpClient();

        //Header
        Request.Builder builder = new Request.Builder();
        if (headers != null && headers.size()>0){
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                builder.addHeader(entry.getKey(), entry.getValue());
            }
        }
        //URL
        StringBuilder urlBuilder = new StringBuilder(url);
        if (params != null && params.size() > 0){
            urlBuilder.append("?");
            for (Map.Entry<String, String> entry : params.entrySet()) {
                urlBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            urlBuilder.substring(0, urlBuilder.length() - 1);
        }
        builder.url(urlBuilder.toString());
        //Post body
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        if (formData != null && formData.size() > 0){
            for (Map.Entry<String, String> entry : formData.entrySet()) {
                formBodyBuilder.add(entry.getKey(), entry.getValue());
            }
        }
        FormBody requestBody = formBodyBuilder.build();
        builder.post(requestBody);

        Response response = okHttpClient.newCall(builder.build()).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        }
        return null;
    }

    /**
     * HTTP 同步POST请求
     *
     * @param url url
     * @param postBody 请求体(多请求块)                 通过MultipartBody.Builder的addFormDataPart构造请求体
     * @return String string
     * @throws IOException the io exception
     * @author : ligangwei / 2018-12-29
     */
    public static String httpPostMultiPart(String url, MultipartBody postBody) throws IOException {
        return httpPostMultiPart(url, postBody, null, null);
    }

    /**
     * HTTP 同步POST请求
     *
     * @param url url
     * @param postBody 请求体(多请求块)                 通过MultipartBody.Builder的addFormDataPart构造请求体
     * @param params the params
     * @param headers header
     * @return String string
     * @throws IOException the io exception
     * @author : ligangwei / 2018-12-29
     */
    public static String httpPostMultiPart(String url, MultipartBody postBody, Map<String, String> params, Map<String, String> headers) throws
            IOException {
        OkHttpClient okHttpClient = OKHttpFactory.INSTANCE.getOkHttpClient();

        //Header
        Request.Builder builder = new Request.Builder();
        if (headers != null && headers.size()>0){
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                builder.addHeader(entry.getKey(), entry.getValue());
            }
        }
        //URL
        StringBuilder urlBuilder = new StringBuilder(url);
        if (params != null && params.size() > 0){
            urlBuilder.append("?");
            for (Map.Entry<String, String> entry : params.entrySet()) {
                urlBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            urlBuilder.substring(0, urlBuilder.length() - 1);
        }
        builder.url(urlBuilder.toString());
        //Post body
        builder.post(postBody);

        Response response = okHttpClient.newCall(builder.build()).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        }
        return null;
    }
    //endregion

    //region 异步请求
    //TODO:异步请求封装
    //endregion
}
