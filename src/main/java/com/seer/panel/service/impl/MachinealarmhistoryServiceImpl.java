package com.seer.panel.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.seer.panel.common.BaseService;
import com.seer.panel.model.Machinealarmhistory;
import com.seer.panel.mapper.MachinealarmhistoryMapper;
import com.seer.panel.service.MachinealarmhistoryService;
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
public class MachinealarmhistoryServiceImpl extends BaseService implements MachinealarmhistoryService {

    @Autowired
    private MachinealarmhistoryMapper machinealarmhistoryMapper;

    @Override
    public void  addMachinealarmhistory(Machinealarmhistory machinealarmhistory) {
        machinealarmhistoryMapper.addMachinealarmhistory(machinealarmhistory);
    }

    @Override
    public void  updateMachinealarmhistoryById(Machinealarmhistory machinealarmhistory) {
        machinealarmhistoryMapper.updateMachinealarmhistoryById(machinealarmhistory);
    }

    @Override
    public List<Machinealarmhistory> selectMachinealarmhistoryList(Map<String, Object> param) {
        return machinealarmhistoryMapper.selectMachinealarmhistoryList(param);
    }

    @Override
    public PageInfo<Machinealarmhistory> getMachinealarmhistoryPageTurn(Map<String, Object> param, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize, true);
        List<Machinealarmhistory> machinealarmhistoryList = machinealarmhistoryMapper.selectMachinealarmhistoryList(param);
        PageInfo<Machinealarmhistory> pageInfo = new PageInfo<Machinealarmhistory>(machinealarmhistoryList);
        return pageInfo;
    }

    @Override
    public Machinealarmhistory getMachinealarmhistoryById(Integer machinealarmhistoryId) {
        Machinealarmhistory machinealarmhistoryinfo = new Machinealarmhistory();
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put("machinealarmhistoryId", machinealarmhistoryId);
        List<Machinealarmhistory> machinealarmhistoryList = machinealarmhistoryMapper.selectMachinealarmhistoryList(rs);
        if ((null != machinealarmhistoryList) && (machinealarmhistoryList.size() > 0)) {
            machinealarmhistoryinfo = machinealarmhistoryList.get(0);
        }
        return machinealarmhistoryinfo;
    }

    @Override
    public void delMachinealarmhistoryById(Integer machinealarmhistoryId) {

     //Machinealarmhistory machinealarmhistory = new Machinealarmhistory();
     //machinealarmhistory.setIsDeleted(1);
     //machinealarmhistory.setMachinealarmhistoryId(machinealarmhistoryId);
     //machinealarmhistoryMapper.updateMachinealarmhistoryById(machinealarmhistory);

        machinealarmhistoryMapper.delMachinealarmhistoryById(machinealarmhistoryId);

    }

}
