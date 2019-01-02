package com.seer.panel.controller;

import com.seer.panel.common.BaseController;
import com.seer.panel.exception.GlobalErrorInfoEnum;
import com.seer.panel.exception.GlobalErrorInfoException;
import com.seer.panel.model.FactoryProductLine;
import com.seer.panel.model.ProdLineProdReport;
import com.seer.panel.model.ProductLineAlarmReport;
import com.seer.panel.model.ProductLineMachineStatusReport;
import com.seer.panel.service.ChartService;
import com.seer.panel.view.EchartBarOrLineVO;
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
 * 生产线看板图表API
 * @author : ligangwei / ligangwei@seerbigdata.com
 * @version : 1.0
 */
@Api(tags = "生产线看板图表")
@RestController
@RequestMapping("/chart")
public class ChartController extends BaseController {

  /**
   * Chart service
   */
  @Autowired
  private ChartService chartService;

  /**
   * Get factory product line response result.
   *
   * @return the response result
   * @throws GlobalErrorInfoException the global error info exception
   * @author : ligangwei / 2018-12-29
   */
  @ApiOperation("工厂产线信息")
  @RequestMapping(value = "/factoryProductLine", method = RequestMethod.POST)
  public ResponseResult<List<FactoryProductLine>> getFactoryProductLine() throws GlobalErrorInfoException {
    try {
      List<FactoryProductLine> factoryProductLineList = chartService.getFactoryProductLine();
      return RestResultGenerator.genResult(factoryProductLineList);
    } catch (GlobalErrorInfoException e) {
      throw e;
    } catch (Exception e) {
      logger.error(String.format("Controller >>> 工厂产线信息 接口异常 >>> msg:%S",e.toString()));
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
  }

  /**
   * Get machine product report response result.
   *
   * @param productLine the product line
   * @return the response result
   * @throws GlobalErrorInfoException the global error info exception
   * @author : ligangwei / 2018-12-29
   */
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

  /**
   * Get product line machine status report response result.
   *
   * @param productLine the product line
   * @return the response result
   * @throws GlobalErrorInfoException the global error info exception
   * @author : ligangwei / 2018-12-29
   */
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

  /**
   * Get product line knife lifeency count response result.
   *
   * @param productLine the product line
   * @return the response result
   * @throws GlobalErrorInfoException the global error info exception
   * @author : ligangwei / 2018-12-29
   */
  @ApiOperation("刀具寿命统计")
  @RequestMapping(value = "/productLineKnifeLifeencyCount", method = RequestMethod.POST)
  public ResponseResult<EchartPieVO> getProductLineKnifeLifeencyCount(
          @RequestBody ProductLineDTO productLine) throws GlobalErrorInfoException {
    try {
      EchartPieVO echartPieVO = chartService.getProductLineKnifeLifeencyCount(productLine);
      return RestResultGenerator.genResult(echartPieVO);
    } catch (GlobalErrorInfoException e) {
      throw e;
    } catch (Exception e) {
      logger.error(String.format("Controller >>> 刀具寿命统计 接口异常 >>> msg:%S",e.toString()));
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
  }

  /**
   * Get product line alarm report response result.
   *
   * @param productLine the product line
   * @return the response result
   * @throws GlobalErrorInfoException the global error info exception
   * @author : ligangwei / 2018-12-29
   */
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

  /**
   * Get machine lifency warning report response result.
   *
   * @param productLine the product line
   * @return the response result
   * @throws GlobalErrorInfoException the global error info exception
   * @author : ligangwei / 2018-12-29
   */
  @ApiOperation(" 刀具寿命报警")
  @RequestMapping(value = "/machineLifencyWarningReport", method = RequestMethod.POST)
  public ResponseResult<EchartBarOrLineVO> getMachineLifencyWarningReport(
      @RequestBody ProductLineDTO productLine) throws GlobalErrorInfoException {
    try {
      EchartBarOrLineVO echartBarOrLineVO = chartService
          .getMachineLifencyWarningReport(productLine);
      return RestResultGenerator.genResult(echartBarOrLineVO);
    } catch (GlobalErrorInfoException e) {
      throw e;
    } catch (Exception e) {
      logger.error(String.format("Controller >>> 刀具寿命报警 接口异常 >>> msg:%S",e.toString()));
      throw new GlobalErrorInfoException(GlobalErrorInfoEnum.SYSTEM_ERROR);
    }
  }

  /**
   * Get knife broken report by diameter response result.
   *
   * @param productLine the product line
   * @return the response result
   * @throws GlobalErrorInfoException the global error info exception
   * @author : ligangwei / 2018-12-29
   */
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

  /**
   * Get knife broken report by position response result.
   *
   * @param productLine the product line
   * @return the response result
   * @throws GlobalErrorInfoException the global error info exception
   * @author : ligangwei / 2018-12-29
   */
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

  /**
   * Get prod line prod report response result.
   *
   * @param productLine the product line
   * @return the response result
   * @throws GlobalErrorInfoException the global error info exception
   * @author : ligangwei / 2018-12-29
   */
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

  /**
   * Get production director response result.
   *
   * @param productLine the product line
   * @return the response result
   * @throws GlobalErrorInfoException the global error info exception
   * @author : ligangwei / 2018-12-29
   */
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
