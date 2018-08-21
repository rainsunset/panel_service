/**
 * Company
 * Copyright (C) 2004-2018 All Rights Reserved.
 */
package com.seer.panel.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.seer.panel.exception.ErrorInfoInterface;

/**
 * @author ligw
 * @version $Id ResponseResult.java, v 0.1 2018-08-22 1:16 ligw Exp $$
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseResult<T> {

    private boolean success;

    private String message;

    private T data;

    private String errorcode;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    public ResponseResult() {
    }

    public ResponseResult(ErrorInfoInterface errorInfo) {
        this.setSuccess(false);
        this.setErrorcode(errorInfo.getCode());
        this.setMessage(errorInfo.getMessage());
    }
}
