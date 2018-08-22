package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
/**
 * @author wuhaosoft
 * @version $Id Acquisitioncardrunlog.java, 2018-08-22 17:12:43 wuhaosoft Exp
 *
 */
@ApiModel(description = "采集卡运行状态")
public class Acquisitioncardrunlog {

    @ApiModelProperty(value = "111111")
    private Integer  acquisitioncardrunlog;

    @ApiModelProperty(value = "userId")
    private String userId;

    @ApiModelProperty(value = "num")
    private Integer num;

    public Acquisitioncardrunlog(){}

    public Acquisitioncardrunlog(
        Integer  acquisitioncardrunlog,
        String userId,
        Integer num
    ) {
        this.userId = userId;
        this.num = num;
    }

    public Integer  getAcquisitioncardrunlog(){
        return acquisitioncardrunlog;
    }

    public void setAcquisitioncardrunlog(Integer  acquisitioncardrunlog) {
        this.acquisitioncardrunlog = acquisitioncardrunlog;
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



