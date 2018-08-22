package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
/**
 * @author wuhaosoft
 * @version $Id Woundwaresample.java, 2018-08-22 17:12:45 wuhaosoft Exp
 *
 */
@ApiModel(description = "虚拟发声波形样本数据")
public class Woundwaresample {

    @ApiModelProperty(value = "111111")
    private Integer  woundwaresample;

    @ApiModelProperty(value = "userId")
    private String userId;

    @ApiModelProperty(value = "num")
    private Integer num;

    public Woundwaresample(){}

    public Woundwaresample(
        Integer  woundwaresample,
        String userId,
        Integer num
    ) {
        this.userId = userId;
        this.num = num;
    }

    public Integer  getWoundwaresample(){
        return woundwaresample;
    }

    public void setWoundwaresample(Integer  woundwaresample) {
        this.woundwaresample = woundwaresample;
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



