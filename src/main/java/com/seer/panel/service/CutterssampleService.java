package com.seer.panel.service;

import com.github.pagehelper.PageInfo;
import com.seer.panel.model.Cutterssample;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
public interface CutterssampleService {

    /**
     * 添加 断刀样本
     * @param cutterssample
     */
    public void  addCutterssample(Cutterssample cutterssample);

    /**
     * 依据主键更新 断刀样本
     * @param cutterssample
     */
    public void  updateCutterssampleById(Cutterssample cutterssample);

    /**
     * 依据条件查找 断刀样本 列表
     * @param param
     * @return
     */
    public List<Cutterssample> selectCutterssampleList(Map<String, Object> param);

    /**
     * 依据条件查找分页 断刀样本 列表
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<Cutterssample> getCutterssamplePageTurn(Map<String, Object> param, int pageNo, int pageSize);

    /**
     * 依据Id查找 断刀样本 详情
     * @param cutterssampleId
     * @return
     */
    public Cutterssample getCutterssampleById(Integer cutterssampleId);

    /**
     * 依据Id删除 断刀样本 记录
     * @param cutterssampleId
     */
    public void delCutterssampleById(Integer cutterssampleId);
}
