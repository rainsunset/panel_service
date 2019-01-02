package com.seer.panel.service;

import com.seer.panel.model.FactoryProductLine;
import com.seer.panel.model.ProdLineProdReport;
import com.seer.panel.model.ProductLineAlarmReport;
import com.seer.panel.model.ProductLineMachineStatusReport;
import com.seer.panel.view.EchartBarOrLineVO;
import com.seer.panel.view.EchartPieVO;
import com.seer.panel.view.EchartRadarVO;
import com.seer.panel.view.ProductLineDTO;
import com.seer.panel.view.ProductionDirectorVO;
import java.util.List;

/**
 * 生产线看板 - 服务接口
 * @author : l
 * igangwei / ligangwei@seerbigdata.com
 * @autheor ligw
 * @date 2018 /8/23 21:09
 */
public interface ChartService {

  /**
   * 工厂产线信息
   *
   * @return list
   * @author : ligangwei / 2018-12-29
   */
  List<FactoryProductLine> getFactoryProductLine();

  /**
   * 机床稼动率排行 生产数
   *
   * @param productLine the product line
   * @return echart bar or line vo
   * @throws Exception the exception
   * @author : ligangwei / 2018-12-29
   */
  public EchartBarOrLineVO getMachineProductReport(ProductLineDTO productLine) throws Exception;

  /**
   * 机器实时状态
   *
   * @param productLine the product line
   * @return product line machine status report
   * @throws Exception the exception
   * @author : ligangwei / 2018-12-29
   */
  public ProductLineMachineStatusReport getProductLineMachineStatusReport(ProductLineDTO productLine) throws Exception;

  /**
   * 刀具寿命统计
   *
   * @param productLine the product line
   * @return echart pie vo
   * @throws Exception the exception
   * @author : ligangwei / 2018-12-29
   */
  public EchartPieVO getProductLineKnifeLifeencyCount(ProductLineDTO productLine) throws Exception;

  /**
   * 生产线报警
   *
   * @param productLine the product line
   * @return list
   * @throws Exception the exception
   * @author : ligangwei / 2018-12-29
   */
  public List<ProductLineAlarmReport> getProductLineAlarmReport(ProductLineDTO productLine) throws Exception;

  /**
   * 刀具寿命报警
   *
   * @param productLine the product line
   * @return echart bar or line vo
   * @throws Exception the exception
   * @author : ligangwei / 2018-12-29
   */
  public EchartBarOrLineVO getMachineLifencyWarningReport(ProductLineDTO productLine) throws Exception;

  /**
   * 断刀频率统计(按刀径)
   *
   * @param productLine the product line
   * @return echart bar or line vo
   * @throws Exception the exception
   * @author : ligangwei / 2018-12-29
   */
  public EchartBarOrLineVO getKnifeBrokenReportByDiameter(ProductLineDTO productLine) throws Exception;

  /**
   * 断刀频率统计(按刀径)
   *
   * @param productLine the product line
   * @return echart radar vo
   * @throws Exception the exception
   * @author : ligangwei / 2018-12-29
   */
  public EchartRadarVO getKnifeBrokenReportByPosition(ProductLineDTO productLine) throws Exception;

  /**
   * 生产线生产统计
   *
   * @param productLineDTO the product line dto
   * @return prod line prod report
   * @throws Exception the exception
   * @author : ligangwei / 2018-12-29
   */
  public ProdLineProdReport getProdLineProdReport(ProductLineDTO productLineDTO)throws Exception;

  /**
   * 生产负责人
   *
   * @param productLineDTO the product line dto
   * @return production director vo
   * @throws Exception the exception
   * @author : ligangwei / 2018-12-29
   */
  public ProductionDirectorVO getProductionDirector(ProductLineDTO productLineDTO)throws Exception;

}
