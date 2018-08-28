package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * @autheor ligw
 * @date 2018/8/23 20:21
 */
@ApiModel(description = "机床报警信息统计")
public class ProductLineAlarmReport implements Serializable {

  @ApiModelProperty(value = "机床名称" ,example = "B03")
  private String machineName;

  @ApiModelProperty(value = "报警信息")
  private String alarmMsg;

  @ApiModelProperty(value = "报警刀位")
  private Integer knifeNum;

  @ApiModelProperty(value = "报警时间")
  private String  occurrenceTime;

  public String getMachineName() {
    return machineName;
  }

  public void setMachineName(String machineName) {
    this.machineName = machineName;
  }

  public String getAlarmMsg() {
    return alarmMsg;
  }

  public void setAlarmMsg(String alarmMsg) {
    this.alarmMsg = alarmMsg;
  }

  public Integer getKnifeNum() {
    return knifeNum;
  }

  public void setKnifeNum(Integer knifeNum) {
    this.knifeNum = knifeNum;
  }

  public String getOccurrenceTime() {
    return occurrenceTime;
  }

  public void setOccurrenceTime(String occurrenceTime) {
    this.occurrenceTime = occurrenceTime;
  }
}
