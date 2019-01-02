package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * @author : ligangwei / ligangwei@seerbigdata.com
 * @version : 1.0
 * @autheor ligw
 * @date 2018 /8/23 20:39
 */
@ApiModel(description = "断刀频率统计")
public class KnifeBrokenReportByDiameter implements Serializable {

  /**
   * Production line
   */
  @ApiModelProperty(value = "产线")
  private String productionLine;

  /**
   * Knife diameter
   */
  @ApiModelProperty(value = "刀径")
  private Double knifeDiameter;

  /**
   * Broken num
   */
  @ApiModelProperty(value = "断刀数量")
  private Integer brokenNum;

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
   * Get knife diameter double.
   *
   * @return the double
   * @author : ligangwei / 2018-12-29
   */
  public Double getKnifeDiameter() {
    return knifeDiameter;
  }

  /**
   * Sets knife diameter.
   *
   * @param knifeDiameter the knife diameter
   * @author : ligangwei / 2018-12-29
   */
  public void setKnifeDiameter(Double knifeDiameter) {
    this.knifeDiameter = knifeDiameter;
  }

  /**
   * Get broken num integer.
   *
   * @return the integer
   * @author : ligangwei / 2018-12-29
   */
  public Integer getBrokenNum() {
    return brokenNum;
  }

  /**
   * Sets broken num.
   *
   * @param brokenNum the broken num
   * @author : ligangwei / 2018-12-29
   */
  public void setBrokenNum(Integer brokenNum) {
    this.brokenNum = brokenNum;
  }
}
