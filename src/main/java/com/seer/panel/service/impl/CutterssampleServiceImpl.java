package com.seer.panel.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.seer.panel.common.BaseService;
import com.seer.panel.model.Cutterssample;
import com.seer.panel.mapper.CutterssampleMapper;
import com.seer.panel.service.CutterssampleService;
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
public class CutterssampleServiceImpl extends BaseService implements CutterssampleService {

    @Autowired
    private CutterssampleMapper cutterssampleMapper;

    @Override
    public void  addCutterssample(Cutterssample cutterssample) {
        cutterssampleMapper.addCutterssample(cutterssample);
    }

    @Override
    public void  updateCutterssampleById(Cutterssample cutterssample) {
        cutterssampleMapper.updateCutterssampleById(cutterssample);
    }

    @Override
    public List<Cutterssample> selectCutterssampleList(Map<String, Object> param) {
        return cutterssampleMapper.selectCutterssampleList(param);
    }

    @Override
    public PageInfo<Cutterssample> getCutterssamplePageTurn(Map<String, Object> param, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize, true);
        List<Cutterssample> cutterssampleList = cutterssampleMapper.selectCutterssampleList(param);
        PageInfo<Cutterssample> pageInfo = new PageInfo<Cutterssample>(cutterssampleList);
        return pageInfo;
    }

    @Override
    public Cutterssample getCutterssampleById(Integer cutterssampleId) {
        Cutterssample cutterssampleinfo = new Cutterssample();
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put("cutterssampleId", cutterssampleId);
        List<Cutterssample> cutterssampleList = cutterssampleMapper.selectCutterssampleList(rs);
        if ((null != cutterssampleList) && (cutterssampleList.size() > 0)) {
            cutterssampleinfo = cutterssampleList.get(0);
        }
        return cutterssampleinfo;
    }

    @Override
    public void delCutterssampleById(Integer cutterssampleId) {

     //Cutterssample cutterssample = new Cutterssample();
     //cutterssample.setIsDeleted(1);
     //cutterssample.setCutterssampleId(cutterssampleId);
     //cutterssampleMapper.updateCutterssampleById(cutterssample);

        cutterssampleMapper.delCutterssampleById(cutterssampleId);

    }

}
