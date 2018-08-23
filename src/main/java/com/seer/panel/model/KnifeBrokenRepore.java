package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * @autheor ligw
 * @date 2018/8/23 20:39
 */
@ApiModel(description = "断刀频率统计")
public class KnifeBrokenRepore implements Serializable {

  @ApiModelProperty(value = "机床名称")
  private String machineName;

  @ApiModelProperty(value = "刀径")
  private String knifeDiameter;

  @ApiModelProperty(value = "断刀数量")
  private String brokenNum;
}
