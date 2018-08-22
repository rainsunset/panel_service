package com.seer.panel.mapper;

import com.seer.panel.model.Monthlyproductiontarget;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
 @Repository
public interface MonthlyproductiontargetMapper {

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
     * 依据主键删除 月度生产目标表 记录
     * @param monthlyproductiontargetId
     */
    public void  delMonthlyproductiontargetById(Integer monthlyproductiontargetId);

}
