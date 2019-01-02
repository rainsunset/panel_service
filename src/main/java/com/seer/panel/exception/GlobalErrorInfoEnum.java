/**
 * Company
 * Copyright (C) 2004-2018 All Rights Reserved.
 */
package com.seer.panel.exception;

/**
 * @author ligw : ligangwei / ligangwei@seerbigdata.com
 * @version $Id GlobalErrorInfoEnum.java, v 0.1 2018-08-22 1:03 ligw Exp $$
 */
public enum GlobalErrorInfoEnum implements ErrorInfoInterface{

    /**
     * Success global error info enum.
     */
//regain
    // 全局系统异常 占用范围-999 -- 1000
    SUCCESS("0", "success"),
    /**
     * System error global error info enum.
     */
    SYSTEM_ERROR("-100","系统异常") ,
    /**
     * Parame exception global error info enum.
     */
    PARAME_EXCEPTION("999","参数异常")
    //endregain

    ;

    /**
     * Code
     */
    private String code;

    /**
     * Message
     */
    private String message;

    /**
     * Global error info enum.
     *
     * @param code the code
     * @param message the message
     */
    GlobalErrorInfoEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Set message.
     *
     * @param msgs the msgs
     * @author : ligangwei / 2018-12-29
     */
    public void setMessage(String ... msgs){
        for(String msg:msgs){
            this.message=this.message.replaceFirst("#",msg);
        }
    }

    @Override public String getCode(){
        return this.code;
    }

    @Override public String getMessage(){
        return this.message;
    }

    /**
     * Get response msg global error info enum.
     *
     * @param code the code
     * @return the global error info enum
     * @author : ligangwei / 2018-12-29
     */
    public static GlobalErrorInfoEnum getResponseMsg(String code){
        for(GlobalErrorInfoEnum responseInfo:GlobalErrorInfoEnum.values()){
            if(code.equals(responseInfo.getCode())){
                return responseInfo;
            }
        }
        return SYSTEM_ERROR;
    }

}
