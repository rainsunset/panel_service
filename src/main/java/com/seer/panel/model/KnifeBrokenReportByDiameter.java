package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * @autheor ligw
 * @date 2018/8/23 20:39
 */
@ApiModel(description = "断刀频率统计")
public class KnifeBrokenReportByDiameter implements Serializable {

  @ApiModelProperty(value = "产线")
  private String productionLine;

  @ApiModelProperty(value = "刀径")
  private Double knifeDiameter;

  @ApiModelProperty(value = "断刀数量")
  private Integer brokenNum;

  public String getProductionLine() {
    return productionLine;
  }

  public void setProductionLine(String productionLine) {
    this.productionLine = productionLine;
  }

  public Double getKnifeDiameter() {
    return knifeDiameter;
  }

  public void setKnifeDiameter(Double knifeDiameter) {
    this.knifeDiameter = knifeDiameter;
  }

  public Integer getBrokenNum() {
    return brokenNum;
  }

  public void setBrokenNum(Integer brokenNum) {
    this.brokenNum = brokenNum;
  }
}
