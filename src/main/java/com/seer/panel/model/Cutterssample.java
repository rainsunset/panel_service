package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
/**
 * @author wuhaosoft
 * @version $Id Cutterssample.java, 2018-08-22 17:12:43 wuhaosoft Exp
 *
 */
@ApiModel(description = "断刀样本")
public class Cutterssample {

    @ApiModelProperty(value = "111111")
    private Integer  cutterssample;

    @ApiModelProperty(value = "userId")
    private String userId;

    @ApiModelProperty(value = "num")
    private Integer num;

    public Cutterssample(){}

    public Cutterssample(
        Integer  cutterssample,
        String userId,
        Integer num
    ) {
        this.userId = userId;
        this.num = num;
    }

    public Integer  getCutterssample(){
        return cutterssample;
    }

    public void setCutterssample(Integer  cutterssample) {
        this.cutterssample = cutterssample;
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



