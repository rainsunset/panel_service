package com.seer.panel.service.impl;

import com.seer.panel.common.BaseService;
import com.seer.panel.exception.GlobalErrorInfoEnum;
import com.seer.panel.exception.GlobalErrorInfoException;
import com.seer.panel.mapper.ChartMapper;
import com.seer.panel.model.KnifeBrokenReportByDiameter;
import com.seer.panel.model.KnifeBrokenReportByPosition;
import com.seer.panel.model.KnifeLifencyWarningReport;
import com.seer.panel.model.MachineInfo;
import com.seer.panel.model.MachineProductReport;
import com.seer.panel.model.ProdLineProdReport;
import com.seer.panel.model.ProductLineAlarmReport;
import com.seer.panel.model.ProductLineInfo;
import com.seer.panel.model.ProductLineMachineStatusReport;
import com.seer.panel.service.ChartService;
import com.seer.panel.view.EchartBarOrLineVO;
import com.seer.panel.view.EchartPieVO;
import com.seer.panel.view.MachineLifencyWarningReportVO;
import com.seer.panel.view.ProductLineDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * @autheor ligw
 * @date 2018/8/23 21:11
 */
@Service
public class ChartServiceImpl extends BaseService implements ChartService {

  @Autowired
  private ChartMapper chartMapper;

  @Value("${prodProp.knifeDefaultLife}")
  private Integer knifeDefaultLife;

  @Value("${prodProp.plannedProduction}")
  private Integer plannedProduction;

