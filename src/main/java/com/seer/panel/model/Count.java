package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
/**
 * @author wuhaosoft
 * @version $Id Count.java, 2018-08-22 17:12:43 wuhaosoft Exp
 *
 */
@ApiModel(description = "")
public class Count {

    @ApiModelProperty(value = "111111")
    private Integer  count;

    @ApiModelProperty(value = "userId")
    private String userId;

    @ApiModelProperty(value = "num")
    private Integer num;

    public Count(){}

    public Count(
        Integer  count,
        String userId,
        Integer num
    ) {
        this.userId = userId;
        this.num = num;
    }

    public Integer  getCount(){
        return count;
    }

    public void setCount(Integer  count) {
        this.count = count;
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



