package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
/**
 * @author wuhaosoft
 * @version $Id RptMachineTotalStatusInfo.java, 2018-08-22 17:12:45 wuhaosoft Exp
 *
 */
@ApiModel(description = "机床状态运行时长统计")
public class RptMachineTotalStatusInfo {

    @ApiModelProperty(value = "111111")
    private Integer  rptMachineTotalStatusInfo;

    @ApiModelProperty(value = "userId")
    private String userId;

    @ApiModelProperty(value = "num")
    private Integer num;

    public RptMachineTotalStatusInfo(){}

    public RptMachineTotalStatusInfo(
        Integer  rptMachineTotalStatusInfo,
        String userId,
        Integer num
    ) {
        this.userId = userId;
        this.num = num;
    }

    public Integer  getRptMachineTotalStatusInfo(){
        return rptMachineTotalStatusInfo;
    }

    public void setRptMachineTotalStatusInfo(Integer  rptMachineTotalStatusInfo) {
        this.rptMachineTotalStatusInfo = rptMachineTotalStatusInfo;
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



