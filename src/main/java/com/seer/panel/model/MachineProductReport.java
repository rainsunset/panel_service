package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * @author : ligangwei / ligangwei@seerbigdata.com
 * @version : 1.0
 * @autheor ligw
 * @date 2018 /8/23 19:36
 */
@ApiModel(description = "机床生产效率统计")
public class MachineProductReport implements Serializable {

  /**
   * Rank
   */
  @ApiModelProperty(value = "稼动时长排名")
  private Integer rank;

  /**
   * Machine name
   */
  @ApiModelProperty(value = "机床名称")
  private String machineName;

  /**
   * Mac work time
   */
  @ApiModelProperty(value = "稼动时长 单位:minute")
  private Integer macWorkTime;

  /**
   * Mac prod num
   */
  @ApiModelProperty(value = "加工件数 单位:件")
  private Integer macProdNum;

  /**
   * Get rank integer.
   *
   * @return the integer
   * @author : ligangwei / 2018-12-29
   */
  public Integer getRank() {
    return rank;
  }

  /**
   * Sets rank.
   *
   * @param rank the rank
   * @author : ligangwei / 2018-12-29
   */
  public void setRank(Integer rank) {
    this.rank = rank;
  }

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
   * Get mac work time integer.
   *
   * @return the integer
   * @author : ligangwei / 2018-12-29
   */
  public Integer getMacWorkTime() {
    return macWorkTime;
  }

  /**
   * Sets mac work time.
   *
   * @param macWorkTime the mac work time
   * @author : ligangwei / 2018-12-29
   */
  public void setMacWorkTime(Integer macWorkTime) {
    this.macWorkTime = macWorkTime;
  }

  /**
   * Get mac prod num integer.
   *
   * @return the integer
   * @author : ligangwei / 2018-12-29
   */
  public Integer getMacProdNum() {
    return macProdNum;
  }

  /**
   * Sets mac prod num.
   *
   * @param macProdNum the mac prod num
   * @author : ligangwei / 2018-12-29
   */
  public void setMacProdNum(Integer macProdNum) {
    this.macProdNum = macProdNum;
  }
}
