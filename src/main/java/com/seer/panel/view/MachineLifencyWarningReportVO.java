package com.seer.panel.view;

import com.seer.panel.model.KnifeLifencyWarningReport;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.util.CollectionUtils;

/**
 * @autheor ligw
 * @date 2018/8/23 20:32
 */
@ApiModel(description = "机床寿命预警统计")
public class MachineLifencyWarningReportVO {

  @ApiModelProperty(value = "机床名称")
  private String machineName;

  private List<KnifeLifency> knifeLifencyList;

  public String getMachineName() {
    return machineName;
  }

  public void setMachineName(String machineName) {
    this.machineName = machineName;
  }

  public List<KnifeLifency> getKnifeLifencyList() {
    return knifeLifencyList;
  }

  public void setKnifeLifencyList(List<KnifeLifencyWarningReport> knifeLifencyWarningReportList) {
    if (CollectionUtils.isEmpty(knifeLifencyWarningReportList)) {
      return;
    }
    List<KnifeLifency> knifeLifencyList = new ArrayList<>();
    for (KnifeLifencyWarningReport knifeLifencyWarningReport : knifeLifencyWarningReportList) {
      KnifeLifency knifeLifency = new KnifeLifency();
      knifeLifency.setCurrentLife(knifeLifencyWarningReport.getCurrentLife());
      knifeLifency.setKnifePosition(knifeLifencyWarningReport.getKnifePosition());
      knifeLifency.setTotalCount(knifeLifencyWarningReport.getTotalCount());
      knifeLifency.setSurplusLife(
          knifeLifencyWarningReport.getTotalCount() - knifeLifencyWarningReport.getCurrentLife());
    }
    this.knifeLifencyList = knifeLifencyList;
  }

  @ApiModel(description = "刀具寿命统计")
  class KnifeLifency {

    @ApiModelProperty(value = "机床刀位")
    private String knifePosition;

    @ApiModelProperty(value = "总寿命次数")
    private Integer totalCount;

    @ApiModelProperty(value = "已使用次数")
    private Integer currentLife;

    @ApiModelProperty(value = "剩余次数")
    private Integer surplusLife;

    public String getKnifePosition() {
      return knifePosition;
    }

    public void setKnifePosition(String knifePosition) {
      this.knifePosition = knifePosition;
    }

    public Integer getTotalCount() {
      return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
      this.totalCount = totalCount;
    }

    public Integer getCurrentLife() {
      return currentLife;
    }

    public void setCurrentLife(Integer currentLife) {
      this.currentLife = currentLife;
    }

    public Integer getSurplusLife() {
      return surplusLife;
    }

    public void setSurplusLife(Integer surplusLife) {
      this.surplusLife = surplusLife;
    }
  }


}
