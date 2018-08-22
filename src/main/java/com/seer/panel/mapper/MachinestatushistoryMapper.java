package com.seer.panel.mapper;

import com.seer.panel.model.Machinestatushistory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
 @Repository
public interface MachinestatushistoryMapper {

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
     * 依据主键删除 机床状态历史记录 记录
     * @param machinestatushistoryId
     */
    public void  delMachinestatushistoryById(Integer machinestatushistoryId);

}
