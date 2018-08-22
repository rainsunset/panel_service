package com.seer.panel.service;

import com.github.pagehelper.PageInfo;
import com.seer.panel.model.Acquisitioncardrunlog;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
public interface AcquisitioncardrunlogService {

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
     * 依据条件查找分页 采集卡运行状态 列表
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<Acquisitioncardrunlog> getAcquisitioncardrunlogPageTurn(Map<String, Object> param, int pageNo, int pageSize);

    /**
     * 依据Id查找 采集卡运行状态 详情
     * @param acquisitioncardrunlogId
     * @return
     */
    public Acquisitioncardrunlog getAcquisitioncardrunlogById(Integer acquisitioncardrunlogId);

    /**
     * 依据Id删除 采集卡运行状态 记录
     * @param acquisitioncardrunlogId
     */
    public void delAcquisitioncardrunlogById(Integer acquisitioncardrunlogId);
}
