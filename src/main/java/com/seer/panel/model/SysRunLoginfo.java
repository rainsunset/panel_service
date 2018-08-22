package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
/**
 * @author wuhaosoft
 * @version $Id SysRunLoginfo.java, 2018-08-22 17:12:45 wuhaosoft Exp
 *
 */
@ApiModel(description = "系统日志表")
public class SysRunLoginfo {

    @ApiModelProperty(value = "111111")
    private Integer  sysRunLoginfo;

    @ApiModelProperty(value = "userId")
    private String userId;

    @ApiModelProperty(value = "num")
    private Integer num;

    public SysRunLoginfo(){}

    public SysRunLoginfo(
        Integer  sysRunLoginfo,
        String userId,
        Integer num
    ) {
        this.userId = userId;
        this.num = num;
    }

    public Integer  getSysRunLoginfo(){
        return sysRunLoginfo;
    }

    public void setSysRunLoginfo(Integer  sysRunLoginfo) {
        this.sysRunLoginfo = sysRunLoginfo;
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



