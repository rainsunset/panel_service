package com.seer.panel.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.seer.panel.common.BaseService;
import com.seer.panel.model.Machinestatushistory;
import com.seer.panel.mapper.MachinestatushistoryMapper;
import com.seer.panel.service.MachinestatushistoryService;
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
public class MachinestatushistoryServiceImpl extends BaseService implements MachinestatushistoryService {

    @Autowired
    private MachinestatushistoryMapper machinestatushistoryMapper;

    @Override
    public void  addMachinestatushistory(Machinestatushistory machinestatushistory) {
        machinestatushistoryMapper.addMachinestatushistory(machinestatushistory);
    }

    @Override
    public void  updateMachinestatushistoryById(Machinestatushistory machinestatushistory) {
        machinestatushistoryMapper.updateMachinestatushistoryById(machinestatushistory);
    }

    @Override
    public List<Machinestatushistory> selectMachinestatushistoryList(Map<String, Object> param) {
        return machinestatushistoryMapper.selectMachinestatushistoryList(param);
    }

    @Override
    public PageInfo<Machinestatushistory> getMachinestatushistoryPageTurn(Map<String, Object> param, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize, true);
        List<Machinestatushistory> machinestatushistoryList = machinestatushistoryMapper.selectMachinestatushistoryList(param);
        PageInfo<Machinestatushistory> pageInfo = new PageInfo<Machinestatushistory>(machinestatushistoryList);
        return pageInfo;
    }

    @Override
    public Machinestatushistory getMachinestatushistoryById(Integer machinestatushistoryId) {
        Machinestatushistory machinestatushistoryinfo = new Machinestatushistory();
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put("machinestatushistoryId", machinestatushistoryId);
        List<Machinestatushistory> machinestatushistoryList = machinestatushistoryMapper.selectMachinestatushistoryList(rs);
        if ((null != machinestatushistoryList) && (machinestatushistoryList.size() > 0)) {
            machinestatushistoryinfo = machinestatushistoryList.get(0);
        }
        return machinestatushistoryinfo;
    }

    @Override
    public void delMachinestatushistoryById(Integer machinestatushistoryId) {

     //Machinestatushistory machinestatushistory = new Machinestatushistory();
     //machinestatushistory.setIsDeleted(1);
     //machinestatushistory.setMachinestatushistoryId(machinestatushistoryId);
     //machinestatushistoryMapper.updateMachinestatushistoryById(machinestatushistory);

        machinestatushistoryMapper.delMachinestatushistoryById(machinestatushistoryId);

    }

}
