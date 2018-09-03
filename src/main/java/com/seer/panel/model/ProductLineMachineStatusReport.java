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

  @ApiModelProperty(value = "机床状态信息")
  private List<MachineInfo> machineInfoList;

  @ApiModelProperty(value = "生产线机床状态统计")
  private ProductLineStatus productLineStatus;

  public List<MachineInfo> getMachineInfoList() {
    return machineInfoList;
  }

  public void setMachineInfoList(
      List<MachineInfo> machineInfoList) {
    this.machineInfoList = machineInfoList;
  }

  public ProductLineStatus getProductLineStatus() {
    return productLineStatus;
  }

  public void setProductLineStatus(
      ProductLineStatus productLineStatus) {
    this.productLineStatus = productLineStatus;
  }
}
