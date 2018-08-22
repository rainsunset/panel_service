package com.seer.panel.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.seer.panel.common.BaseService;
import com.seer.panel.model.Knifelife;
import com.seer.panel.mapper.KnifelifeMapper;
import com.seer.panel.service.KnifelifeService;
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
public class KnifelifeServiceImpl extends BaseService implements KnifelifeService {

    @Autowired
    private KnifelifeMapper knifelifeMapper;

    @Override
    public void  addKnifelife(Knifelife knifelife) {
        knifelifeMapper.addKnifelife(knifelife);
    }

    @Override
    public void  updateKnifelifeById(Knifelife knifelife) {
        knifelifeMapper.updateKnifelifeById(knifelife);
    }

    @Override
    public List<Knifelife> selectKnifelifeList(Map<String, Object> param) {
        return knifelifeMapper.selectKnifelifeList(param);
    }

    @Override
    public PageInfo<Knifelife> getKnifelifePageTurn(Map<String, Object> param, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize, true);
        List<Knifelife> knifelifeList = knifelifeMapper.selectKnifelifeList(param);
        PageInfo<Knifelife> pageInfo = new PageInfo<Knifelife>(knifelifeList);
        return pageInfo;
    }

    @Override
    public Knifelife getKnifelifeById(Integer knifelifeId) {
        Knifelife knifelifeinfo = new Knifelife();
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put("knifelifeId", knifelifeId);
        List<Knifelife> knifelifeList = knifelifeMapper.selectKnifelifeList(rs);
        if ((null != knifelifeList) && (knifelifeList.size() > 0)) {
            knifelifeinfo = knifelifeList.get(0);
        }
        return knifelifeinfo;
    }

    @Override
    public void delKnifelifeById(Integer knifelifeId) {

     //Knifelife knifelife = new Knifelife();
     //knifelife.setIsDeleted(1);
     //knifelife.setKnifelifeId(knifelifeId);
     //knifelifeMapper.updateKnifelifeById(knifelife);

        knifelifeMapper.delKnifelifeById(knifelifeId);

    }

}
