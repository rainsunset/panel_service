package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * @author : ligangwei / ligangwei@seerbigdata.com
 * @version : 1.0
 * @autheor ligw
 * @date 2018 /8/23 20:27
 */
@ApiModel(description = "刀具寿命预警")
public class KnifeLifencyWarningReport implements Serializable {

  /**
   * Machine name
   */
  @ApiModelProperty(value = "机床名称")
  private String machineName;

  /**
   * Knife position
   */
  @ApiModelProperty(value = "机床刀位")
  private String knifePosition;

  /**
   * Total count
   */
  @ApiModelProperty(value = "总寿命次数")
  private Integer totalCount;

  /**
   * Current count
   */
  @ApiModelProperty(value = "已使用次数")
  private Integer currentCount;

  /**
   * Surplus count
   */
  @ApiModelProperty(value = "寿命剩余次数")
  private Integer surplusCount;

  /**
   * Get machine name string.
   *
   * @return the string
   * @author : ligangwei / 2018-12-29
   */
  public String getMachineName() {
    return machineName;
  }

  /**
   * Sets machine name.
   *
   * @param machineName the machine name
   * @author : ligangwei / 2018-12-29
   */
  public void setMachineName(String machineName) {
    this.machineName = machineName;
  }

  /**
   * Get knife position string.
   *
   * @return the string
   * @author : ligangwei / 2018-12-29
   */
  public String getKnifePosition() {
    return knifePosition;
  }

  /**
   * Sets knife position.
   *
   * @param knifePosition the knife position
   * @author : ligangwei / 2018-12-29
   */
  public void setKnifePosition(String knifePosition) {
    this.knifePosition = knifePosition;
  }

  /**
   * Get total count integer.
   *
   * @return the integer
   * @author : ligangwei / 2018-12-29
   */
  public Integer getTotalCount() {
    return totalCount;
  }

  /**
   * Sets total count.
   *
   * @param totalCount the total count
   * @author : ligangwei / 2018-12-29
   */
  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }

  /**
   * Get current count integer.
   *
   * @return the integer
   * @author : ligangwei / 2018-12-29
   */
  public Integer getCurrentCount() {
    return currentCount;
  }

  /**
   * Sets current count.
   *
   * @param currentCount the current count
   * @author : ligangwei / 2018-12-29
   */
  public void setCurrentCount(Integer currentCount) {
    this.currentCount = currentCount;
  }

  /**
   * Get surplus count integer.
   *
   * @return the integer
   * @author : ligangwei / 2018-12-29
   */
  public Integer getSurplusCount() {
    return surplusCount;
  }

  /**
   * Sets surplus count.
   *
   * @param surplusCount the surplus count
   * @author : ligangwei / 2018-12-29
   */
  public void setSurplusCount(Integer surplusCount) {
    this.surplusCount = surplusCount;
  }
}
