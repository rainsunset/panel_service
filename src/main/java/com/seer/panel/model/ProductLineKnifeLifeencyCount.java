package com.seer.panel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author : ligangwei / ligangwei@seerbigdata.com
 * @version : 1.0
 * @autheor ligw
 * @date 2018 /9/3 17:35
 */
@ApiModel(description = "产线刀具寿命统计")
public class ProductLineKnifeLifeencyCount {

	/**
	 * C line
	 */
	@ApiModelProperty(value = "产线")
	private String cLine;

	/**
	 * Count 1
	 */
	@ApiModelProperty(value = "良好")
	private Integer iCount1;

	/**
	 * Count 2
	 */
	@ApiModelProperty(value = "一般")
	private Integer iCount2;

	/**
	 * Count 3
	 */
	@ApiModelProperty(value = "严重")
	private Integer iCount3;

	/**
	 * Count
	 */
	@ApiModelProperty(value = "总和")
	private Integer iCount;

	/**
	 * Getc line string.
	 *
	 * @return the string
	 * @author : ligangwei / 2018-12-29
	 */
	public String getcLine() {
		return cLine;
	}

	/**
	 * Sets line.
	 *
	 * @param cLine the c line
	 * @author : ligangwei / 2018-12-29
	 */
	public void setcLine(String cLine) {
		this.cLine = cLine;
	}

	/**
	 * Geti count 1 integer.
	 *
	 * @return the integer
	 * @author : ligangwei / 2018-12-29
	 */
	public Integer getiCount1() {
		return iCount1;
	}

	/**
	 * Sets count 1.
	 *
	 * @param iCount1 the count 1
	 * @author : ligangwei / 2018-12-29
	 */
	public void setiCount1(Integer iCount1) {
		this.iCount1 = iCount1;
	}

	/**
	 * Geti count 2 integer.
	 *
	 * @return the integer
	 * @author : ligangwei / 2018-12-29
	 */
	public Integer getiCount2() {
		return iCount2;
	}

	/**
	 * Sets count 2.
	 *
	 * @param iCount2 the count 2
	 * @author : ligangwei / 2018-12-29
	 */
	public void setiCount2(Integer iCount2) {
		this.iCount2 = iCount2;
	}

	/**
	 * Geti count 3 integer.
	 *
	 * @return the integer
	 * @author : ligangwei / 2018-12-29
	 */
	public Integer getiCount3() {
		return iCount3;
	}

	/**
	 * Sets count 3.
	 *
	 * @param iCount3 the count 3
	 * @author : ligangwei / 2018-12-29
	 */
	public void setiCount3(Integer iCount3) {
		this.iCount3 = iCount3;
	}

	/**
	 * Geti count integer.
	 *
	 * @return the integer
	 * @author : ligangwei / 2018-12-29
	 */
	public Integer getiCount() {
		return iCount;
	}

	/**
	 * Sets count.
	 *
	 * @param iCount the count
	 * @author : ligangwei / 2018-12-29
	 */
	public void setiCount(Integer iCount) {
		this.iCount = iCount;
	}
}
