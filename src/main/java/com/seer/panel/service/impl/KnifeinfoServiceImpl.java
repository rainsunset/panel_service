package com.seer.panel.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.seer.panel.common.BaseService;
import com.seer.panel.model.Knifeinfo;
import com.seer.panel.mapper.KnifeinfoMapper;
import com.seer.panel.service.KnifeinfoService;
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
public class KnifeinfoServiceImpl extends BaseService implements KnifeinfoService {

    @Autowired
    private KnifeinfoMapper knifeinfoMapper;

    @Override
    public void  addKnifeinfo(Knifeinfo knifeinfo) {
        knifeinfoMapper.addKnifeinfo(knifeinfo);
    }

    @Override
    public void  updateKnifeinfoById(Knifeinfo knifeinfo) {
        knifeinfoMapper.updateKnifeinfoById(knifeinfo);
    }

    @Override
    public List<Knifeinfo> selectKnifeinfoList(Map<String, Object> param) {
        return knifeinfoMapper.selectKnifeinfoList(param);
    }

    @Override
    public PageInfo<Knifeinfo> getKnifeinfoPageTurn(Map<String, Object> param, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize, true);
        List<Knifeinfo> knifeinfoList = knifeinfoMapper.selectKnifeinfoList(param);
        PageInfo<Knifeinfo> pageInfo = new PageInfo<Knifeinfo>(knifeinfoList);
        return pageInfo;
    }

    @Override
    public Knifeinfo getKnifeinfoById(Integer knifeinfoId) {
        Knifeinfo knifeinfoinfo = new Knifeinfo();
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put("knifeinfoId", knifeinfoId);
        List<Knifeinfo> knifeinfoList = knifeinfoMapper.selectKnifeinfoList(rs);
        if ((null != knifeinfoList) && (knifeinfoList.size() > 0)) {
            knifeinfoinfo = knifeinfoList.get(0);
        }
        return knifeinfoinfo;
    }

    @Override
    public void delKnifeinfoById(Integer knifeinfoId) {

     //Knifeinfo knifeinfo = new Knifeinfo();
     //knifeinfo.setIsDeleted(1);
     //knifeinfo.setKnifeinfoId(knifeinfoId);
     //knifeinfoMapper.updateKnifeinfoById(knifeinfo);

        knifeinfoMapper.delKnifeinfoById(knifeinfoId);

    }

}
