package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
/**
 * @author wuhaosoft
 * @version $Id Knifeinfo.java, 2018-08-22 17:12:43 wuhaosoft Exp
 *
 */
@ApiModel(description = "刀具信息表")
public class Knifeinfo {

    @ApiModelProperty(value = "111111")
    private Integer  knifeinfo;

    @ApiModelProperty(value = "userId")
    private String userId;

    @ApiModelProperty(value = "num")
    private Integer num;

    public Knifeinfo(){}

    public Knifeinfo(
        Integer  knifeinfo,
        String userId,
        Integer num
    ) {
        this.userId = userId;
        this.num = num;
    }

    public Integer  getKnifeinfo(){
        return knifeinfo;
    }

    public void setKnifeinfo(Integer  knifeinfo) {
        this.knifeinfo = knifeinfo;
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



