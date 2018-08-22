package com.seer.panel.service;

import com.github.pagehelper.PageInfo;
import com.seer.panel.model.Monthlyproductiontarget;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
public interface MonthlyproductiontargetService {

    /**
     * 添加 月度生产目标表
     * @param monthlyproductiontarget
     */
    public void  addMonthlyproductiontarget(Monthlyproductiontarget monthlyproductiontarget);

    /**
     * 依据主键更新 月度生产目标表
     * @param monthlyproductiontarget
     */
    public void  updateMonthlyproductiontargetById(Monthlyproductiontarget monthlyproductiontarget);

    /**
     * 依据条件查找 月度生产目标表 列表
     * @param param
     * @return
     */
    public List<Monthlyproductiontarget> selectMonthlyproductiontargetList(Map<String, Object> param);

    /**
     * 依据条件查找分页 月度生产目标表 列表
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<Monthlyproductiontarget> getMonthlyproductiontargetPageTurn(Map<String, Object> param, int pageNo, int pageSize);

    /**
     * 依据Id查找 月度生产目标表 详情
     * @param monthlyproductiontargetId
     * @return
     */
    public Monthlyproductiontarget getMonthlyproductiontargetById(Integer monthlyproductiontargetId);

    /**
     * 依据Id删除 月度生产目标表 记录
     * @param monthlyproductiontargetId
     */
    public void delMonthlyproductiontargetById(Integer monthlyproductiontargetId);
}
