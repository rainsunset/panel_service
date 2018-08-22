package com.seer.panel.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.seer.panel.common.BaseService;
import com.seer.panel.model.Sensorinfo;
import com.seer.panel.mapper.SensorinfoMapper;
import com.seer.panel.service.SensorinfoService;
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
public class SensorinfoServiceImpl extends BaseService implements SensorinfoService {

    @Autowired
    private SensorinfoMapper sensorinfoMapper;

    @Override
    public void  addSensorinfo(Sensorinfo sensorinfo) {
        sensorinfoMapper.addSensorinfo(sensorinfo);
    }

    @Override
    public void  updateSensorinfoById(Sensorinfo sensorinfo) {
        sensorinfoMapper.updateSensorinfoById(sensorinfo);
    }

    @Override
    public List<Sensorinfo> selectSensorinfoList(Map<String, Object> param) {
        return sensorinfoMapper.selectSensorinfoList(param);
    }

    @Override
    public PageInfo<Sensorinfo> getSensorinfoPageTurn(Map<String, Object> param, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize, true);
        List<Sensorinfo> sensorinfoList = sensorinfoMapper.selectSensorinfoList(param);
        PageInfo<Sensorinfo> pageInfo = new PageInfo<Sensorinfo>(sensorinfoList);
        return pageInfo;
    }

    @Override
    public Sensorinfo getSensorinfoById(Integer sensorinfoId) {
        Sensorinfo sensorinfoinfo = new Sensorinfo();
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put("sensorinfoId", sensorinfoId);
        List<Sensorinfo> sensorinfoList = sensorinfoMapper.selectSensorinfoList(rs);
        if ((null != sensorinfoList) && (sensorinfoList.size() > 0)) {
            sensorinfoinfo = sensorinfoList.get(0);
        }
        return sensorinfoinfo;
    }

    @Override
    public void delSensorinfoById(Integer sensorinfoId) {

     //Sensorinfo sensorinfo = new Sensorinfo();
     //sensorinfo.setIsDeleted(1);
     //sensorinfo.setSensorinfoId(sensorinfoId);
     //sensorinfoMapper.updateSensorinfoById(sensorinfo);

        sensorinfoMapper.delSensorinfoById(sensorinfoId);

    }

}
