package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
/**
 * @author wuhaosoft
 * @version $Id Productionplan.java, 2018-08-22 17:12:44 wuhaosoft Exp
 *
 */
@ApiModel(description = "生产计划")
public class Productionplan {

    @ApiModelProperty(value = "111111")
    private Integer  productionplan;

    @ApiModelProperty(value = "userId")
    private String userId;

    @ApiModelProperty(value = "num")
    private Integer num;

    public Productionplan(){}

    public Productionplan(
        Integer  productionplan,
        String userId,
        Integer num
    ) {
        this.userId = userId;
        this.num = num;
    }

    public Integer  getProductionplan(){
        return productionplan;
    }

    public void setProductionplan(Integer  productionplan) {
        this.productionplan = productionplan;
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



