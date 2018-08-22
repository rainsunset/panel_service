package com.seer.panel.service;

import com.github.pagehelper.PageInfo;
import com.seer.panel.model.Knifechangerhistory;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
public interface KnifechangerhistoryService {

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
     * 依据条件查找分页 换刀记录 列表
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<Knifechangerhistory> getKnifechangerhistoryPageTurn(Map<String, Object> param, int pageNo, int pageSize);

    /**
     * 依据Id查找 换刀记录 详情
     * @param knifechangerhistoryId
     * @return
     */
    public Knifechangerhistory getKnifechangerhistoryById(Integer knifechangerhistoryId);

    /**
     * 依据Id删除 换刀记录 记录
     * @param knifechangerhistoryId
     */
    public void delKnifechangerhistoryById(Integer knifechangerhistoryId);
}
