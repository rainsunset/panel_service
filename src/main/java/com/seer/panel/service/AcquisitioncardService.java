package com.seer.panel.service;

import com.github.pagehelper.PageInfo;
import com.seer.panel.model.Acquisitioncard;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
public interface AcquisitioncardService {

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
     * 依据条件查找分页 采集卡信息 列表
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<Acquisitioncard> getAcquisitioncardPageTurn(Map<String, Object> param, int pageNo, int pageSize);

    /**
     * 依据Id查找 采集卡信息 详情
     * @param acquisitionCardCode
     * @return
     */
    public Acquisitioncard getAcquisitioncardById(String acquisitionCardCode);

    /**
     * 依据Id删除 采集卡信息 记录
     * @param acquisitionCardCode
     */
    public void delAcquisitioncardById(String acquisitionCardCode);
}
