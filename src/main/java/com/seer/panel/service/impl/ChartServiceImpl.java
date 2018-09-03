package com.seer.panel.service.impl;


import com.seer.panel.common.BaseService;
import com.seer.panel.config.db.DataSourceContextHolder;
import com.seer.panel.exception.GlobalErrorInfoEnum;
import com.seer.panel.exception.GlobalErrorInfoException;
import com.seer.panel.mapper.db1.ChartMapper;
import com.seer.panel.mapper.db2.MesInfoMapper;
import com.seer.panel.model.FactoryProductLine;
import com.seer.panel.model.KnifeBrokenReportByDiameter;
import com.seer.panel.model.KnifeBrokenReportByPosition;
import com.seer.panel.model.KnifeLifencyWarningReport;
import com.seer.panel.model.MachineInfo;
import com.seer.panel.model.MachineProductReport;
import com.seer.panel.model.ProdLineProdReport;
import com.seer.panel.model.ProductLineAlarmReport;
import com.seer.panel.model.ProductLineKnifeLifeencyCount;
import com.seer.panel.model.ProductLineStatus;
import com.seer.panel.model.ProductLineMachineStatusReport;
import com.seer.panel.service.ChartService;
import com.seer.panel.view.EchartBarOrLineVO;
import com.seer.panel.view.EchartPieVO;
import com.seer.panel.view.EchartRadarVO;
import com.seer.panel.view.ProductLineDTO;
import com.seer.panel.view.ProductionDirectorVO;
import java.util.ArrayList;
import java.util.List;
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

  @Autowired
  private MesInfoMapper mesInfoMapper;

  @Override
  public List<FactoryProductLine> getFactoryProductLine() {
    List<FactoryProductLine> factoryProductLineList = null;
    try {
      factoryProductLineList = chartMapper.getFactoryProductLine();
    } catch (Exception e) {
      logger.error(String.format("工厂产线信息 >>> 异常信息:%S",e.toString()));
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
    return factoryProductLineList;
  }

  @Override
  public EchartBarOrLineVO getMachineProductReport(ProductLineDTO productLine) throws Exception {
    EchartBarOrLineVO echartBarOrLineVO = new EchartBarOrLineVO();
    echartBarOrLineVO.setyAxisname("分钟(min)");
    List<MachineProductReport> machineProductReportList = null;
    System.out.println(DataSourceContextHolder.getDbType());
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
      List<ProductLineStatus> productLineStatusList = (List<ProductLineStatus>) results.get(1);
      productLineMachineStatusReport.setMachineInfoList(machineInfoList);
      if (!CollectionUtils.isEmpty(productLineStatusList)){
        productLineMachineStatusReport.setProductLineStatus(productLineStatusList.get(0));
      }
    return productLineMachineStatusReport;
  }

  @Override
  public EchartPieVO getProductLineKnifeLifeencyCount(
          ProductLineDTO productLine) throws Exception {
    List<ProductLineKnifeLifeencyCount> productLineKnifeLifeencyCountList = new ArrayList<>();
    try {
      productLineKnifeLifeencyCountList = chartMapper.getProductLineKnifeLifeencyCount(productLine);
    } catch (Exception e) {
      logger.error(String.format("刀具寿命统计 异常 >>> 异常信息:%S",e.toString()));
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
    if (CollectionUtils.isEmpty(productLineKnifeLifeencyCountList)) {
      return null;
    }
    EchartPieVO echartPieVO = new EchartPieVO();
    // TODO 转化成饼图
    return echartPieVO;
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
  public EchartBarOrLineVO getMachineLifencyWarningReport(ProductLineDTO productLine)
      throws Exception {
    EchartBarOrLineVO echartBarOrLineVO = new EchartBarOrLineVO();
    List<KnifeLifencyWarningReport> knifeLifencyWarningReportList = null;
    try {
      knifeLifencyWarningReportList = chartMapper.getKnifeLifencyWarningReport(productLine);
    } catch (Exception e) {
      logger.error(String.format("获取刀具寿命报警信息异常 >>> 异常信息:%S",e.toString()));
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
    if (CollectionUtils.isEmpty(knifeLifencyWarningReportList)){
      return echartBarOrLineVO;
    }
    //整理分组
    List<String> xAxisData = new ArrayList<>();
    List<Integer> seriesData = new ArrayList<>();
    for (KnifeLifencyWarningReport knifeLifencyWarningReport : knifeLifencyWarningReportList) {
      String machineName = knifeLifencyWarningReport.getMachineName();
      String knifePosition = knifeLifencyWarningReport.getKnifePosition();
      if (StringUtils.isEmpty(machineName) || StringUtils.isEmpty(knifePosition)){
        continue;
      }
      Integer currentCount =
              (null == knifeLifencyWarningReport.getCurrentCount() || 0 > knifeLifencyWarningReport
                      .getCurrentCount())
                      ? 0 : knifeLifencyWarningReport.getCurrentCount();
      Integer totakCount = (null == knifeLifencyWarningReport.getTotalCount() || 1 > knifeLifencyWarningReport
                      .getTotalCount())
                      ? knifeDefaultLife : knifeLifencyWarningReport.getTotalCount();
      Integer surplusCount = (0 > totakCount - currentCount) ? 0 : (totakCount - currentCount);
      xAxisData.add(String.format("%s%nT%s", machineName, seriesData));
      seriesData.add(surplusCount);
    }
    echartBarOrLineVO.setxAxisData(xAxisData);
    echartBarOrLineVO.setyAxisname( "件");
    echartBarOrLineVO.addSeriesData(seriesData);
    return echartBarOrLineVO;
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
  public EchartRadarVO getKnifeBrokenReportByPosition(ProductLineDTO productLine) throws Exception {
    EchartRadarVO echartRadarVO = new EchartRadarVO();
    List<KnifeBrokenReportByPosition> knifeBrokenReportByPositionList = null;
    try {
      knifeBrokenReportByPositionList = chartMapper.getKnifeBrokenReportByPosition(productLine);
    } catch (Exception e) {
      logger.error(String.format("断刀频率统计(按刀位) >>> 异常信息:%S",e.toString()));
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
    if (CollectionUtils.isEmpty(knifeBrokenReportByPositionList)) {
      return echartRadarVO;
    }
    List<String> indicatorName = new ArrayList<>();
    List<Integer> value = new ArrayList<>();
    int maxValue = 0;
    for (KnifeBrokenReportByPosition knifeBrokenReportByPosition : knifeBrokenReportByPositionList) {
      String knifeNum = knifeBrokenReportByPosition.getKnifeNum();
      if (null == knifeBrokenReportByPosition.getKnifeNum()) {
        continue;
      }
      Integer brokenNum = (null == knifeBrokenReportByPosition.getBrokenNum()) ? 0 :knifeBrokenReportByPosition.getBrokenNum();
      indicatorName.add(String.format("%s号刀（%d次）",knifeNum,brokenNum));
      value.add(brokenNum);
      maxValue = Math.max(maxValue, brokenNum);
    }
    for (String s : indicatorName) {
      echartRadarVO.addIndicator(s,maxValue);
    }
    echartRadarVO.setValue(value);
    return echartRadarVO;
  }

  @Override
  public ProdLineProdReport getProdLineProdReport(ProductLineDTO productLineDTO) throws Exception {
    //TODO NEED REWRITE
    ProdLineProdReport prodLineProdReport = null;
//    prodLineProdReport.setProductionLine(productLineDTO.getProductionLine());
//    try {
//      prodLineProdReport.setProdLineProdNum(chartMapper.getProdLineProdReport(productLineDTO));
//    } catch (Exception e) {
//      logger.error(String.format(" 生产线生产统计 >>> 异常信息:%S",e.toString()));
//      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
//    }
//    prodLineProdReport.setPlannedProduction(plannedProduction);
    try {
        prodLineProdReport = mesInfoMapper.getProdLineProdReport();
    } catch (Exception e) {
      logger.error(String.format("MES 生产线生产统计 >>> 异常信息:%S",e.toString()));
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
    return prodLineProdReport;
  }

  @Override
  public ProductionDirectorVO getProductionDirector(ProductLineDTO productLineDTO)
          throws Exception {
            return null;
  }
}
