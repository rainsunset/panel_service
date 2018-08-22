package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
/**
 * @author wuhaosoft
 * @version $Id WeiXinopen.java, 2018-08-22 17:12:45 wuhaosoft Exp
 *
 */
@ApiModel(description = "微信用户表")
public class WeiXinopen {

    @ApiModelProperty(value = "111111")
    private Integer  weiXinopen;

    @ApiModelProperty(value = "userId")
    private String userId;

    @ApiModelProperty(value = "num")
    private Integer num;

    public WeiXinopen(){}

    public WeiXinopen(
        Integer  weiXinopen,
        String userId,
        Integer num
    ) {
        this.userId = userId;
        this.num = num;
    }

    public Integer  getWeiXinopen(){
        return weiXinopen;
    }

    public void setWeiXinopen(Integer  weiXinopen) {
        this.weiXinopen = weiXinopen;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String  userId) {
        this.userId = userId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer  num) {
        this.num = num;
    }

}



