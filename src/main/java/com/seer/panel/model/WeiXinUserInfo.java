package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
/**
 * @author wuhaosoft
 * @version $Id WeiXinUserInfo.java, 2018-08-22 17:12:45 wuhaosoft Exp
 *
 */
@ApiModel(description = "用户微信帐号（OpenId）")
public class WeiXinUserInfo {

    @ApiModelProperty(value = "111111")
    private Integer  weiXinUserInfo;

    @ApiModelProperty(value = "userId")
    private String userId;

    @ApiModelProperty(value = "num")
    private Integer num;

    public WeiXinUserInfo(){}

    public WeiXinUserInfo(
        Integer  weiXinUserInfo,
        String userId,
        Integer num
    ) {
        this.userId = userId;
        this.num = num;
    }

    public Integer  getWeiXinUserInfo(){
        return weiXinUserInfo;
    }

    public void setWeiXinUserInfo(Integer  weiXinUserInfo) {
        this.weiXinUserInfo = weiXinUserInfo;
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



