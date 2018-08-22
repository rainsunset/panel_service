package com.seer.panel.service;

import com.github.pagehelper.PageInfo;
import com.seer.panel.model.Productprocesstimehistory;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
public interface ProductprocesstimehistoryService {

    /**
     * 添加 产品加工时间历史
     * @param productprocesstimehistory
     */
    public void  addProductprocesstimehistory(Productprocesstimehistory productprocesstimehistory);

    /**
     * 依据主键更新 产品加工时间历史
     * @param productprocesstimehistory
     */
    public void  updateProductprocesstimehistoryById(Productprocesstimehistory productprocesstimehistory);

    /**
     * 依据条件查找 产品加工时间历史 列表
     * @param param
     * @return
     */
    public List<Productprocesstimehistory> selectProductprocesstimehistoryList(Map<String, Object> param);

    /**
     * 依据条件查找分页 产品加工时间历史 列表
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<Productprocesstimehistory> getProductprocesstimehistoryPageTurn(Map<String, Object> param, int pageNo, int pageSize);

    /**
     * 依据Id查找 产品加工时间历史 详情
     * @param productprocesstimehistoryId
     * @return
     */
    public Productprocesstimehistory getProductprocesstimehistoryById(Integer productprocesstimehistoryId);

    /**
     * 依据Id删除 产品加工时间历史 记录
     * @param productprocesstimehistoryId
     */
    public void delProductprocesstimehistoryById(Integer productprocesstimehistoryId);
}
