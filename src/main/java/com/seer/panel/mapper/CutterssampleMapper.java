package com.seer.panel.mapper;

import com.seer.panel.model.Cutterssample;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
 @Repository
public interface CutterssampleMapper {

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
     * 依据主键删除 断刀样本 记录
     * @param cutterssampleId
     */
    public void  delCutterssampleById(Integer cutterssampleId);

}
