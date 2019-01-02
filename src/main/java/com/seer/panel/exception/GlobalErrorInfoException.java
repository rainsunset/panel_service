/**
 * Company
 * Copyright (C) 2004-2018 All Rights Reserved.
 */
package com.seer.panel.exception;

/**
 * @author ligw : ligangwei / ligangwei@seerbigdata.com
 * @version $Id GlobalErrorInfoException.java, v 0.1 2018-08-22 0:58 ligw Exp $$
 */
public class GlobalErrorInfoException extends RuntimeException{

    /**
     * Error info
     */
    private ErrorInfoInterface errorInfo;

    /**
     * Global error info exception.
     *
     * @param errorInfo the error info
     */
    public GlobalErrorInfoException (ErrorInfoInterface errorInfo) {
        this.errorInfo = errorInfo;
    }

    /**
     * Get error info error info interface.
     *
     * @return the error info interface
     * @author : ligangwei / 2018-12-29
     */
    public ErrorInfoInterface getErrorInfo() {
        return errorInfo;
    }

    /**
     * Sets error info.
     *
     * @param errorInfo the error info
     * @author : ligangwei / 2018-12-29
     */
    public void setErrorInfo(ErrorInfoInterface errorInfo) {
        this.errorInfo = errorInfo;
    }

}
