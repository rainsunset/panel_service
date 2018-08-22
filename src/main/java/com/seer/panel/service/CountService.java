package com.seer.panel.service;

import com.github.pagehelper.PageInfo;
import com.seer.panel.model.Count;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
public interface CountService {

    /**
     * 添加 
     * @param count
     */
    public void  addCount(Count count);

    /**
     * 依据主键更新 
     * @param count
     */
    public void  updateCountById(Count count);

    /**
     * 依据条件查找  列表
     * @param param
     * @return
     */
    public List<Count> selectCountList(Map<String, Object> param);

    /**
     * 依据条件查找分页  列表
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<Count> getCountPageTurn(Map<String, Object> param, int pageNo, int pageSize);

    /**
     * 依据Id查找  详情
     * @param countId
     * @return
     */
    public Count getCountById(Integer countId);

    /**
     * 依据Id删除  记录
     * @param countId
     */
    public void delCountById(Integer countId);
}
