package com.seer.panel.mapper;

import com.seer.panel.model.Knifelife;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
 @Repository
public interface KnifelifeMapper {

    /**
     * 添加 刀具寿命
     * @param knifelife
     */
    public void  addKnifelife(Knifelife knifelife);

    /**
     * 依据主键更新 刀具寿命
     * @param knifelife
     */
    public void  updateKnifelifeById(Knifelife knifelife);

    /**
     * 依据条件查找 刀具寿命 列表
     * @param param
     * @return
     */
    public List<Knifelife> selectKnifelifeList(Map<String, Object> param);

    /**
     * 依据主键删除 刀具寿命 记录
     * @param knifelifeId
     */
    public void  delKnifelifeById(Integer knifelifeId);

}
