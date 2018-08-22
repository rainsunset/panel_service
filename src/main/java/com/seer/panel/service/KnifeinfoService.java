package com.seer.panel.service;

import com.github.pagehelper.PageInfo;
import com.seer.panel.model.Knifeinfo;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
public interface KnifeinfoService {

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
     * 依据条件查找分页 刀具信息表 列表
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<Knifeinfo> getKnifeinfoPageTurn(Map<String, Object> param, int pageNo, int pageSize);

    /**
     * 依据Id查找 刀具信息表 详情
     * @param knifeinfoId
     * @return
     */
    public Knifeinfo getKnifeinfoById(Integer knifeinfoId);

    /**
     * 依据Id删除 刀具信息表 记录
     * @param knifeinfoId
     */
    public void delKnifeinfoById(Integer knifeinfoId);
}
