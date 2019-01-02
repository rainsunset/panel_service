package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * @author : ligangwei / ligangwei@seerbigdata.com
 * @version : 1.0
 * @autheor ligw
 * @date 2018 /8/23 20:21
 */
@ApiModel(description = "机床报警信息统计")
public class ProductLineAlarmReport implements Serializable {

  /**
   * Machine name
   */
  @ApiModelProperty(value = "机床名称" ,example = "B03")
  private String machineName;

  /**
   * Alarm msg
   */
  @ApiModelProperty(value = "报警信息")
  private String alarmMsg;

  /**
   * Knife num
   */
  @ApiModelProperty(value = "报警刀位")
  private Integer knifeNum;

  /**
   * Occurrence time
   */
  @ApiModelProperty(value = "报警时间")
  private String  occurrenceTime;

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
   * Get alarm msg string.
   *
   * @return the string
   * @author : ligangwei / 2018-12-29
   */
  public String getAlarmMsg() {
    return alarmMsg;
  }

  /**
   * Sets alarm msg.
   *
   * @param alarmMsg the alarm msg
   * @author : ligangwei / 2018-12-29
   */
  public void setAlarmMsg(String alarmMsg) {
    this.alarmMsg = alarmMsg;
  }

  /**
   * Get knife num integer.
   *
   * @return the integer
   * @author : ligangwei / 2018-12-29
   */
  public Integer getKnifeNum() {
    return knifeNum;
  }

  /**
   * Sets knife num.
   *
   * @param knifeNum the knife num
   * @author : ligangwei / 2018-12-29
   */
  public void setKnifeNum(Integer knifeNum) {
    this.knifeNum = knifeNum;
  }

  /**
   * Get occurrence time string.
   *
   * @return the string
   * @author : ligangwei / 2018-12-29
   */
  public String getOccurrenceTime() {
    return occurrenceTime;
  }

  /**
   * Sets occurrence time.
   *
   * @param occurrenceTime the occurrence time
   * @author : ligangwei / 2018-12-29
   */
  public void setOccurrenceTime(String occurrenceTime) {
    this.occurrenceTime = occurrenceTime;
  }
}
