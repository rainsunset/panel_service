package com.seer.panel.service;

import com.seer.panel.model.KnifeBrokenRepore;
import com.seer.panel.model.MachineProductReport;
import com.seer.panel.model.ProductLineAlarmReport;
import com.seer.panel.model.ProductLineMachineStatusReport;
import com.seer.panel.view.MachineLifencyWarningReportVO;
import com.seer.panel.view.ProductLineDTO;
import java.util.List;

/**
 * @autheor ligw
 * @date 2018/8/23 21:09
 */
public interface ChartService {
  /**
   * 机床稼动率排行 生产数
   * @param productLine
   * @return
   */
  public List<MachineProductReport> getMachineProductReport(ProductLineDTO productLine) throws Exception;

  /**
   * 机器实时状态
   * @param productLine
   * @return
   */
  public List<ProductLineMachineStatusReport> getProductLineMachineStatusReport(ProductLineDTO productLine) throws Exception;

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
  public List<MachineLifencyWarningReportVO> getMachineLifencyWarningReport(ProductLineDTO productLine) throws Exception;

  /**
   * 断刀频率统计(按刀径)
   * @param productLine
   * @return
   */
  public List<KnifeBrokenRepore> getKnifeBrokenRepore(ProductLineDTO productLine) throws Exception;
}