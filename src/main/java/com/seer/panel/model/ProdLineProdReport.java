package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * @autheor ligw
 * @date 2018/8/24 14:06
 */
@ApiModel(description = "生产线生产统计")
public class ProdLineProdReport implements Serializable {

  @ApiModelProperty(value = "产线",example = "B")
  private String productionLine;

  @ApiModelProperty(value = "生产数")
  private Integer prodLineProdNum = 0;

  @ApiModelProperty(value = "今日计划生产数")
  private Integer plannedProduction = 0;

  @ApiModelProperty(value = "完工率")
  private Double prodLineProdPercent = 0.0;

  public String getProductionLine() {
    return productionLine;
  }

  public void setProductionLine(String productionLine) {
    this.productionLine = productionLine;
  }

  public Integer getProdLineProdNum() {
    return prodLineProdNum;
  }

  public void setProdLineProdNum(Integer prodLineProdNum) {
    this.prodLineProdNum = prodLineProdNum;
  }

  public Integer getPlannedProduction() {
    return plannedProduction;
  }

  public void setPlannedProduction(Integer plannedProduction) {
    this.plannedProduction = plannedProduction;
  }

  public Double getProdLineProdPercent() {
    return prodLineProdPercent;
  }

  public void setProdLineProdPercent(Double prodLineProdPercent) {
    this.prodLineProdPercent = prodLineProdPercent;
  }
}
