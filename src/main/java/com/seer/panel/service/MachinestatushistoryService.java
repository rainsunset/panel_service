package com.seer.panel.service;

import com.github.pagehelper.PageInfo;
import com.seer.panel.model.Machinestatushistory;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
public interface MachinestatushistoryService {

    /**
     * 添加 机床状态历史记录
     * @param machinestatushistory
     */
    public void  addMachinestatushistory(Machinestatushistory machinestatushistory);

    /**
     * 依据主键更新 机床状态历史记录
     * @param machinestatushistory
     */
    public void  updateMachinestatushistoryById(Machinestatushistory machinestatushistory);

    /**
     * 依据条件查找 机床状态历史记录 列表
     * @param param
     * @return
     */
    public List<Machinestatushistory> selectMachinestatushistoryList(Map<String, Object> param);

    /**
     * 依据条件查找分页 机床状态历史记录 列表
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<Machinestatushistory> getMachinestatushistoryPageTurn(Map<String, Object> param, int pageNo, int pageSize);

    /**
     * 依据Id查找 机床状态历史记录 详情
     * @param machinestatushistoryId
     * @return
     */
    public Machinestatushistory getMachinestatushistoryById(Integer machinestatushistoryId);

    /**
     * 依据Id删除 机床状态历史记录 记录
     * @param machinestatushistoryId
     */
    public void delMachinestatushistoryById(Integer machinestatushistoryId);
}
