package com.seer.panel.mapper.db1;

import com.seer.panel.model.FactoryProductLine;
import com.seer.panel.model.KnifeBrokenReportByDiameter;
import com.seer.panel.model.KnifeBrokenReportByPosition;
import com.seer.panel.model.KnifeLifencyWarningReport;
import com.seer.panel.model.MachineProductReport;
import com.seer.panel.model.ProductLineKnifeLifeencyCount;
import com.seer.panel.view.ProductLineDTO;
import com.seer.panel.model.ProductLineAlarmReport;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author : ligangwei / ligangwei@seerbigdata.com
 * @version : 1.0
 * @autheor ligw
 * @date 2018 /8/23 20:20
 */
@Repository
public interface ChartMapper {

	/**
	 * 工厂产线信息
	 *
	 * @return list
	 * @author : ligangwei / 2018-12-29
	 */
	List<FactoryProductLine> getFactoryProductLine();

	/**
	 * 机床稼动率排行 生产数
	 *
	 * @param productLine the product line
	 * @return list
	 * @throws Exception the exception
	 * @author : ligangwei / 2018-12-29
	 */
	public List<MachineProductReport> getMachineProductReport(ProductLineDTO productLine) throws Exception;

	/**
	 * 机器实时状态
	 *
	 * @param productLine the product line
	 * @return list
	 * @throws Exception the exception
	 * @author : ligangwei / 2018-12-29
	 */
	public List<List<?>> getProductLineMachineStatusReport(ProductLineDTO productLine) throws Exception;

	/**
	 * 刀具寿命统计
	 *
	 * @param productLine the product line
	 * @return product line knife lifeency count
	 * @throws Exception the exception
	 * @author : ligangwei / 2018-12-29
	 */
	public ProductLineKnifeLifeencyCount getProductLineKnifeLifeencyCount(ProductLineDTO productLine) throws Exception;

	/**
	 * 生产线报警
	 *
	 * @param productLine the product line
	 * @return list
	 * @throws Exception the exception
	 * @author : ligangwei / 2018-12-29
	 */
	public List<ProductLineAlarmReport> getProductLineAlarmReport(ProductLineDTO productLine) throws Exception;

	/**
	 * 刀具寿命报警
	 *
	 * @param productLine the product line
	 * @return list
	 * @throws Exception the exception
	 * @author : ligangwei / 2018-12-29
	 */
	public List<KnifeLifencyWarningReport> getKnifeLifencyWarningReport(ProductLineDTO productLine) throws Exception;

	/**
	 * 断刀频率统计(按刀径)
	 *
	 * @param productLine the product line
	 * @return list
	 * @throws Exception the exception
	 * @author : ligangwei / 2018-12-29
	 */
	public List<KnifeBrokenReportByDiameter> getKnifeBrokenReportByDiameter (ProductLineDTO productLine) throws Exception;

	/**
	 * 断刀频率统计(按刀位)
	 *
	 * @param productLine the product line
	 * @return list
	 * @throws Exception the exception
	 * @author : ligangwei / 2018-12-29
	 */
	public List<KnifeBrokenReportByPosition> getKnifeBrokenReportByPosition(ProductLineDTO productLine) throws Exception;

	/**
	 * 生产线生产统计
	 *
	 * @param productLineDTO the product line dto
	 * @return integer
	 * @throws Exception the exception
	 * @author : ligangwei / 2018-12-29
	 */
	public Integer getProdLineProdReport(ProductLineDTO productLineDTO)throws Exception;

}
