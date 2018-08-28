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

  @ApiModelProperty(value = "产线生产产品数")
  private Integer prodLineProdNum;

  @ApiModelProperty(value = "产线计划生产产品数")
  private Integer plannedProduction;

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
}
