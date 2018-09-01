package com.seer.panel.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * @autheor ligw
 * @date 2018/8/31 10:56
 */
public class KnifeBrokenReportByPosition implements Serializable {
	@ApiModelProperty(value = "产线")
	private String productionLine;

	@ApiModelProperty(value = "刀位")
	private String knifeNum;

	@ApiModelProperty(value = "断刀数量")
	private Integer brokenNum;

	public String getProductionLine() {
		return productionLine;
	}

	public void setProductionLine(String productionLine) {
		this.productionLine = productionLine;
	}

	public String getKnifeNum() {
		return knifeNum;
	}

	public void setKnifeNum(String knifeNum) {
		this.knifeNum = knifeNum;
	}

	public Integer getBrokenNum() {
		return brokenNum;
	}

	public void setBrokenNum(Integer brokenNum) {
		this.brokenNum = brokenNum;
	}
}
