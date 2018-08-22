package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
/**
 * @author wuhaosoft
 * @version $Id Knifelife.java, 2018-08-22 17:12:44 wuhaosoft Exp
 *
 */
@ApiModel(description = "刀具寿命")
public class Knifelife {

    @ApiModelProperty(value = "111111")
    private Integer  knifelife;

    @ApiModelProperty(value = "userId")
    private String userId;

    @ApiModelProperty(value = "num")
    private Integer num;

    public Knifelife(){}

    public Knifelife(
        Integer  knifelife,
        String userId,
        Integer num
    ) {
        this.userId = userId;
        this.num = num;
    }

    public Integer  getKnifelife(){
        return knifelife;
    }

    public void setKnifelife(Integer  knifelife) {
        this.knifelife = knifelife;
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



