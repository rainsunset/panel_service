package com.seer.panel.mapper;

import com.seer.panel.model.Productprocesstimehistory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
 @Repository
public interface ProductprocesstimehistoryMapper {

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
     * 依据主键删除 产品加工时间历史 记录
     * @param productprocesstimehistoryId
     */
    public void  delProductprocesstimehistoryById(Integer productprocesstimehistoryId);

}
