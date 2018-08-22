package com.seer.panel.mapper;

import com.seer.panel.model.Acquisitioncardrunlog;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
 @Repository
public interface AcquisitioncardrunlogMapper {

    /**
     * 添加 采集卡运行状态
     * @param acquisitioncardrunlog
     */
    public void  addAcquisitioncardrunlog(Acquisitioncardrunlog acquisitioncardrunlog);

    /**
     * 依据主键更新 采集卡运行状态
     * @param acquisitioncardrunlog
     */
    public void  updateAcquisitioncardrunlogById(Acquisitioncardrunlog acquisitioncardrunlog);

    /**
     * 依据条件查找 采集卡运行状态 列表
     * @param param
     * @return
     */
    public List<Acquisitioncardrunlog> selectAcquisitioncardrunlogList(Map<String, Object> param);

    /**
     * 依据主键删除 采集卡运行状态 记录
     * @param acquisitioncardrunlogId
     */
    public void  delAcquisitioncardrunlogById(Integer acquisitioncardrunlogId);

}
