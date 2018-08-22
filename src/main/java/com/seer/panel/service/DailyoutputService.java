package com.seer.panel.service;

import com.github.pagehelper.PageInfo;
import com.seer.panel.model.Dailyoutput;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
public interface DailyoutputService {

    /**
     * 添加 日产量表
     * @param dailyoutput
     */
    public void  addDailyoutput(Dailyoutput dailyoutput);

    /**
     * 依据主键更新 日产量表
     * @param dailyoutput
     */
    public void  updateDailyoutputById(Dailyoutput dailyoutput);

    /**
     * 依据条件查找 日产量表 列表
     * @param param
     * @return
     */
    public List<Dailyoutput> selectDailyoutputList(Map<String, Object> param);

    /**
     * 依据条件查找分页 日产量表 列表
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<Dailyoutput> getDailyoutputPageTurn(Map<String, Object> param, int pageNo, int pageSize);

    /**
     * 依据Id查找 日产量表 详情
     * @param dailyoutputId
     * @return
     */
    public Dailyoutput getDailyoutputById(Integer dailyoutputId);

    /**
     * 依据Id删除 日产量表 记录
     * @param dailyoutputId
     */
    public void delDailyoutputById(Integer dailyoutputId);
}
