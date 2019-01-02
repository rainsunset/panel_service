package com.seer.panel.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * @author : ligangwei / ligangwei@seerbigdata.com
 * @version : 1.0
 * @autheor ligw
 * @date 2018 /8/31 10:56
 */
public class KnifeBrokenReportByPosition implements Serializable {

	/**
	 * Production line
	 */
	@ApiModelProperty(value = "产线")
	private String productionLine;

	/**
	 * Knife num
	 */
	@ApiModelProperty(value = "刀位")
	private String knifeNum;

	/**
	 * Broken num
	 */
	@ApiModelProperty(value = "断刀数量")
	private Integer brokenNum;

	/**
	 * Get production line string.
	 *
	 * @return the string
	 * @author : ligangwei / 2018-12-29
	 */
	public String getProductionLine() {
		return productionLine;
	}

	/**
	 * Sets production line.
	 *
	 * @param productionLine the production line
	 * @author : ligangwei / 2018-12-29
	 */
	public void setProductionLine(String productionLine) {
		this.productionLine = productionLine;
	}

	/**
	 * Get knife num string.
	 *
	 * @return the string
	 * @author : ligangwei / 2018-12-29
	 */
	public String getKnifeNum() {
		return knifeNum;
	}

	/**
	 * Sets knife num.
	 *
	 * @param knifeNum the knife num
	 * @author : ligangwei / 2018-12-29
	 */
	public void setKnifeNum(String knifeNum) {
		this.knifeNum = knifeNum;
	}

	/**
	 * Get broken num integer.
	 *
	 * @return the integer
	 * @author : ligangwei / 2018-12-29
	 */
	public Integer getBrokenNum() {
		return brokenNum;
	}

	/**
	 * Sets broken num.
	 *
	 * @param brokenNum the broken num
	 * @author : ligangwei / 2018-12-29
	 */
	public void setBrokenNum(Integer brokenNum) {
		this.brokenNum = brokenNum;
	}
}
