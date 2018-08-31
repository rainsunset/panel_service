package com.seer.panel.mapper;

import com.seer.panel.model.KnifeBrokenReporeByDiameter;
import com.seer.panel.model.KnifeBrokenReporeByPosition;
import com.seer.panel.model.KnifeLifencyWarningReport;
import com.seer.panel.model.MachineProductReport;
import com.seer.panel.view.ProductLineDTO;
import com.seer.panel.model.ProductLineAlarmReport;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @autheor ligw
 * @date 2018/8/23 20:20
 */
@Repository
public interface ChartMapper {

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
  public List<List<?>> getProductLineMachineStatusReport(ProductLineDTO productLine) throws Exception;

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
  public List<KnifeLifencyWarningReport> getKnifeLifencyWarningReport(ProductLineDTO productLine) throws Exception;

  /**
   * 断刀频率统计(按刀径)
   * @param productLine
   * @return
   */
  public List<KnifeBrokenReporeByDiameter> getKnifeBrokenReporeByDiameter (ProductLineDTO productLine) throws Exception;

  public List<KnifeBrokenReporeByPosition> getKnifeBrokenReporeByPosition(ProductLineDTO productLine) throws Exception;

  /**
   * 生产线生产统计
   * @param productLineDTO
   * @return
   * @throws Exception
   */
  public Integer getProdLineProdReport(ProductLineDTO productLineDTO)throws Exception;

}
