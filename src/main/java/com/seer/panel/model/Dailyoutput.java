package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
/**
 * @author wuhaosoft
 * @version $Id Dailyoutput.java, 2018-08-22 17:12:43 wuhaosoft Exp
 *
 */
@ApiModel(description = "日产量表")
public class Dailyoutput {

    @ApiModelProperty(value = "111111")
    private Integer  dailyoutput;

    @ApiModelProperty(value = "userId")
    private String userId;

    @ApiModelProperty(value = "num")
    private Integer num;

    public Dailyoutput(){}

    public Dailyoutput(
        Integer  dailyoutput,
        String userId,
        Integer num
    ) {
        this.userId = userId;
        this.num = num;
    }

    public Integer  getDailyoutput(){
        return dailyoutput;
    }

    public void setDailyoutput(Integer  dailyoutput) {
        this.dailyoutput = dailyoutput;
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



