package com.seer.panel.mapper;

import com.seer.panel.model.Cuttersrawdata;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
 @Repository
public interface CuttersrawdataMapper {

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
     * 依据主键删除 断刀原始数据 记录
     * @param cuttersrawdataId
     */
    public void  delCuttersrawdataById(Integer cuttersrawdataId);

}
