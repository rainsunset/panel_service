package com.seer.panel.service;

import com.github.pagehelper.PageInfo;
import com.seer.panel.model.Woundwaresample;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
public interface WoundwaresampleService {

    /**
     * 添加 虚拟发声波形样本数据
     * @param woundwaresample
     */
    public void  addWoundwaresample(Woundwaresample woundwaresample);

    /**
     * 依据主键更新 虚拟发声波形样本数据
     * @param woundwaresample
     */
    public void  updateWoundwaresampleById(Woundwaresample woundwaresample);

    /**
     * 依据条件查找 虚拟发声波形样本数据 列表
     * @param param
     * @return
     */
    public List<Woundwaresample> selectWoundwaresampleList(Map<String, Object> param);

    /**
     * 依据条件查找分页 虚拟发声波形样本数据 列表
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<Woundwaresample> getWoundwaresamplePageTurn(Map<String, Object> param, int pageNo, int pageSize);

    /**
     * 依据Id查找 虚拟发声波形样本数据 详情
     * @param woundwaresampleId
     * @return
     */
    public Woundwaresample getWoundwaresampleById(Integer woundwaresampleId);

    /**
     * 依据Id删除 虚拟发声波形样本数据 记录
     * @param woundwaresampleId
     */
    public void delWoundwaresampleById(Integer woundwaresampleId);
}
