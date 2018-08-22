package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
/**
 * @author wuhaosoft
 * @version $Id Acquisitioncard.java, 2018-08-22 17:12:42 wuhaosoft Exp
 *
 */
@ApiModel(description = "采集卡信息")
public class Acquisitioncard {

    @ApiModelProperty(value = "111111")
    private Integer  acquisitioncard;

    @ApiModelProperty(value = "userId")
    private String userId;

    @ApiModelProperty(value = "num")
    private Integer num;

    public Acquisitioncard(){}

    public Acquisitioncard(
        Integer  acquisitioncard,
        String userId,
        Integer num
    ) {
        this.userId = userId;
        this.num = num;
    }

    public Integer  getAcquisitioncard(){
        return acquisitioncard;
    }

    public void setAcquisitioncard(Integer  acquisitioncard) {
        this.acquisitioncard = acquisitioncard;
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



