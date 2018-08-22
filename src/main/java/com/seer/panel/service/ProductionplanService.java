package com.seer.panel.service;

import com.github.pagehelper.PageInfo;
import com.seer.panel.model.Productionplan;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
public interface ProductionplanService {

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
     * 依据条件查找分页 生产计划 列表
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<Productionplan> getProductionplanPageTurn(Map<String, Object> param, int pageNo, int pageSize);

    /**
     * 依据Id查找 生产计划 详情
     * @param productionplanId
     * @return
     */
    public Productionplan getProductionplanById(Integer productionplanId);

    /**
     * 依据Id删除 生产计划 记录
     * @param productionplanId
     */
    public void delProductionplanById(Integer productionplanId);
}
