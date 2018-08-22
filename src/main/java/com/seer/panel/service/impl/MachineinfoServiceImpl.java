package com.seer.panel.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.seer.panel.common.BaseService;
import com.seer.panel.model.Machineinfo;
import com.seer.panel.mapper.MachineinfoMapper;
import com.seer.panel.service.MachineinfoService;
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
public class MachineinfoServiceImpl extends BaseService implements MachineinfoService {

    @Autowired
    private MachineinfoMapper machineinfoMapper;

    @Override
    public void  addMachineinfo(Machineinfo machineinfo) {
        machineinfoMapper.addMachineinfo(machineinfo);
    }

    @Override
    public void  updateMachineinfoById(Machineinfo machineinfo) {
        machineinfoMapper.updateMachineinfoById(machineinfo);
    }

    @Override
    public List<Machineinfo> selectMachineinfoList(Map<String, Object> param) {
        return machineinfoMapper.selectMachineinfoList(param);
    }

    @Override
    public PageInfo<Machineinfo> getMachineinfoPageTurn(Map<String, Object> param, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize, true);
        List<Machineinfo> machineinfoList = machineinfoMapper.selectMachineinfoList(param);
        PageInfo<Machineinfo> pageInfo = new PageInfo<Machineinfo>(machineinfoList);
        return pageInfo;
    }

    @Override
    public Machineinfo getMachineinfoById(Integer machineinfoId) {
        Machineinfo machineinfoinfo = new Machineinfo();
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put("machineinfoId", machineinfoId);
        List<Machineinfo> machineinfoList = machineinfoMapper.selectMachineinfoList(rs);
        if ((null != machineinfoList) && (machineinfoList.size() > 0)) {
            machineinfoinfo = machineinfoList.get(0);
        }
        return machineinfoinfo;
    }

    @Override
    public void delMachineinfoById(Integer machineinfoId) {

     //Machineinfo machineinfo = new Machineinfo();
     //machineinfo.setIsDeleted(1);
     //machineinfo.setMachineinfoId(machineinfoId);
     //machineinfoMapper.updateMachineinfoById(machineinfo);

        machineinfoMapper.delMachineinfoById(machineinfoId);

    }

}
