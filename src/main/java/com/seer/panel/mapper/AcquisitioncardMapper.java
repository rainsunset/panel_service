package com.seer.panel.mapper;

import com.seer.panel.model.Acquisitioncard;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
 @Repository
public interface AcquisitioncardMapper {

    /**
     * 添加 采集卡信息
     * @param acquisitioncard
     */
    public void  addAcquisitioncard(Acquisitioncard acquisitioncard);

    /**
     * 依据主键更新 采集卡信息
     * @param acquisitioncard
     */
    public void  updateAcquisitioncardById(Acquisitioncard acquisitioncard);

    /**
     * 依据条件查找 采集卡信息 列表
     * @param param
     * @return
     */
    public List<Acquisitioncard> selectAcquisitioncardList(Map<String, Object> param);

    /**
     * 依据主键删除 采集卡信息 记录
     * @param acquisitionCardCode
     */
    public void  delAcquisitioncardById(String acquisitionCardCode);

}
