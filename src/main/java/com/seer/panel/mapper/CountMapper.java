package com.seer.panel.mapper;

import com.seer.panel.model.Count;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
 @Repository
public interface CountMapper {

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
     * 依据主键删除  记录
     * @param countId
     */
    public void  delCountById(Integer countId);

}
