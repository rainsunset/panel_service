package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @autheor ligw
 * @date 2018/9/3 17:35
 */
@ApiModel(description = "产线刀具寿命统计")
public class ProductLineKnifeLifeencyCount {

	@ApiModelProperty(value = "产线")
	private String cLine;

	@ApiModelProperty(value = "良好")
	private Integer iCount1;

	@ApiModelProperty(value = "一般")
	private Integer iCount2;

	@ApiModelProperty(value = "严重")
	private Integer iCount3;

	public String getcLine() {
		return cLine;
	}

	public void setcLine(String cLine) {
		this.cLine = cLine;
	}

	public Integer getiCount1() {
		return iCount1;
	}

	public void setiCount1(Integer iCount1) {
		this.iCount1 = iCount1;
	}

	public Integer getiCount2() {
		return iCount2;
	}

	public void setiCount2(Integer iCount2) {
		this.iCount2 = iCount2;
	}

	public Integer getiCount3() {
		return iCount3;
	}

	public void setiCount3(Integer iCount3) {
		this.iCount3 = iCount3;
	}
}
