package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
/**
 * @author wuhaosoft
 * @version $Id Productprocesstime.java, 2018-08-22 17:12:44 wuhaosoft Exp
 *
 */
@ApiModel(description = "产品加工时间")
public class Productprocesstime {

    @ApiModelProperty(value = "111111")
    private Integer  productprocesstime;

    @ApiModelProperty(value = "userId")
    private String userId;

    @ApiModelProperty(value = "num")
    private Integer num;

    public Productprocesstime(){}

    public Productprocesstime(
        Integer  productprocesstime,
        String userId,
        Integer num
    ) {
        this.userId = userId;
        this.num = num;
    }

    public Integer  getProductprocesstime(){
        return productprocesstime;
    }

    public void setProductprocesstime(Integer  productprocesstime) {
        this.productprocesstime = productprocesstime;
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



