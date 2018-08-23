package com.seer.panel.controller;

import com.seer.panel.exception.GlobalErrorInfoEnum;
import com.seer.panel.exception.GlobalErrorInfoException;
import com.seer.panel.model.KnifeBrokenRepore;
import com.seer.panel.model.MachineProductReport;
import com.seer.panel.model.ProductLineAlarmReport;
import com.seer.panel.model.ProductLineMachineStatusReport;
import com.seer.panel.service.ChartService;
import com.seer.panel.view.MachineLifencyWarningReportVO;
import com.seer.panel.view.ProductLineDTO;
import com.seer.panel.view.ResponseResult;
import com.seer.panel.view.RestResultGenerator;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @autheor ligw
 * @date 2018/8/23 19:32
 */
public class ChartController {

  @Autowired
  private ChartService chartService;

  @ApiOperation("机床稼动率排行 生产数")
  @RequestMapping(value = "/machineProductReport", method = RequestMethod.POST)
  public ResponseResult<List<MachineProductReport>> getMachineProductReport(
      @RequestBody ProductLineDTO productLine) throws GlobalErrorInfoException {
    try {
      List<MachineProductReport> machineProductReportList = chartService
          .getMachineProductReport(productLine);
      return RestResultGenerator.genResult(machineProductReportList);
    } catch (GlobalErrorInfoException e) {
      throw e;
    } catch (Exception e) {
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
  }

  @ApiOperation("机器实时状态")
  @RequestMapping(value = "/productLineMachineStatusReport", method = RequestMethod.POST)
  public ResponseResult<List<ProductLineMachineStatusReport>> getProductLineMachineStatusReport(
      @RequestBody ProductLineDTO productLine) throws GlobalErrorInfoException {
    try {
      List<ProductLineMachineStatusReport> productLineMachineStatusReportList = chartService
          .getProductLineMachineStatusReport(productLine);
      return RestResultGenerator.genResult(productLineMachineStatusReportList);
    } catch (GlobalErrorInfoException e) {
      throw e;
    } catch (Exception e) {
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
  }

  @ApiOperation(" 生产线报警")
  @RequestMapping(value = "/productLineAlarmReport", method = RequestMethod.POST)
  public ResponseResult<List<ProductLineAlarmReport>> getProductLineAlarmReport(
      @RequestBody ProductLineDTO productLine) throws GlobalErrorInfoException {
    try {
      List<ProductLineAlarmReport> productLineAlarmReportList = chartService
          .getProductLineAlarmReport(productLine);
      return RestResultGenerator.genResult(productLineAlarmReportList);
    } catch (GlobalErrorInfoException e) {
      throw e;
    } catch (Exception e) {
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
  }

  @ApiOperation(" 刀具寿命报警")
  @RequestMapping(value = "/machineLifencyWarningReport", method = RequestMethod.POST)
  public ResponseResult<List<MachineLifencyWarningReportVO>> getMachineLifencyWarningReport(
      @RequestBody ProductLineDTO productLine) throws GlobalErrorInfoException {
    try {
      List<MachineLifencyWarningReportVO> machineLifencyWarningReportVOList = chartService
          .getMachineLifencyWarningReport(productLine);
      return RestResultGenerator.genResult(machineLifencyWarningReportVOList);
    } catch (GlobalErrorInfoException e) {
      throw e;
    } catch (Exception e) {
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
  }

  @ApiOperation(" 断刀频率统计(按刀径)")
  @RequestMapping(value = "/KnifeBrokenRepore", method = RequestMethod.POST)
  public ResponseResult<List<KnifeBrokenRepore>> getKnifeBrokenRepore(
      @RequestBody ProductLineDTO productLine) throws GlobalErrorInfoException {
    try {
      List<KnifeBrokenRepore> knifeBrokenReporeList = chartService
          .getKnifeBrokenRepore(productLine);
      return RestResultGenerator.genResult(knifeBrokenReporeList);
    } catch (GlobalErrorInfoException e) {
      throw e;
    } catch (Exception e) {
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
  }

}
