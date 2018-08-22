package com.seer.panel.service;

import com.github.pagehelper.PageInfo;
import com.seer.panel.model.Productprocesstime;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
public interface ProductprocesstimeService {

    /**
     * 添加 产品加工时间
     * @param productprocesstime
     */
    public void  addProductprocesstime(Productprocesstime productprocesstime);

    /**
     * 依据主键更新 产品加工时间
     * @param productprocesstime
     */
    public void  updateProductprocesstimeById(Productprocesstime productprocesstime);

    /**
     * 依据条件查找 产品加工时间 列表
     * @param param
     * @return
     */
    public List<Productprocesstime> selectProductprocesstimeList(Map<String, Object> param);

    /**
     * 依据条件查找分页 产品加工时间 列表
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<Productprocesstime> getProductprocesstimePageTurn(Map<String, Object> param, int pageNo, int pageSize);

    /**
     * 依据Id查找 产品加工时间 详情
     * @param productprocesstimeId
     * @return
     */
    public Productprocesstime getProductprocesstimeById(Integer productprocesstimeId);

    /**
     * 依据Id删除 产品加工时间 记录
     * @param productprocesstimeId
     */
    public void delProductprocesstimeById(Integer productprocesstimeId);
}
