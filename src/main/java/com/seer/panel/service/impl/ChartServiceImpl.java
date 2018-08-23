package com.seer.panel.service.impl;

import com.seer.panel.common.BaseService;
import com.seer.panel.exception.GlobalErrorInfoEnum;
import com.seer.panel.exception.GlobalErrorInfoException;
import com.seer.panel.mapper.ChartMapper;
import com.seer.panel.model.KnifeBrokenRepore;
import com.seer.panel.model.KnifeLifencyWarningReport;
import com.seer.panel.model.MachineProductReport;
import com.seer.panel.model.ProductLineAlarmReport;
import com.seer.panel.model.ProductLineMachineStatusReport;
import com.seer.panel.service.ChartService;
import com.seer.panel.view.MachineLifencyWarningReportVO;
import com.seer.panel.view.ProductLineDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * @autheor ligw
 * @date 2018/8/23 21:11
 */
@Service
public class ChartServiceImpl extends BaseService implements ChartService {

  @Autowired
  private ChartMapper chartMapper;

  @Override
  public List<MachineProductReport> getMachineProductReport(ProductLineDTO productLine) throws Exception {
    List<MachineProductReport> machineProductReport = null;
    try {
      machineProductReport = chartMapper.getMachineProductReport(productLine);
    } catch (Exception e) {
      logger.error(String.format("获取机床稼动率排行异常 >>> 异常信息:%S",e.toString()));
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
    return machineProductReport;
  }

  @Override
  public List<ProductLineMachineStatusReport> getProductLineMachineStatusReport(
      ProductLineDTO productLine) throws Exception {
    List<ProductLineMachineStatusReport> productLineMachineStatusReportList = null;
    try {
      productLineMachineStatusReportList = chartMapper.getProductLineMachineStatusReport(productLine);
    } catch (Exception e) {
      logger.error(String.format("获取机床稼动率排行异常 >>> 异常信息:%S",e.toString()));
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
    return productLineMachineStatusReportList;
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
    List<MachineLifencyWarningReportVO> machineLifencyWarningReportVOList = null;
    List<KnifeLifencyWarningReport> knifeLifencyWarningReportList = null;
    try {
      knifeLifencyWarningReportList = chartMapper.getKnifeLifencyWarningReport(productLine);
    } catch (Exception e) {
      logger.error(String.format("获取刀具寿命报警信息异常 >>> 异常信息:%S",e.toString()));
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
    if (CollectionUtils.isEmpty(knifeLifencyWarningReportList)){
      return machineLifencyWarningReportVOList;
    }
    // 结果分组
    Map<String, List<KnifeLifencyWarningReport>> KnifeLifencyWarningReportCollect = new HashMap<>();
    for (KnifeLifencyWarningReport knifeLifencyWarningReport : knifeLifencyWarningReportList) {
      String machineName = knifeLifencyWarningReport.getMachineName();
      List<KnifeLifencyWarningReport> list = KnifeLifencyWarningReportCollect.get(machineName);
      if (CollectionUtils.isEmpty(list)){
        list = new ArrayList<KnifeLifencyWarningReport>();
        list.add(knifeLifencyWarningReport);
        KnifeLifencyWarningReportCollect.put(machineName, list);
      } else {
        list.add(knifeLifencyWarningReport);
//          KnifeLifencyWarningReportCollect.put(machineName, list);
      }
    }
    //整理分组
    for (Map.Entry<String, List<KnifeLifencyWarningReport>> entry : KnifeLifencyWarningReportCollect.entrySet()) {
      MachineLifencyWarningReportVO machineLifencyWarningReportVO = new MachineLifencyWarningReportVO();
      machineLifencyWarningReportVO.setMachineName(entry.getKey());
      machineLifencyWarningReportVO.setKnifeLifencyList(entry.getValue());
      machineLifencyWarningReportVOList.add(machineLifencyWarningReportVO);
    }
    return machineLifencyWarningReportVOList;
  }

  @Override
  public List<KnifeBrokenRepore> getKnifeBrokenRepore(ProductLineDTO productLine) throws Exception {
    List<KnifeBrokenRepore> knifeBrokenRepores = null;
    try {
      knifeBrokenRepores = chartMapper.getKnifeBrokenRepore(productLine);
    } catch (Exception e) {
      logger.error(String.format("断刀频率统计(按刀径) >>> 异常信息:%S",e.toString()));
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
    return knifeBrokenRepores;
  }
}
