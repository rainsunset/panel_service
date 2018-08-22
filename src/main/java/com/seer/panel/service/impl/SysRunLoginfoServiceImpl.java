package com.seer.panel.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.seer.panel.common.BaseService;
import com.seer.panel.model.SysRunLoginfo;
import com.seer.panel.mapper.SysRunLoginfoMapper;
import com.seer.panel.service.SysRunLoginfoService;
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
public class SysRunLoginfoServiceImpl extends BaseService implements SysRunLoginfoService {

    @Autowired
    private SysRunLoginfoMapper sysRunLoginfoMapper;

    @Override
    public void  addSysRunLoginfo(SysRunLoginfo sysRunLoginfo) {
        sysRunLoginfoMapper.addSysRunLoginfo(sysRunLoginfo);
    }

    @Override
    public void  updateSysRunLoginfoById(SysRunLoginfo sysRunLoginfo) {
        sysRunLoginfoMapper.updateSysRunLoginfoById(sysRunLoginfo);
    }

    @Override
    public List<SysRunLoginfo> selectSysRunLoginfoList(Map<String, Object> param) {
        return sysRunLoginfoMapper.selectSysRunLoginfoList(param);
    }

    @Override
    public PageInfo<SysRunLoginfo> getSysRunLoginfoPageTurn(Map<String, Object> param, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize, true);
        List<SysRunLoginfo> sysRunLoginfoList = sysRunLoginfoMapper.selectSysRunLoginfoList(param);
        PageInfo<SysRunLoginfo> pageInfo = new PageInfo<SysRunLoginfo>(sysRunLoginfoList);
        return pageInfo;
    }

    @Override
    public SysRunLoginfo getSysRunLoginfoById(Integer sysRunLoginfoId) {
        SysRunLoginfo sysRunLoginfoinfo = new SysRunLoginfo();
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put("sysRunLoginfoId", sysRunLoginfoId);
        List<SysRunLoginfo> sysRunLoginfoList = sysRunLoginfoMapper.selectSysRunLoginfoList(rs);
        if ((null != sysRunLoginfoList) && (sysRunLoginfoList.size() > 0)) {
            sysRunLoginfoinfo = sysRunLoginfoList.get(0);
        }
        return sysRunLoginfoinfo;
    }

    @Override
    public void delSysRunLoginfoById(Integer sysRunLoginfoId) {

     //SysRunLoginfo sysRunLoginfo = new SysRunLoginfo();
     //sysRunLoginfo.setIsDeleted(1);
     //sysRunLoginfo.setSysRunLoginfoId(sysRunLoginfoId);
     //sysRunLoginfoMapper.updateSysRunLoginfoById(sysRunLoginfo);

        sysRunLoginfoMapper.delSysRunLoginfoById(sysRunLoginfoId);

    }

}
