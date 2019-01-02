package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * @author : ligangwei / ligangwei@seerbigdata.com
 * @version : 1.0
 * @autheor ligw
 * @date 2018 /8/24 10:13
 */
@ApiModel(description = "机床状态信息")
public class MachineInfo implements Serializable {

  /**
   * Machine code
   */
  @ApiModelProperty(value = "机床编码", example = "000000026")
  private String machineCode;

  /**
   * Machine name
   */
  @ApiModelProperty(value = "机床名称", example = "C04")
  private String machineName;

  /**
   * Factory
   */
  @ApiModelProperty(value = "工厂", example = "东城")
  private String factory;

  /**
   * Works shop
   */
  @ApiModelProperty(value = "车间", example = "A栋")
  private String worksShop;

  /**
   * Poduct line
   */
  @ApiModelProperty(value = "产线", example = "C")
  private String poductLine;

  /**
   * Sample id
   */
  @ApiModelProperty(value = "")
  private String iSampleId;

  /**
   * Status
   */
  @ApiModelProperty(value = "状态 [0 - stop] [1 - runing] [2 - wait] [3 - alarm]")
  private Integer status;

  /**
   * Occurrence time
   */
  @ApiModelProperty(value = "更新时间", example = "2018-08-20 16:52")
  private String occurrenceTime;

  /**
   * Get machine code string.
   *
   * @return the string
   * @author : ligangwei / 2018-12-29
   */
  public String getMachineCode() {
    return machineCode;
  }

  /**
   * Sets machine code.
   *
   * @param machineCode the machine code
   * @author : ligangwei / 2018-12-29
   */
  public void setMachineCode(String machineCode) {
    this.machineCode = machineCode;
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
   * Get factory string.
   *
   * @return the string
   * @author : ligangwei / 2018-12-29
   */
  public String getFactory() {
    return factory;
  }

  /**
   * Sets factory.
   *
   * @param factory the factory
   * @author : ligangwei / 2018-12-29
   */
  public void setFactory(String factory) {
    this.factory = factory;
  }

  /**
   * Get works shop string.
   *
   * @return the string
   * @author : ligangwei / 2018-12-29
   */
  public String getWorksShop() {
    return worksShop;
  }

  /**
   * Sets works shop.
   *
   * @param worksShop the works shop
   * @author : ligangwei / 2018-12-29
   */
  public void setWorksShop(String worksShop) {
    this.worksShop = worksShop;
  }

  /**
   * Get poduct line string.
   *
   * @return the string
   * @author : ligangwei / 2018-12-29
   */
  public String getPoductLine() {
    return poductLine;
  }

  /**
   * Sets poduct line.
   *
   * @param poductLine the poduct line
   * @author : ligangwei / 2018-12-29
   */
  public void setPoductLine(String poductLine) {
    this.poductLine = poductLine;
  }

  /**
   * Geti sample id string.
   *
   * @return the string
   * @author : ligangwei / 2018-12-29
   */
  public String getiSampleId() {
    return iSampleId;
  }

  /**
   * Sets sample id.
   *
   * @param iSampleId the sample id
   * @author : ligangwei / 2018-12-29
   */
  public void setiSampleId(String iSampleId) {
    this.iSampleId = iSampleId;
  }

  /**
   * Get status integer.
   *
   * @return the integer
   * @author : ligangwei / 2018-12-29
   */
  public Integer getStatus() {
    return status;
  }

  /**
   * Sets status.
   *
   * @param status the status
   * @author : ligangwei / 2018-12-29
   */
  public void setStatus(Integer status) {
    this.status = status;
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
