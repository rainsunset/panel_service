package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
/**
 * @author wuhaosoft
 * @version $Id Machinealarmhistory.java, 2018-08-22 17:12:44 wuhaosoft Exp
 *
 */
@ApiModel(description = "机床报警历史记录")
public class Machinealarmhistory {

    @ApiModelProperty(value = "111111")
    private Integer  machinealarmhistory;

    @ApiModelProperty(value = "userId")
    private String userId;

    @ApiModelProperty(value = "num")
    private Integer num;

    public Machinealarmhistory(){}

    public Machinealarmhistory(
        Integer  machinealarmhistory,
        String userId,
        Integer num
    ) {
        this.userId = userId;
        this.num = num;
    }

    public Integer  getMachinealarmhistory(){
        return machinealarmhistory;
    }

    public void setMachinealarmhistory(Integer  machinealarmhistory) {
        this.machinealarmhistory = machinealarmhistory;
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



