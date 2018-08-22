package com.seer.panel.mapper;

import com.seer.panel.model.Woundwaresample;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
 @Repository
public interface WoundwaresampleMapper {

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
     * 依据主键删除 虚拟发声波形样本数据 记录
     * @param woundwaresampleId
     */
    public void  delWoundwaresampleById(Integer woundwaresampleId);

}
