package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * @autheor ligw
 * @date 2018/8/23 20:27
 */
@ApiModel(description = "刀具寿命预警")
public class KnifeLifencyWarningReport implements Serializable {

  @ApiModelProperty(value = "机床名称")
  private String machineName;

  @ApiModelProperty(value = "机床刀位")
  private String knifePosition;

  @ApiModelProperty(value = "总寿命次数")
  private Integer totalCount;

  @ApiModelProperty(value = "已使用次数")
  private Integer currentLife;

  public String getMachineName() {
    return machineName;
  }

  public void setMachineName(String machineName) {
    this.machineName = machineName;
  }

  public String getKnifePosition() {
    return knifePosition;
  }

  public void setKnifePosition(String knifePosition) {
    this.knifePosition = knifePosition;
  }

  public Integer getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }

  public Integer getCurrentLife() {
    return currentLife;
  }

  public void setCurrentLife(Integer currentLife) {
    this.currentLife = currentLife;
  }
}
