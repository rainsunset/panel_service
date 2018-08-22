package com.seer.panel.service;

import com.github.pagehelper.PageInfo;
import com.seer.panel.model.Machinestatus;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
public interface MachinestatusService {

    /**
     * 添加 机床当前状态
     * @param machinestatus
     */
    public void  addMachinestatus(Machinestatus machinestatus);

    /**
     * 依据主键更新 机床当前状态
     * @param machinestatus
     */
    public void  updateMachinestatusById(Machinestatus machinestatus);

    /**
     * 依据条件查找 机床当前状态 列表
     * @param param
     * @return
     */
    public List<Machinestatus> selectMachinestatusList(Map<String, Object> param);

    /**
     * 依据条件查找分页 机床当前状态 列表
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<Machinestatus> getMachinestatusPageTurn(Map<String, Object> param, int pageNo, int pageSize);

    /**
     * 依据Id查找 机床当前状态 详情
     * @param machinestatusId
     * @return
     */
    public Machinestatus getMachinestatusById(Integer machinestatusId);

    /**
     * 依据Id删除 机床当前状态 记录
     * @param machinestatusId
     */
    public void delMachinestatusById(Integer machinestatusId);
}
