package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;

/**
 * @autheor ligw
 * @date 2018/8/23 19:51
 */
@ApiModel(description = "生产线机床状态信息")
public class ProductLineMachineStatusReport implements Serializable {

  private List<MachineInfo> machineInfoList;

  private ProductLineInfo productLineInfo;

  public List<MachineInfo> getMachineInfoList() {
    return machineInfoList;
  }

  public void setMachineInfoList(
      List<MachineInfo> machineInfoList) {
    this.machineInfoList = machineInfoList;
  }

  public ProductLineInfo getProductLineInfo() {
    return productLineInfo;
  }

  public void setProductLineInfo(
      ProductLineInfo productLineInfo) {
    this.productLineInfo = productLineInfo;
  }


  @ApiModel(description = "机床状态信息")
  class MachineInfo {

    @ApiModelProperty(value = "机床编码", example = "000000026")
    private String machineCode;

    @ApiModelProperty(value = "机床名称", example = "C04")
    private String machineName;

    @ApiModelProperty(value = "工厂", example = "东城")
    private String factory;

    @ApiModelProperty(value = "车间", example = "A栋")
    private String worksShop;

    @ApiModelProperty(value = "产线", example = "C")
    private String poductLine;

    @ApiModelProperty(value = "")
    private String iSampleId;

    @ApiModelProperty(value = "状态 [0 - stop] [1 - runing] [2 - wait] [3 - alarm]")
    private Integer status;

    @ApiModelProperty(value = "更新时间", example = "2018-08-20 16:52")
    private String occurrenceTime;

    public String getMachineCode() {
      return machineCode;
    }

    public void setMachineCode(String machineCode) {
      this.machineCode = machineCode;
    }

    public String getMachineName() {
      return machineName;
    }

    public void setMachineName(String machineName) {
      this.machineName = machineName;
    }

    public String getFactory() {
      return factory;
    }

    public void setFactory(String factory) {
      this.factory = factory;
    }

    public String getWorksShop() {
      return worksShop;
    }

    public void setWorksShop(String worksShop) {
      this.worksShop = worksShop;
    }

    public String getPoductLine() {
      return poductLine;
    }

    public void setPoductLine(String poductLine) {
      this.poductLine = poductLine;
    }

    public String getiSampleId() {
      return iSampleId;
    }

    public void setiSampleId(String iSampleId) {
      this.iSampleId = iSampleId;
    }

    public Integer getStatus() {
      return status;
    }

    public void setStatus(Integer status) {
      this.status = status;
    }

    public String getOccurrenceTime() {
      return occurrenceTime;
    }

    public void setOccurrenceTime(String occurrenceTime) {
      this.occurrenceTime = occurrenceTime;
    }
  }


  @ApiModel(description = "生产线机床状态统计")
  class ProductLineInfo {

    @ApiModelProperty(value = "显示标题", example = "A栋C产线(18台)")
    private String title;

    @ApiModelProperty(value = "待机数")
    private Integer stop;

    @ApiModelProperty(value = "运行数")
    private Integer runing;

    @ApiModelProperty(value = "空闲数")
    private Integer wait;

    @ApiModelProperty(value = "报警数")
    private Integer alarm;

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public Integer getStop() {
      return stop;
    }

    public void setStop(Integer stop) {
      this.stop = stop;
    }

    public Integer getRuning() {
      return runing;
    }

    public void setRuning(Integer runing) {
      this.runing = runing;
    }

    public Integer getWait() {
      return wait;
    }

    public void setWait(Integer wait) {
      this.wait = wait;
    }

    public Integer getAlarm() {
      return alarm;
    }

    public void setAlarm(Integer alarm) {
      this.alarm = alarm;
    }
  }

}
