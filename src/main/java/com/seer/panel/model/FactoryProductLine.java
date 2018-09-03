package com.seer.panel.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * @autheor ligw
 * @date 2018/9/3 12:00
 */
public class FactoryProductLine {

	@ApiModelProperty(value = "产线",required = true,example = "C")
	private String productionLine;

	@ApiModelProperty(value = "车间",required = true,example = "A栋")
	private String worksShop;

	@ApiModelProperty(value = "工厂",required = true,example = "东城")
	private String factory;

	@ApiModelProperty(value = "CNC系统",required = true,example = "HNC")
	private String cncSystem;

	public String getProductionLine() {
		return productionLine;
	}

	public void setProductionLine(String productionLine) {
		this.productionLine = productionLine;
	}

	public String getWorksShop() {
		return worksShop;
	}

	public void setWorksShop(String worksShop) {
		this.worksShop = worksShop;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getCncSystem() {
		return cncSystem;
	}

	public void setCncSystem(String cncSystem) {
		this.cncSystem = cncSystem;
	}
}
