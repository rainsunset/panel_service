/**
 * Company
 * Copyright (C) 2004-2018 All Rights Reserved.
 */
package com.seer.panel.exception;

/**
 * 错误码通用接口
 *
 * @author ligw : ligangwei / ligangwei@seerbigdata.com
 * @version $Id ErrorInfoInterface.java, v 0.1 2018-08-22 1:01 ligw Exp $$
 */
public interface ErrorInfoInterface {

    /**
     * Get code string.
     *
     * @return the string
     * @author : ligangwei / 2018-12-29
     */
    String getCode();

    /**
     * Get message string.
     *
     * @return the string
     * @author : ligangwei / 2018-12-29
     */
    String getMessage();

}
