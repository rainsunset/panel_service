package com.seer.panel.controller;

import com.seer.panel.common.BaseController;
import com.seer.panel.exception.GlobalErrorInfoEnum;
import com.seer.panel.exception.GlobalErrorInfoException;
import com.seer.panel.model.KnifeBrokenReportByDiameter;
import com.seer.panel.model.KnifeBrokenReportByPosition;
import com.seer.panel.model.MachineProductReport;
import com.seer.panel.model.ProdLineProdReport;
import com.seer.panel.model.ProductLineAlarmReport;
import com.seer.panel.model.ProductLineMachineStatusReport;
import com.seer.panel.service.ChartService;
import com.seer.panel.view.EchartBarOrLineVO;
import com.seer.panel.view.EchartHeatmapVO;
import com.seer.panel.view.EchartPieVO;
import com.seer.panel.view.EchartRadarVO;
import com.seer.panel.view.ProductLineDTO;
import com.seer.panel.view.ProductionDirectorVO;
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
  public ResponseResult<EchartBarOrLineVO> getMachineProductReport(
      @RequestBody ProductLineDTO productLine) throws GlobalErrorInfoException {
    try {
      EchartBarOrLineVO machineProductReportList = chartService
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
  public ResponseResult<EchartHeatmapVO> getMachineLifencyWarningReport(
      @RequestBody ProductLineDTO productLine) throws GlobalErrorInfoException {
    try {
      EchartHeatmapVO machineLifencyWarningReportVOList = chartService
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
  @RequestMapping(value = "/knifeBrokenReportByDiameter", method = RequestMethod.POST)
  public ResponseResult<EchartBarOrLineVO> getKnifeBrokenReportByDiameter(
      @RequestBody ProductLineDTO productLine) throws GlobalErrorInfoException {
    try {
      EchartBarOrLineVO knifeBrokenReportByDiameterList = chartService
          .getKnifeBrokenReportByDiameter(productLine);
      return RestResultGenerator.genResult(knifeBrokenReportByDiameterList);
    } catch (GlobalErrorInfoException e) {
      throw e;
    } catch (Exception e) {
      logger.error(String.format("Controller >>> 断刀频率统计 接口异常 >>> msg:%S",e.toString()));
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
  }

  @ApiOperation("一周内断刀频率统计(按刀位)")
  @RequestMapping(value = "/knifeBrokenReportByPosition", method = RequestMethod.POST)
  public ResponseResult<EchartRadarVO> getKnifeBrokenReportByPosition(
          @RequestBody ProductLineDTO productLine) throws GlobalErrorInfoException {
    try {
      EchartRadarVO knifeBrokenReportByPositionList = chartService
              .getKnifeBrokenReportByPosition(productLine);
      return RestResultGenerator.genResult(knifeBrokenReportByPositionList);
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

  @ApiOperation("生产负责人")
  @RequestMapping(value = "/productionDirector", method = RequestMethod.POST)
  public ResponseResult<ProductionDirectorVO> getProductionDirector(
          @RequestBody ProductLineDTO productLine) throws GlobalErrorInfoException {
    try {
      ProductionDirectorVO productionDirector = chartService.getProductionDirector(productLine);
      return RestResultGenerator.genResult(productionDirector);
    } catch (GlobalErrorInfoException e) {
      throw e;
    } catch (Exception e) {
      logger.error(String.format("Controller >>> 断刀频率统计 接口异常 >>> msg:%S",e.toString()));
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
  }

}
