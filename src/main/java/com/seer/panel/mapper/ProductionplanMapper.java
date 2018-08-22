package com.seer.panel.mapper;

import com.seer.panel.model.Productionplan;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
 @Repository
public interface ProductionplanMapper {

    /**
     * 添加 生产计划
     * @param productionplan
     */
    public void  addProductionplan(Productionplan productionplan);

    /**
     * 依据主键更新 生产计划
     * @param productionplan
     */
    public void  updateProductionplanById(Productionplan productionplan);

    /**
     * 依据条件查找 生产计划 列表
     * @param param
     * @return
     */
    public List<Productionplan> selectProductionplanList(Map<String, Object> param);

    /**
     * 依据主键删除 生产计划 记录
     * @param productionplanId
     */
    public void  delProductionplanById(Integer productionplanId);

}
