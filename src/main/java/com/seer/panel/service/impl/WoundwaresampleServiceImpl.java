package com.seer.panel.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.seer.panel.common.BaseService;
import com.seer.panel.model.Woundwaresample;
import com.seer.panel.mapper.WoundwaresampleMapper;
import com.seer.panel.service.WoundwaresampleService;
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
public class WoundwaresampleServiceImpl extends BaseService implements WoundwaresampleService {

    @Autowired
    private WoundwaresampleMapper woundwaresampleMapper;

    @Override
    public void  addWoundwaresample(Woundwaresample woundwaresample) {
        woundwaresampleMapper.addWoundwaresample(woundwaresample);
    }

    @Override
    public void  updateWoundwaresampleById(Woundwaresample woundwaresample) {
        woundwaresampleMapper.updateWoundwaresampleById(woundwaresample);
    }

    @Override
    public List<Woundwaresample> selectWoundwaresampleList(Map<String, Object> param) {
        return woundwaresampleMapper.selectWoundwaresampleList(param);
    }

    @Override
    public PageInfo<Woundwaresample> getWoundwaresamplePageTurn(Map<String, Object> param, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize, true);
        List<Woundwaresample> woundwaresampleList = woundwaresampleMapper.selectWoundwaresampleList(param);
        PageInfo<Woundwaresample> pageInfo = new PageInfo<Woundwaresample>(woundwaresampleList);
        return pageInfo;
    }

    @Override
    public Woundwaresample getWoundwaresampleById(Integer woundwaresampleId) {
        Woundwaresample woundwaresampleinfo = new Woundwaresample();
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put("woundwaresampleId", woundwaresampleId);
        List<Woundwaresample> woundwaresampleList = woundwaresampleMapper.selectWoundwaresampleList(rs);
        if ((null != woundwaresampleList) && (woundwaresampleList.size() > 0)) {
            woundwaresampleinfo = woundwaresampleList.get(0);
        }
        return woundwaresampleinfo;
    }

    @Override
    public void delWoundwaresampleById(Integer woundwaresampleId) {

     //Woundwaresample woundwaresample = new Woundwaresample();
     //woundwaresample.setIsDeleted(1);
     //woundwaresample.setWoundwaresampleId(woundwaresampleId);
     //woundwaresampleMapper.updateWoundwaresampleById(woundwaresample);

        woundwaresampleMapper.delWoundwaresampleById(woundwaresampleId);

    }

}
