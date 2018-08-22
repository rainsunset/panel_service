package com.seer.panel.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.seer.panel.common.BaseService;
import com.seer.panel.model.Machinestatus;
import com.seer.panel.mapper.MachinestatusMapper;
import com.seer.panel.service.MachinestatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author whaosoft
 *
 */
@Service
public class MachinestatusServiceImpl extends BaseService implements MachinestatusService {

    @Autowired
    private MachinestatusMapper machinestatusMapper;

    @Override
    public void  addMachinestatus(Machinestatus machinestatus) {
        machinestatusMapper.addMachinestatus(machinestatus);
    }

    @Override
    public void  updateMachinestatusById(Machinestatus machinestatus) {
        machinestatusMapper.updateMachinestatusById(machinestatus);
    }

    @Override
    public List<Machinestatus> selectMachinestatusList(Map<String, Object> param) {
        return machinestatusMapper.selectMachinestatusList(param);
    }

    @Override
    public PageInfo<Machinestatus> getMachinestatusPageTurn(Map<String, Object> param, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize, true);
        List<Machinestatus> machinestatusList = machinestatusMapper.selectMachinestatusList(param);
        PageInfo<Machinestatus> pageInfo = new PageInfo<Machinestatus>(machinestatusList);
        return pageInfo;
    }

    @Override
    public Machinestatus getMachinestatusById(Integer machinestatusId) {
        Machinestatus machinestatusinfo = new Machinestatus();
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put("machinestatusId", machinestatusId);
        List<Machinestatus> machinestatusList = machinestatusMapper.selectMachinestatusList(rs);
        if ((null != machinestatusList) && (machinestatusList.size() > 0)) {
            machinestatusinfo = machinestatusList.get(0);
        }
        return machinestatusinfo;
    }

    @Override
    public void delMachinestatusById(Integer machinestatusId) {

     //Machinestatus machinestatus = new Machinestatus();
     //machinestatus.setIsDeleted(1);
     //machinestatus.setMachinestatusId(machinestatusId);
     //machinestatusMapper.updateMachinestatusById(machinestatus);

        machinestatusMapper.delMachinestatusById(machinestatusId);

    }

}
