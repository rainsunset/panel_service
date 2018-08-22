package com.seer.panel.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.seer.panel.common.BaseService;
import com.seer.panel.model.Knifeorder;
import com.seer.panel.mapper.KnifeorderMapper;
import com.seer.panel.service.KnifeorderService;
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
public class KnifeorderServiceImpl extends BaseService implements KnifeorderService {

    @Autowired
    private KnifeorderMapper knifeorderMapper;

    @Override
    public void  addKnifeorder(Knifeorder knifeorder) {
        knifeorderMapper.addKnifeorder(knifeorder);
    }

    @Override
    public void  updateKnifeorderById(Knifeorder knifeorder) {
        knifeorderMapper.updateKnifeorderById(knifeorder);
    }

    @Override
    public List<Knifeorder> selectKnifeorderList(Map<String, Object> param) {
        return knifeorderMapper.selectKnifeorderList(param);
    }

    @Override
    public PageInfo<Knifeorder> getKnifeorderPageTurn(Map<String, Object> param, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize, true);
        List<Knifeorder> knifeorderList = knifeorderMapper.selectKnifeorderList(param);
        PageInfo<Knifeorder> pageInfo = new PageInfo<Knifeorder>(knifeorderList);
        return pageInfo;
    }

    @Override
    public Knifeorder getKnifeorderById(Integer knifeorderId) {
        Knifeorder knifeorderinfo = new Knifeorder();
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put("knifeorderId", knifeorderId);
        List<Knifeorder> knifeorderList = knifeorderMapper.selectKnifeorderList(rs);
        if ((null != knifeorderList) && (knifeorderList.size() > 0)) {
            knifeorderinfo = knifeorderList.get(0);
        }
        return knifeorderinfo;
    }

    @Override
    public void delKnifeorderById(Integer knifeorderId) {

     //Knifeorder knifeorder = new Knifeorder();
     //knifeorder.setIsDeleted(1);
     //knifeorder.setKnifeorderId(knifeorderId);
     //knifeorderMapper.updateKnifeorderById(knifeorder);

        knifeorderMapper.delKnifeorderById(knifeorderId);

    }

}
