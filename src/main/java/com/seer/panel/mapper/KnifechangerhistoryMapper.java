package com.seer.panel.mapper;

import com.seer.panel.model.Knifechangerhistory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
 @Repository
public interface KnifechangerhistoryMapper {

    /**
     * 添加 换刀记录
     * @param knifechangerhistory
     */
    public void  addKnifechangerhistory(Knifechangerhistory knifechangerhistory);

    /**
     * 依据主键更新 换刀记录
     * @param knifechangerhistory
     */
    public void  updateKnifechangerhistoryById(Knifechangerhistory knifechangerhistory);

    /**
     * 依据条件查找 换刀记录 列表
     * @param param
     * @return
     */
    public List<Knifechangerhistory> selectKnifechangerhistoryList(Map<String, Object> param);

    /**
     * 依据主键删除 换刀记录 记录
     * @param knifechangerhistoryId
     */
    public void  delKnifechangerhistoryById(Integer knifechangerhistoryId);

}
