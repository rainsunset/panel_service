package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
/**
 * @author wuhaosoft
 * @version $Id Productprocesstimehistory.java, 2018-08-22 17:12:44 wuhaosoft Exp
 *
 */
@ApiModel(description = "产品加工时间历史")
public class Productprocesstimehistory {

    @ApiModelProperty(value = "111111")
    private Integer  productprocesstimehistory;

    @ApiModelProperty(value = "userId")
    private String userId;

    @ApiModelProperty(value = "num")
    private Integer num;

    public Productprocesstimehistory(){}

    public Productprocesstimehistory(
        Integer  productprocesstimehistory,
        String userId,
        Integer num
    ) {
        this.userId = userId;
        this.num = num;
    }

    public Integer  getProductprocesstimehistory(){
        return productprocesstimehistory;
    }

    public void setProductprocesstimehistory(Integer  productprocesstimehistory) {
        this.productprocesstimehistory = productprocesstimehistory;
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



