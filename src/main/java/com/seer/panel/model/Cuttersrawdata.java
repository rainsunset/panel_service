package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
/**
 * @author wuhaosoft
 * @version $Id Cuttersrawdata.java, 2018-08-22 17:12:43 wuhaosoft Exp
 *
 */
@ApiModel(description = "断刀原始数据")
public class Cuttersrawdata {

    @ApiModelProperty(value = "111111")
    private Integer  cuttersrawdata;

    @ApiModelProperty(value = "userId")
    private String userId;

    @ApiModelProperty(value = "num")
    private Integer num;

    public Cuttersrawdata(){}

    public Cuttersrawdata(
        Integer  cuttersrawdata,
        String userId,
        Integer num
    ) {
        this.userId = userId;
        this.num = num;
    }

    public Integer  getCuttersrawdata(){
        return cuttersrawdata;
    }

    public void setCuttersrawdata(Integer  cuttersrawdata) {
        this.cuttersrawdata = cuttersrawdata;
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



