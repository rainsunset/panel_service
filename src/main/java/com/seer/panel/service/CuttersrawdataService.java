package com.seer.panel.service;

import com.github.pagehelper.PageInfo;
import com.seer.panel.model.Cuttersrawdata;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
public interface CuttersrawdataService {

    /**
     * 添加 断刀原始数据
     * @param cuttersrawdata
     */
    public void  addCuttersrawdata(Cuttersrawdata cuttersrawdata);

    /**
     * 依据主键更新 断刀原始数据
     * @param cuttersrawdata
     */
    public void  updateCuttersrawdataById(Cuttersrawdata cuttersrawdata);

    /**
     * 依据条件查找 断刀原始数据 列表
     * @param param
     * @return
     */
    public List<Cuttersrawdata> selectCuttersrawdataList(Map<String, Object> param);

    /**
     * 依据条件查找分页 断刀原始数据 列表
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<Cuttersrawdata> getCuttersrawdataPageTurn(Map<String, Object> param, int pageNo, int pageSize);

    /**
     * 依据Id查找 断刀原始数据 详情
     * @param cuttersrawdataId
     * @return
     */
    public Cuttersrawdata getCuttersrawdataById(Integer cuttersrawdataId);

    /**
     * 依据Id删除 断刀原始数据 记录
     * @param cuttersrawdataId
     */
    public void delCuttersrawdataById(Integer cuttersrawdataId);
}
