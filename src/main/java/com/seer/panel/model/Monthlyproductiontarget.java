package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
/**
 * @author wuhaosoft
 * @version $Id Monthlyproductiontarget.java, 2018-08-22 17:12:44 wuhaosoft Exp
 *
 */
@ApiModel(description = "月度生产目标表")
public class Monthlyproductiontarget {

    @ApiModelProperty(value = "111111")
    private Integer  monthlyproductiontarget;

    @ApiModelProperty(value = "userId")
    private String userId;

    @ApiModelProperty(value = "num")
    private Integer num;

    public Monthlyproductiontarget(){}

    public Monthlyproductiontarget(
        Integer  monthlyproductiontarget,
        String userId,
        Integer num
    ) {
        this.userId = userId;
        this.num = num;
    }

    public Integer  getMonthlyproductiontarget(){
        return monthlyproductiontarget;
    }

    public void setMonthlyproductiontarget(Integer  monthlyproductiontarget) {
        this.monthlyproductiontarget = monthlyproductiontarget;
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


