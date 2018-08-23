package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
/**
 * @author wuhaosoft
 * @version $Id Acquisitioncard.java, 2018-08-23 10:45:24 wuhaosoft Exp
 *
 */
@ApiModel(description = "采集卡信息")
public class Acquisitioncard {

    @ApiModelProperty(value = "采集卡编码")
    private String  acquisitionCardCode;

    @ApiModelProperty(value = "采集卡名称")
    private String acquisitionCardName;

    @ApiModelProperty(value = "采集卡规格型号")
    private String acquisitionCardModel;

    @ApiModelProperty(value = "通道数量")
    private Integer channelNums;

    @ApiModelProperty(value = "ip")
    private String ip;

    @ApiModelProperty(value = "端口号")
    private Integer port;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "创建人")
    private String creator;

    @ApiModelProperty(value = "修改人")
    private String modifier;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date modifyTime;

    public Acquisitioncard(){}

    public Acquisitioncard(
        String  acquisitionCardCode,
        String acquisitionCardName,
        String acquisitionCardModel,
        Integer channelNums,
        String ip,
        Integer port,
        Integer status,
        String creator,
        String modifier,
        Date createTime,
        Date modifyTime
    ) {
        this.acquisitionCardName = acquisitionCardName;
        this.acquisitionCardModel = acquisitionCardModel;
        this.channelNums = channelNums;
        this.ip = ip;
        this.port = port;
        this.status = status;
        this.creator = creator;
        this.modifier = modifier;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }
    public String getAcquisitionCardCode(){
        return acquisitionCardCode;
    }

    public void setAcquisitionCardCode(String  acquisitionCardCode) {
        this.acquisitionCardCode = acquisitionCardCode;
    }

    public String getAcquisitionCardName() {
        return acquisitionCardName;
    }

    public void setAcquisitionCardName(String  acquisitionCardName) {
        this.acquisitionCardName = acquisitionCardName;
    }

    public String getAcquisitionCardModel() {
        return acquisitionCardModel;
    }

    public void setAcquisitionCardModel(String  acquisitionCardModel) {
        this.acquisitionCardModel = acquisitionCardModel;
    }

    public Integer getChannelNums() {
        return channelNums;
    }

    public void setChannelNums(Integer  channelNums) {
        this.channelNums = channelNums;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String  ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer  port) {
        this.port = port;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer  status) {
        this.status = status;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String  creator) {
        this.creator = creator;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String  modifier) {
        this.modifier = modifier;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date  createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date  modifyTime) {
        this.modifyTime = modifyTime;
    }

}



