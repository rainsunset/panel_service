package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @autheor ligw
 * @date 2018/8/24 10:15
 */
@ApiModel(description = "生产线机床状态统计")
public class ProductLineInfo {

  @ApiModelProperty(value = "显示标题", example = "A栋C产线(18台)")
  private String title;

  @ApiModelProperty(value = "待机数")
  private Integer stop;

  @ApiModelProperty(value = "运行数")
  private Integer runing;

  @ApiModelProperty(value = "空闲数")
  private Integer wait;

  @ApiModelProperty(value = "报警数")
  private Integer alarm;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getStop() {
    return stop;
  }

  public void setStop(Integer stop) {
    this.stop = stop;
  }

  public Integer getRuning() {
    return runing;
  }

  public void setRuning(Integer runing) {
    this.runing = runing;
  }

  public Integer getWait() {
    return wait;
  }

  public void setWait(Integer wait) {
    this.wait = wait;
  }

  public Integer getAlarm() {
    return alarm;
  }

  public void setAlarm(Integer alarm) {
    this.alarm = alarm;
  }
}
