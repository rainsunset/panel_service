package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * @author : ligangwei / ligangwei@seerbigdata.com
 * @version : 1.0
 * @autheor ligw
 * @date 2018 /8/24 14:06
 */
@ApiModel(description = "生产线生产统计")
public class ProdLineProdReport implements Serializable {

  /**
   * Production line
   */
  @ApiModelProperty(value = "产线",example = "B")
  private String productionLine;

  /**
   * Prod line prod num
   */
  @ApiModelProperty(value = "生产数")
  private Integer prodLineProdNum = 0;

  /**
   * Planned production
   */
  @ApiModelProperty(value = "今日计划生产数")
  private Integer plannedProduction = 0;

  /**
   * Prod line prod percent
   */
  @ApiModelProperty(value = "完工率")
  private Double prodLineProdPercent = 0.0;

  /**
   * Get production line string.
   *
   * @return the string
   * @author : ligangwei / 2018-12-29
   */
  public String getProductionLine() {
    return productionLine;
  }

  /**
   * Sets production line.
   *
   * @param productionLine the production line
   * @author : ligangwei / 2018-12-29
   */
  public void setProductionLine(String productionLine) {
    this.productionLine = productionLine;
  }

  /**
   * Get prod line prod num integer.
   *
   * @return the integer
   * @author : ligangwei / 2018-12-29
   */
  public Integer getProdLineProdNum() {
    return prodLineProdNum;
  }

  /**
   * Sets prod line prod num.
   *
   * @param prodLineProdNum the prod line prod num
   * @author : ligangwei / 2018-12-29
   */
  public void setProdLineProdNum(Integer prodLineProdNum) {
    this.prodLineProdNum = prodLineProdNum;
  }

  /**
   * Get planned production integer.
   *
   * @return the integer
   * @author : ligangwei / 2018-12-29
   */
  public Integer getPlannedProduction() {
    return plannedProduction;
  }

  /**
   * Sets planned production.
   *
   * @param plannedProduction the planned production
   * @author : ligangwei / 2018-12-29
   */
  public void setPlannedProduction(Integer plannedProduction) {
    this.plannedProduction = plannedProduction;
  }

  /**
   * Get prod line prod percent double.
   *
   * @return the double
   * @author : ligangwei / 2018-12-29
   */
  public Double getProdLineProdPercent() {
    return prodLineProdPercent;
  }

  /**
   * Sets prod line prod percent.
   *
   * @param prodLineProdPercent the prod line prod percent
   * @author : ligangwei / 2018-12-29
   */
  public void setProdLineProdPercent(Double prodLineProdPercent) {
    this.prodLineProdPercent = prodLineProdPercent;
  }
}
