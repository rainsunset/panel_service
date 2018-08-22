package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
/**
 * @author wuhaosoft
 * @version $Id Machinestatus.java, 2018-08-22 17:12:44 wuhaosoft Exp
 *
 */
@ApiModel(description = "机床当前状态")
public class Machinestatus {

    @ApiModelProperty(value = "111111")
    private Integer  machinestatus;

    @ApiModelProperty(value = "userId")
    private String userId;

    @ApiModelProperty(value = "num")
    private Integer num;

    public Machinestatus(){}

    public Machinestatus(
        Integer  machinestatus,
        String userId,
        Integer num
    ) {
        this.userId = userId;
        this.num = num;
    }

    public Integer  getMachinestatus(){
        return machinestatus;
    }

    public void setMachinestatus(Integer  machinestatus) {
        this.machinestatus = machinestatus;
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



