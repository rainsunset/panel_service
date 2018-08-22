package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
/**
 * @author wuhaosoft
 * @version $Id Machinestatushistory.java, 2018-08-22 17:12:44 wuhaosoft Exp
 *
 */
@ApiModel(description = "机床状态历史记录")
public class Machinestatushistory {

    @ApiModelProperty(value = "111111")
    private Integer  machinestatushistory;

    @ApiModelProperty(value = "userId")
    private String userId;

    @ApiModelProperty(value = "num")
    private Integer num;

    public Machinestatushistory(){}

    public Machinestatushistory(
        Integer  machinestatushistory,
        String userId,
        Integer num
    ) {
        this.userId = userId;
        this.num = num;
    }

    public Integer  getMachinestatushistory(){
        return machinestatushistory;
    }

    public void setMachinestatushistory(Integer  machinestatushistory) {
        this.machinestatushistory = machinestatushistory;
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