  @Override
  public EchartBarOrLineVO getMachineProductReport(ProductLineDTO productLine) throws Exception {
    EchartBarOrLineVO echartBarOrLineVO = new EchartBarOrLineVO();
    echartBarOrLineVO.setyAxisname("分钟(min)");
    List<MachineProductReport> machineProductReportList = null;
    try {
      machineProductReportList = chartMapper.getMachineProductReport(productLine);
    } catch (Exception e) {
      logger.error(String.format("获取机床稼动率排行异常 >>> 异常信息:%S",e.toString()));
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
    if (CollectionUtils.isEmpty(machineProductReportList)) {
      return echartBarOrLineVO;
    }
    List<Integer> seriesData = new ArrayList<>();
    List<String> xAxisData = new ArrayList<>();
    for (MachineProductReport machineProductReport:machineProductReportList){
      if (StringUtils.isEmpty(machineProductReport.getMachineName())){
        continue;
      }
      seriesData.add((null == machineProductReport.getMacWorkTime()) ? 0 : machineProductReport.getMacWorkTime());
      xAxisData.add(machineProductReport.getMachineName());
    }
    echartBarOrLineVO.setxAxisData(xAxisData);
    echartBarOrLineVO.addSeriesData(seriesData);
    return echartBarOrLineVO;
  }

  @Override
  public ProductLineMachineStatusReport getProductLineMachineStatusReport(
      ProductLineDTO productLine) throws Exception {
    ProductLineMachineStatusReport productLineMachineStatusReport = new ProductLineMachineStatusReport();
    List<List<?>> results = new ArrayList<>();
    try {
      results = chartMapper.getProductLineMachineStatusReport(productLine);
    } catch (Exception e) {
      logger.error(String.format("获取机床实时状态 异常 >>> 异常信息:%S",e.toString()));
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
      List<MachineInfo> machineInfoList = (List<MachineInfo>) results.get(0);
      List<ProductLineInfo> productLineInfoList = (List<ProductLineInfo>) results.get(1);
      productLineMachineStatusReport.setMachineInfoList(machineInfoList);
      if (!CollectionUtils.isEmpty(productLineInfoList)){
        productLineMachineStatusReport.setProductLineInfo(productLineInfoList.get(0));
      }
    return productLineMachineStatusReport;
  }

  @Override
  public List<ProductLineAlarmReport> getProductLineAlarmReport(ProductLineDTO productLine)
      throws Exception {
    List<ProductLineAlarmReport> productLineAlarmReportList = null;
    try {
      productLineAlarmReportList = chartMapper.getProductLineAlarmReport(productLine);
    } catch (Exception e) {
      logger.error(String.format("获取生产线报警信息异常 >>> 异常信息:%S",e.toString()));
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
    return productLineAlarmReportList;
  }

  @Override
  public List<MachineLifencyWarningReportVO> getMachineLifencyWarningReport(ProductLineDTO productLine)
      throws Exception {
    List<KnifeLifencyWarningReport> knifeLifencyWarningReportList = null;
    try {
      knifeLifencyWarningReportList = chartMapper.getKnifeLifencyWarningReport(productLine);
    } catch (Exception e) {
      logger.error(String.format("获取刀具寿命报警信息异常 >>> 异常信息:%S",e.toString()));
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
    if (CollectionUtils.isEmpty(knifeLifencyWarningReportList)){
      return null;
    }
    // 结果分组
    Map<String, List<KnifeLifencyWarningReport>> KnifeLifencyWarningReportCollect = new HashMap<>();
    for (KnifeLifencyWarningReport knifeLifencyWarningReport : knifeLifencyWarningReportList) {
      if (null == knifeLifencyWarningReport.getTotalCount() || 1 > knifeLifencyWarningReport.getTotalCount()) {
        knifeLifencyWarningReport.setTotalCount(knifeDefaultLife);
      }
      String machineName = knifeLifencyWarningReport.getMachineName();
      List<KnifeLifencyWarningReport> list = KnifeLifencyWarningReportCollect.get(machineName);
      if (CollectionUtils.isEmpty(list)){
        list = new ArrayList<KnifeLifencyWarningReport>();
        list.add(knifeLifencyWarningReport);
        KnifeLifencyWarningReportCollect.put(machineName, list);
      } else {
        list.add(knifeLifencyWarningReport);
      }
    }
    //整理分组
    List<MachineLifencyWarningReportVO> machineLifencyWarningReportVOList = new ArrayList<>();
    for (Map.Entry<String, List<KnifeLifencyWarningReport>> entry : KnifeLifencyWarningReportCollect.entrySet()) {
      MachineLifencyWarningReportVO machineLifencyWarningReportVO = new MachineLifencyWarningReportVO();
      machineLifencyWarningReportVO.setMachineName(entry.getKey());
      machineLifencyWarningReportVO.setKnifeLifencyList(entry.getValue());
      machineLifencyWarningReportVOList.add(machineLifencyWarningReportVO);
    }
    return machineLifencyWarningReportVOList;
  }

  @Override
  public EchartBarOrLineVO getKnifeBrokenReportByDiameter(ProductLineDTO productLine) throws Exception {
    EchartBarOrLineVO echartBarOrLineVO = new EchartBarOrLineVO();
    echartBarOrLineVO.setyAxisname("单位（次）");
    List<KnifeBrokenReportByDiameter> knifeBrokenReportByDiameterList = null;
    try {
      knifeBrokenReportByDiameterList = chartMapper.getKnifeBrokenReportByDiameter(productLine);
    } catch (Exception e) {
      logger.error(String.format("断刀频率统计(按刀径) >>> 异常信息:%S",e.toString()));
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
    if (CollectionUtils.isEmpty(knifeBrokenReportByDiameterList)){
      return echartBarOrLineVO;
    }
    List<String> xAxisData = new ArrayList<>();
    List<Integer> serieData = new ArrayList<>();
    for (KnifeBrokenReportByDiameter knifeBrokenReportByDiameter : knifeBrokenReportByDiameterList) {
      if (StringUtils.isEmpty(knifeBrokenReportByDiameter.getKnifeDiameter())){
        continue;
      }
      xAxisData.add(knifeBrokenReportByDiameter.getKnifeDiameter());
      serieData.add((null == knifeBrokenReportByDiameter.getBrokenNum()) ? 0
              : knifeBrokenReportByDiameter.getBrokenNum());
    }
    echartBarOrLineVO.setxAxisData(xAxisData);
    echartBarOrLineVO.addSeriesData(serieData);
    return echartBarOrLineVO;
  }

  @Override
  public EchartPieVO getKnifeBrokenReportByPosition(ProductLineDTO productLine) throws Exception {
    EchartPieVO echartPieVO = new EchartPieVO();
    List<KnifeBrokenReportByPosition> knifeBrokenReportByPositionList = null;
    try {
      knifeBrokenReportByPositionList = chartMapper.getKnifeBrokenReportByPosition(productLine);
    } catch (Exception e) {
      logger.error(String.format("断刀频率统计(按刀位) >>> 异常信息:%S",e.toString()));
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
    if (CollectionUtils.isEmpty(knifeBrokenReportByPositionList)) {
      return echartPieVO;
    }
    List<Map<String, Object>> serieDatas = new ArrayList<>();
    for (KnifeBrokenReportByPosition knifeBrokenReportByPosition : knifeBrokenReportByPositionList) {
      if (null == knifeBrokenReportByPosition.getKnifeNum()) {
        continue;
      }
      Map<String, Object> serieData = new HashMap<>();
      serieData.put("name",knifeBrokenReportByPosition.getKnifeNum());
      serieData.put("value",(null == knifeBrokenReportByPosition.getBrokenNum()) ? 0 : knifeBrokenReportByPosition.getBrokenNum());
      serieDatas.add(serieData);
    }
    echartPieVO.addSerie(serieDatas);
    return echartPieVO;
  }

  @Override
  public ProdLineProdReport getProdLineProdReport(ProductLineDTO productLineDTO) throws Exception {
    ProdLineProdReport prodLineProdReport = new ProdLineProdReport();
    prodLineProdReport.setProductionLine(productLineDTO.getProductionLine());
    try {
      prodLineProdReport.setProdLineProdNum(chartMapper.getProdLineProdReport(productLineDTO));
    } catch (Exception e) {
      logger.error(String.format(" 生产线生产统计 >>> 异常信息:%S",e.toString()));
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
    //TODO 调接口拿数据
    prodLineProdReport.setPlannedProduction(plannedProduction);
    return prodLineProdReport;
  }
}
