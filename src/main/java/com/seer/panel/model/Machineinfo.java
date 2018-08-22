package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
/**
 * @author wuhaosoft
 * @version $Id Machineinfo.java, 2018-08-22 17:12:44 wuhaosoft Exp
 *
 */
@ApiModel(description = "机床信息表")
public class Machineinfo {

    @ApiModelProperty(value = "111111")
    private Integer  machineinfo;

    @ApiModelProperty(value = "userId")
    private String userId;

    @ApiModelProperty(value = "num")
    private Integer num;

    public Machineinfo(){}

    public Machineinfo(
        Integer  machineinfo,
        String userId,
        Integer num
    ) {
        this.userId = userId;
        this.num = num;
    }

    public Integer  getMachineinfo(){
        return machineinfo;
    }

    public void setMachineinfo(Integer  machineinfo) {
        this.machineinfo = machineinfo;
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



