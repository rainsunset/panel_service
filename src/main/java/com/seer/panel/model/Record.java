package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
/**
 * @author wuhaosoft
 * @version $Id Record.java, 2018-08-22 17:12:44 wuhaosoft Exp
 *
 */
@ApiModel(description = "")
public class Record {

    @ApiModelProperty(value = "111111")
    private Integer  record;

    @ApiModelProperty(value = "userId")
    private String userId;

    @ApiModelProperty(value = "num")
    private Integer num;

    public Record(){}

    public Record(
        Integer  record,
        String userId,
        Integer num
    ) {
        this.userId = userId;
        this.num = num;
    }

    public Integer  getRecord(){
        return record;
    }

    public void setRecord(Integer  record) {
        this.record = record;
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



