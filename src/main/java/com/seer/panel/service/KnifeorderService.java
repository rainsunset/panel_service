package com.seer.panel.service;

import com.github.pagehelper.PageInfo;
import com.seer.panel.model.Knifeorder;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
public interface KnifeorderService {

    /**
     * 添加 机床刀具使用顺序表
     * @param knifeorder
     */
    public void  addKnifeorder(Knifeorder knifeorder);

    /**
     * 依据主键更新 机床刀具使用顺序表
     * @param knifeorder
     */
    public void  updateKnifeorderById(Knifeorder knifeorder);

    /**
     * 依据条件查找 机床刀具使用顺序表 列表
     * @param param
     * @return
     */
    public List<Knifeorder> selectKnifeorderList(Map<String, Object> param);

    /**
     * 依据条件查找分页 机床刀具使用顺序表 列表
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<Knifeorder> getKnifeorderPageTurn(Map<String, Object> param, int pageNo, int pageSize);

    /**
     * 依据Id查找 机床刀具使用顺序表 详情
     * @param knifeorderId
     * @return
     */
    public Knifeorder getKnifeorderById(Integer knifeorderId);

    /**
     * 依据Id删除 机床刀具使用顺序表 记录
     * @param knifeorderId
     */
    public void delKnifeorderById(Integer knifeorderId);
}
