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
 * @autheor ligw
 * @date 2018/8/23 21:09
 */
public interface ChartService {

  /**
   * 工厂产线信息
   * @return
   */
  List<FactoryProductLine> getFactoryProductLine();
  /**
   * 机床稼动率排行 生产数
   * @param productLine
   * @return
   */
  public EchartBarOrLineVO getMachineProductReport(ProductLineDTO productLine) throws Exception;

  /**
   * 机器实时状态
   * @param productLine
   * @return
   */
  public ProductLineMachineStatusReport getProductLineMachineStatusReport(ProductLineDTO productLine) throws Exception;

  /**
   * 刀具寿命统计
   * @param productLine
   * @return
   * @throws Exception
   */
  public EchartPieVO getProductLineKnifeLifeencyCount(ProductLineDTO productLine) throws Exception;

  /**
   * 生产线报警
   * @param productLine
   * @return
   */
  public List<ProductLineAlarmReport> getProductLineAlarmReport(ProductLineDTO productLine) throws Exception;

  /**
   * 刀具寿命报警
   * @param productLine
   * @return
   */
  public EchartBarOrLineVO getMachineLifencyWarningReport(ProductLineDTO productLine) throws Exception;

  /**
   * 断刀频率统计(按刀径)
   * @param productLine
   * @return
   */
  public EchartBarOrLineVO getKnifeBrokenReportByDiameter(ProductLineDTO productLine) throws Exception;

  /**
   * 断刀频率统计(按刀径)
   * @param productLine
   * @return
   */
  public EchartRadarVO getKnifeBrokenReportByPosition(ProductLineDTO productLine) throws Exception;

  /**
   * 生产线生产统计
   * @param productLineDTO
   * @return
   * @throws Exception
   */
  public ProdLineProdReport getProdLineProdReport(ProductLineDTO productLineDTO)throws Exception;

  /**
   * 生产负责人
   * @param productLineDTO
   * @return
   * @throws Exception
   */
  public ProductionDirectorVO getProductionDirector(ProductLineDTO productLineDTO)throws Exception;

}
