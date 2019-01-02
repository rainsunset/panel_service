package com.seer.panel.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * 生产线信息
 * @author : ligangwei / ligangwei@seerbigdata.com
 * @version : 1.0
 * @date 2018 /8/23 19:42
 */
@ApiModel(description = "生产线信息")
public class ProductLineDTO implements Serializable {

  @ApiModelProperty(value = "产线",required = true,example = "C")
  private String productionLine;

  @ApiModelProperty(value = "车间",required = true,example = "A栋")
  private String worksShop;

  @ApiModelProperty(value = "工厂",required = true,example = "东城")
  private String factory;

  @ApiModelProperty(value = "数据系统类型")
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
