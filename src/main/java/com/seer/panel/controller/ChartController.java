package com.seer.panel.controller;

import com.seer.panel.common.BaseController;
import com.seer.panel.exception.GlobalErrorInfoEnum;
import com.seer.panel.exception.GlobalErrorInfoException;
import com.seer.panel.model.KnifeBrokenReporeByDiameter;
import com.seer.panel.model.KnifeBrokenReporeByPosition;
import com.seer.panel.model.MachineProductReport;
import com.seer.panel.model.ProdLineProdReport;
import com.seer.panel.model.ProductLineAlarmReport;
import com.seer.panel.model.ProductLineMachineStatusReport;
import com.seer.panel.service.ChartService;
import com.seer.panel.view.MachineLifencyWarningReportVO;
import com.seer.panel.view.ProductLineDTO;
import com.seer.panel.view.ResponseResult;
import com.seer.panel.view.RestResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @autheor ligw
 * @date 2018/8/23 19:32
 */
@Api(tags = "生产线看板图表")
@RestController
@RequestMapping("/chart")
public class ChartController extends BaseController {

  @Autowired
  private ChartService chartService;

  @ApiOperation("一周内机床稼动时长排行 生产数")
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
      logger.error(String.format("Controller >>> 机床稼动率排行 接口异常 >>> msg:%S",e.toString()));
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
  }

  @ApiOperation("机器实时状态")
  @RequestMapping(value = "/productLineMachineStatusReport", method = RequestMethod.POST)
  public ResponseResult<ProductLineMachineStatusReport> getProductLineMachineStatusReport(
      @RequestBody ProductLineDTO productLine) throws GlobalErrorInfoException {
    try {
      ProductLineMachineStatusReport productLineMachineStatusReport = chartService
          .getProductLineMachineStatusReport(productLine);
      return RestResultGenerator.genResult(productLineMachineStatusReport);
    } catch (GlobalErrorInfoException e) {
      throw e;
    } catch (Exception e) {
      logger.error(String.format("Controller >>> 机器实时状态 接口异常 >>> msg:%S",e.toString()));
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
  }

  @ApiOperation("生产线报警(15min内)")
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
      logger.error(String.format("Controller >>> 生产线报警 接口异常 >>> msg:%S",e.toString()));
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
      logger.error(String.format("Controller >>> 刀具寿命报警 接口异常 >>> msg:%S",e.toString()));
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
  }

  @ApiOperation("一周内断刀频率统计(按刀径)")
  @RequestMapping(value = "/knifeBrokenReporeByDiameter", method = RequestMethod.POST)
  public ResponseResult<List<KnifeBrokenReporeByDiameter>> getKnifeBrokenReporeByDiameter(
      @RequestBody ProductLineDTO productLine) throws GlobalErrorInfoException {
    try {
      List<KnifeBrokenReporeByDiameter> knifeBrokenReporeByDiameterList = chartService
          .getKnifeBrokenReporeByDiameter(productLine);
      return RestResultGenerator.genResult(knifeBrokenReporeByDiameterList);
    } catch (GlobalErrorInfoException e) {
      throw e;
    } catch (Exception e) {
      logger.error(String.format("Controller >>> 断刀频率统计 接口异常 >>> msg:%S",e.toString()));
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
  }

  @ApiOperation("一周内断刀频率统计(按刀位)")
  @RequestMapping(value = "/knifeBrokenReporeByPosition", method = RequestMethod.POST)
  public ResponseResult<List<KnifeBrokenReporeByPosition>> getKnifeBrokenReporeByPosition(
          @RequestBody ProductLineDTO productLine) throws GlobalErrorInfoException {
    try {
      List<KnifeBrokenReporeByPosition> knifeBrokenReporeByPositionList = chartService
              .getKnifeBrokenReporeByPosition(productLine);
      return RestResultGenerator.genResult(knifeBrokenReporeByPositionList);
    } catch (GlobalErrorInfoException e) {
      throw e;
    } catch (Exception e) {
      logger.error(String.format("Controller >>> 断刀频率统计 接口异常 >>> msg:%S",e.toString()));
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
  }

  @ApiOperation("当日生产线生产统计")
  @RequestMapping(value = "/prodLineProdReport", method = RequestMethod.POST)
  public ResponseResult<ProdLineProdReport> getProdLineProdReport(
      @RequestBody ProductLineDTO productLine) throws GlobalErrorInfoException {
    try {
      ProdLineProdReport prodLineProdReport = chartService.getProdLineProdReport(productLine);
      return RestResultGenerator.genResult(prodLineProdReport);
    } catch (GlobalErrorInfoException e) {
      throw e;
    } catch (Exception e) {
      logger.error(String.format("Controller >>> 断刀频率统计 接口异常 >>> msg:%S",e.toString()));
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
  }

}
