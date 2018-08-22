package com.seer.panel.mapper;

import com.seer.panel.model.Knifeorder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
 @Repository
public interface KnifeorderMapper {

    /**
     * 添加 机床刀具使用顺序表
     * @param knifeorder
     */
    public void  addKnifeorder(Knifeorder knifeorder);

    /**
     * 依据主键更新 机床刀具使用顺序表
     * @param knifeorder
     */
    public void  updateKnifeorderById(Knifeorder knifeorder);

    /**
     * 依据条件查找 机床刀具使用顺序表 列表
     * @param param
     * @return
     */
    public List<Knifeorder> selectKnifeorderList(Map<String, Object> param);

    /**
     * 依据主键删除 机床刀具使用顺序表 记录
     * @param knifeorderId
     */
    public void  delKnifeorderById(Integer knifeorderId);

}
