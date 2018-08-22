package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
/**
 * @author wuhaosoft
 * @version $Id Brokenknifedetail.java, 2018-08-22 17:12:43 wuhaosoft Exp
 *
 */
@ApiModel(description = "断刀记录明细")
public class Brokenknifedetail {

    @ApiModelProperty(value = "111111")
    private Integer  brokenknifedetail;

    @ApiModelProperty(value = "userId")
    private String userId;

    @ApiModelProperty(value = "num")
    private Integer num;

    public Brokenknifedetail(){}

    public Brokenknifedetail(
        Integer  brokenknifedetail,
        String userId,
        Integer num
    ) {
        this.userId = userId;
        this.num = num;
    }

    public Integer  getBrokenknifedetail(){
        return brokenknifedetail;
    }

    public void setBrokenknifedetail(Integer  brokenknifedetail) {
        this.brokenknifedetail = brokenknifedetail;
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



