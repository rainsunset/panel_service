package com.seer.panel.mapper;

import com.seer.panel.model.Dailyoutput;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
 @Repository
public interface DailyoutputMapper {

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
     * 依据主键删除 日产量表 记录
     * @param dailyoutputId
     */
    public void  delDailyoutputById(Integer dailyoutputId);

}
