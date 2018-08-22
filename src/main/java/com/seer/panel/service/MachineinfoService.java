package com.seer.panel.service;

import com.github.pagehelper.PageInfo;
import com.seer.panel.model.Machineinfo;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
public interface MachineinfoService {

    /**
     * 添加 机床信息表
     * @param machineinfo
     */
    public void  addMachineinfo(Machineinfo machineinfo);

    /**
     * 依据主键更新 机床信息表
     * @param machineinfo
     */
    public void  updateMachineinfoById(Machineinfo machineinfo);

    /**
     * 依据条件查找 机床信息表 列表
     * @param param
     * @return
     */
    public List<Machineinfo> selectMachineinfoList(Map<String, Object> param);

    /**
     * 依据条件查找分页 机床信息表 列表
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<Machineinfo> getMachineinfoPageTurn(Map<String, Object> param, int pageNo, int pageSize);

    /**
     * 依据Id查找 机床信息表 详情
     * @param machineinfoId
     * @return
     */
    public Machineinfo getMachineinfoById(Integer machineinfoId);

    /**
     * 依据Id删除 机床信息表 记录
     * @param machineinfoId
     */
    public void delMachineinfoById(Integer machineinfoId);
}
