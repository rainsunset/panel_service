package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
/**
 * @author wuhaosoft
 * @version $Id Knifechangerhistory.java, 2018-08-22 17:12:43 wuhaosoft Exp
 *
 */
@ApiModel(description = "换刀记录")
public class Knifechangerhistory {

    @ApiModelProperty(value = "111111")
    private Integer  knifechangerhistory;

    @ApiModelProperty(value = "userId")
    private String userId;

    @ApiModelProperty(value = "num")
    private Integer num;

    public Knifechangerhistory(){}

    public Knifechangerhistory(
        Integer  knifechangerhistory,
        String userId,
        Integer num
    ) {
        this.userId = userId;
        this.num = num;
    }

    public Integer  getKnifechangerhistory(){
        return knifechangerhistory;
    }

    public void setKnifechangerhistory(Integer  knifechangerhistory) {
        this.knifechangerhistory = knifechangerhistory;
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



