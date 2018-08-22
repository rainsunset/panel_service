package com.seer.panel.mapper;

import com.seer.panel.model.Productprocesstime;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
 @Repository
public interface ProductprocesstimeMapper {

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
     * 依据主键删除 产品加工时间 记录
     * @param productprocesstimeId
     */
    public void  delProductprocesstimeById(Integer productprocesstimeId);

}
