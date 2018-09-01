package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * @autheor ligw
 * @date 2018/8/23 19:36
 */
@ApiModel(description = "机床生产效率统计")
public class MachineProductReport implements Serializable {

  @ApiModelProperty(value = "稼动时长排名")
  private Integer rank;

  @ApiModelProperty(value = "机床名称")
  private String machineName;

  @ApiModelProperty(value = "稼动时长 单位:minute")
  private Integer macWorkTime;

  @ApiModelProperty(value = "加工件数 单位:件")
  private Integer macProdNum;

  public Integer getRank() {
    return rank;
  }

  public void setRank(Integer rank) {
    this.rank = rank;
  }

  public String getMachineName() {
    return machineName;
  }

  public void setMachineName(String machineName) {
    this.machineName = machineName;
  }

  public Integer getMacWorkTime() {
    return macWorkTime;
  }

  public void setMacWorkTime(Integer macWorkTime) {
    this.macWorkTime = macWorkTime;
  }

  public Integer getMacProdNum() {
    return macProdNum;
  }

  public void setMacProdNum(Integer macProdNum) {
    this.macProdNum = macProdNum;
  }
}
