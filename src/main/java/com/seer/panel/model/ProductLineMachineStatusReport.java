package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;

/**
 * @author : ligangwei / ligangwei@seerbigdata.com
 * @version : 1.0
 * @autheor ligw
 * @date 2018 /8/23 19:51
 */
@ApiModel(description = "生产线机床状态信息")
public class ProductLineMachineStatusReport implements Serializable {

  /**
   * Machine info list
   */
  @ApiModelProperty(value = "机床状态信息")
  private List<MachineInfo> machineInfoList;

  /**
   * Product line status
   */
  @ApiModelProperty(value = "生产线机床状态统计")
  private ProductLineStatus productLineStatus;

  /**
   * Get machine info list list.
   *
   * @return the list
   * @author : ligangwei / 2018-12-29
   */
  public List<MachineInfo> getMachineInfoList() {
    return machineInfoList;
  }

  /**
   * Sets machine info list.
   *
   * @param machineInfoList the machine info list
   * @author : ligangwei / 2018-12-29
   */
  public void setMachineInfoList(
      List<MachineInfo> machineInfoList) {
    this.machineInfoList = machineInfoList;
  }

  /**
   * Get product line status product line status.
   *
   * @return the product line status
   * @author : ligangwei / 2018-12-29
   */
  public ProductLineStatus getProductLineStatus() {
    return productLineStatus;
  }

  /**
   * Sets product line status.
   *
   * @param productLineStatus the product line status
   * @author : ligangwei / 2018-12-29
   */
  public void setProductLineStatus(
      ProductLineStatus productLineStatus) {
    this.productLineStatus = productLineStatus;
  }
}
