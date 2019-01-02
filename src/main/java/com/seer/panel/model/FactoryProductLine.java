package com.seer.panel.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author : ligangwei / ligangwei@seerbigdata.com
 * @version : 1.0
 * @autheor ligw
 * @date 2018 /9/3 12:00
 */
public class FactoryProductLine {

	/**
	 * Production line
	 */
	@ApiModelProperty(value = "产线",required = true,example = "C")
	private String productionLine;

	/**
	 * Works shop
	 */
	@ApiModelProperty(value = "车间",required = true,example = "A栋")
	private String worksShop;

	/**
	 * Factory
	 */
	@ApiModelProperty(value = "工厂",required = true,example = "东城")
	private String factory;

	/**
	 * Cnc system
	 */
	@ApiModelProperty(value = "CNC系统",required = true,example = "HNC")
	private String cncSystem;

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
	 * Get cnc system string.
	 *
	 * @return the string
	 * @author : ligangwei / 2018-12-29
	 */
	public String getCncSystem() {
		return cncSystem;
	}

	/**
	 * Sets cnc system.
	 *
	 * @param cncSystem the cnc system
	 * @author : ligangwei / 2018-12-29
	 */
	public void setCncSystem(String cncSystem) {
		this.cncSystem = cncSystem;
	}
}
