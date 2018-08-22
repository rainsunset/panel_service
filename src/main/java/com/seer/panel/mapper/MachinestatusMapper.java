package com.seer.panel.mapper;

import com.seer.panel.model.Machinestatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
 @Repository
public interface MachinestatusMapper {

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
     * 依据主键删除 机床当前状态 记录
     * @param machinestatusId
     */
    public void  delMachinestatusById(Integer machinestatusId);

}
