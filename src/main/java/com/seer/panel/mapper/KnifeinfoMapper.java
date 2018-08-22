package com.seer.panel.mapper;

import com.seer.panel.model.Knifeinfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
 @Repository
public interface KnifeinfoMapper {

    /**
     * 添加 刀具信息表
     * @param knifeinfo
     */
    public void  addKnifeinfo(Knifeinfo knifeinfo);

    /**
     * 依据主键更新 刀具信息表
     * @param knifeinfo
     */
    public void  updateKnifeinfoById(Knifeinfo knifeinfo);

    /**
     * 依据条件查找 刀具信息表 列表
     * @param param
     * @return
     */
    public List<Knifeinfo> selectKnifeinfoList(Map<String, Object> param);

    /**
     * 依据主键删除 刀具信息表 记录
     * @param knifeinfoId
     */
    public void  delKnifeinfoById(Integer knifeinfoId);

}
