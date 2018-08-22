package com.seer.panel.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.seer.panel.common.BaseService;
import com.seer.panel.model.Cuttersrawdata;
import com.seer.panel.mapper.CuttersrawdataMapper;
import com.seer.panel.service.CuttersrawdataService;
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
public class CuttersrawdataServiceImpl extends BaseService implements CuttersrawdataService {

    @Autowired
    private CuttersrawdataMapper cuttersrawdataMapper;

    @Override
    public void  addCuttersrawdata(Cuttersrawdata cuttersrawdata) {
        cuttersrawdataMapper.addCuttersrawdata(cuttersrawdata);
    }

    @Override
    public void  updateCuttersrawdataById(Cuttersrawdata cuttersrawdata) {
        cuttersrawdataMapper.updateCuttersrawdataById(cuttersrawdata);
    }

    @Override
    public List<Cuttersrawdata> selectCuttersrawdataList(Map<String, Object> param) {
        return cuttersrawdataMapper.selectCuttersrawdataList(param);
    }

    @Override
    public PageInfo<Cuttersrawdata> getCuttersrawdataPageTurn(Map<String, Object> param, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize, true);
        List<Cuttersrawdata> cuttersrawdataList = cuttersrawdataMapper.selectCuttersrawdataList(param);
        PageInfo<Cuttersrawdata> pageInfo = new PageInfo<Cuttersrawdata>(cuttersrawdataList);
        return pageInfo;
    }

    @Override
    public Cuttersrawdata getCuttersrawdataById(Integer cuttersrawdataId) {
        Cuttersrawdata cuttersrawdatainfo = new Cuttersrawdata();
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put("cuttersrawdataId", cuttersrawdataId);
        List<Cuttersrawdata> cuttersrawdataList = cuttersrawdataMapper.selectCuttersrawdataList(rs);
        if ((null != cuttersrawdataList) && (cuttersrawdataList.size() > 0)) {
            cuttersrawdatainfo = cuttersrawdataList.get(0);
        }
        return cuttersrawdatainfo;
    }

    @Override
    public void delCuttersrawdataById(Integer cuttersrawdataId) {

     //Cuttersrawdata cuttersrawdata = new Cuttersrawdata();
     //cuttersrawdata.setIsDeleted(1);
     //cuttersrawdata.setCuttersrawdataId(cuttersrawdataId);
     //cuttersrawdataMapper.updateCuttersrawdataById(cuttersrawdata);

        cuttersrawdataMapper.delCuttersrawdataById(cuttersrawdataId);

    }

}
