package com.seer.panel.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.seer.panel.common.BaseService;
import com.seer.panel.model.RptMachineTotalStatusInfo;
import com.seer.panel.mapper.RptMachineTotalStatusInfoMapper;
import com.seer.panel.service.RptMachineTotalStatusInfoService;
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
public class RptMachineTotalStatusInfoServiceImpl extends BaseService implements RptMachineTotalStatusInfoService {

    @Autowired
    private RptMachineTotalStatusInfoMapper rptMachineTotalStatusInfoMapper;

    @Override
    public void  addRptMachineTotalStatusInfo(RptMachineTotalStatusInfo rptMachineTotalStatusInfo) {
        rptMachineTotalStatusInfoMapper.addRptMachineTotalStatusInfo(rptMachineTotalStatusInfo);
    }

    @Override
    public void  updateRptMachineTotalStatusInfoById(RptMachineTotalStatusInfo rptMachineTotalStatusInfo) {
        rptMachineTotalStatusInfoMapper.updateRptMachineTotalStatusInfoById(rptMachineTotalStatusInfo);
    }

    @Override
    public List<RptMachineTotalStatusInfo> selectRptMachineTotalStatusInfoList(Map<String, Object> param) {
        return rptMachineTotalStatusInfoMapper.selectRptMachineTotalStatusInfoList(param);
    }

    @Override
    public PageInfo<RptMachineTotalStatusInfo> getRptMachineTotalStatusInfoPageTurn(Map<String, Object> param, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize, true);
        List<RptMachineTotalStatusInfo> rptMachineTotalStatusInfoList = rptMachineTotalStatusInfoMapper.selectRptMachineTotalStatusInfoList(param);
        PageInfo<RptMachineTotalStatusInfo> pageInfo = new PageInfo<RptMachineTotalStatusInfo>(rptMachineTotalStatusInfoList);
        return pageInfo;
    }

    @Override
    public RptMachineTotalStatusInfo getRptMachineTotalStatusInfoById(Integer rptMachineTotalStatusInfoId) {
        RptMachineTotalStatusInfo rptMachineTotalStatusInfoinfo = new RptMachineTotalStatusInfo();
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put("rptMachineTotalStatusInfoId", rptMachineTotalStatusInfoId);
        List<RptMachineTotalStatusInfo> rptMachineTotalStatusInfoList = rptMachineTotalStatusInfoMapper.selectRptMachineTotalStatusInfoList(rs);
        if ((null != rptMachineTotalStatusInfoList) && (rptMachineTotalStatusInfoList.size() > 0)) {
            rptMachineTotalStatusInfoinfo = rptMachineTotalStatusInfoList.get(0);
        }
        return rptMachineTotalStatusInfoinfo;
    }

    @Override
    public void delRptMachineTotalStatusInfoById(Integer rptMachineTotalStatusInfoId) {

     //RptMachineTotalStatusInfo rptMachineTotalStatusInfo = new RptMachineTotalStatusInfo();
     //rptMachineTotalStatusInfo.setIsDeleted(1);
     //rptMachineTotalStatusInfo.setRptMachineTotalStatusInfoId(rptMachineTotalStatusInfoId);
     //rptMachineTotalStatusInfoMapper.updateRptMachineTotalStatusInfoById(rptMachineTotalStatusInfo);

        rptMachineTotalStatusInfoMapper.delRptMachineTotalStatusInfoById(rptMachineTotalStatusInfoId);

    }

}
