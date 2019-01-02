package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author : ligangwei / ligangwei@seerbigdata.com
 * @version : 1.0
 * @autheor ligw
 * @date 2018 /8/24 10:15
 */
@ApiModel(description = "生产线机床状态统计")
public class ProductLineStatus {

  /**
   * Title
   */
  @ApiModelProperty(value = "显示标题", example = "A栋C产线(18台)")
  private String title;

  /**
   * Stop
   */
  @ApiModelProperty(value = "待机数")
  private Integer stop;

  /**
   * Runing
   */
  @ApiModelProperty(value = "运行数")
  private Integer runing;

  /**
   * Wait
   */
  @ApiModelProperty(value = "空闲数")
  private Integer wait;

  /**
   * Alarm
   */
  @ApiModelProperty(value = "报警数")
  private Integer alarm;

  /**
   * Get title string.
   *
   * @return the string
   * @author : ligangwei / 2018-12-29
   */
  public String getTitle() {
    return title;
  }

  /**
   * Sets title.
   *
   * @param title the title
   * @author : ligangwei / 2018-12-29
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Get stop integer.
   *
   * @return the integer
   * @author : ligangwei / 2018-12-29
   */
  public Integer getStop() {
    return stop;
  }

  /**
   * Sets stop.
   *
   * @param stop the stop
   * @author : ligangwei / 2018-12-29
   */
  public void setStop(Integer stop) {
    this.stop = stop;
  }

  /**
   * Get runing integer.
   *
   * @return the integer
   * @author : ligangwei / 2018-12-29
   */
  public Integer getRuning() {
    return runing;
  }

  /**
   * Sets runing.
   *
   * @param runing the runing
   * @author : ligangwei / 2018-12-29
   */
  public void setRuning(Integer runing) {
    this.runing = runing;
  }

  /**
   * Get wait integer.
   *
   * @return the integer
   * @author : ligangwei / 2018-12-29
   */
  public Integer getWait() {
    return wait;
  }

  /**
   * Sets wait.
   *
   * @param wait the wait
   * @author : ligangwei / 2018-12-29
   */
  public void setWait(Integer wait) {
    this.wait = wait;
  }

  /**
   * Get alarm integer.
   *
   * @return the integer
   * @author : ligangwei / 2018-12-29
   */
  public Integer getAlarm() {
    return alarm;
  }

  /**
   * Sets alarm.
   *
   * @param alarm the alarm
   * @author : ligangwei / 2018-12-29
   */
  public void setAlarm(Integer alarm) {
    this.alarm = alarm;
  }
}
