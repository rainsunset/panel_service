package com.seer.panel.service;

import com.github.pagehelper.PageInfo;
import com.seer.panel.model.Knifelife;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
public interface KnifelifeService {

    /**
     * 添加 刀具寿命
     * @param knifelife
     */
    public void  addKnifelife(Knifelife knifelife);

    /**
     * 依据主键更新 刀具寿命
     * @param knifelife
     */
    public void  updateKnifelifeById(Knifelife knifelife);

    /**
     * 依据条件查找 刀具寿命 列表
     * @param param
     * @return
     */
    public List<Knifelife> selectKnifelifeList(Map<String, Object> param);

    /**
     * 依据条件查找分页 刀具寿命 列表
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<Knifelife> getKnifelifePageTurn(Map<String, Object> param, int pageNo, int pageSize);

    /**
     * 依据Id查找 刀具寿命 详情
     * @param knifelifeId
     * @return
     */
    public Knifelife getKnifelifeById(Integer knifelifeId);

    /**
     * 依据Id删除 刀具寿命 记录
     * @param knifelifeId
     */
    public void delKnifelifeById(Integer knifelifeId);
}
