package com.seer.panel.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.seer.panel.common.BaseService;
import com.seer.panel.model.WeiXinUserInfo;
import com.seer.panel.mapper.WeiXinUserInfoMapper;
import com.seer.panel.service.WeiXinUserInfoService;
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
public class WeiXinUserInfoServiceImpl extends BaseService implements WeiXinUserInfoService {

    @Autowired
    private WeiXinUserInfoMapper weiXinUserInfoMapper;

    @Override
    public void  addWeiXinUserInfo(WeiXinUserInfo weiXinUserInfo) {
        weiXinUserInfoMapper.addWeiXinUserInfo(weiXinUserInfo);
    }

    @Override
    public void  updateWeiXinUserInfoById(WeiXinUserInfo weiXinUserInfo) {
        weiXinUserInfoMapper.updateWeiXinUserInfoById(weiXinUserInfo);
    }

    @Override
    public List<WeiXinUserInfo> selectWeiXinUserInfoList(Map<String, Object> param) {
        return weiXinUserInfoMapper.selectWeiXinUserInfoList(param);
    }

    @Override
    public PageInfo<WeiXinUserInfo> getWeiXinUserInfoPageTurn(Map<String, Object> param, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize, true);
        List<WeiXinUserInfo> weiXinUserInfoList = weiXinUserInfoMapper.selectWeiXinUserInfoList(param);
        PageInfo<WeiXinUserInfo> pageInfo = new PageInfo<WeiXinUserInfo>(weiXinUserInfoList);
        return pageInfo;
    }

    @Override
    public WeiXinUserInfo getWeiXinUserInfoById(Integer weiXinUserInfoId) {
        WeiXinUserInfo weiXinUserInfoinfo = new WeiXinUserInfo();
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put("weiXinUserInfoId", weiXinUserInfoId);
        List<WeiXinUserInfo> weiXinUserInfoList = weiXinUserInfoMapper.selectWeiXinUserInfoList(rs);
        if ((null != weiXinUserInfoList) && (weiXinUserInfoList.size() > 0)) {
            weiXinUserInfoinfo = weiXinUserInfoList.get(0);
        }
        return weiXinUserInfoinfo;
    }

    @Override
    public void delWeiXinUserInfoById(Integer weiXinUserInfoId) {

     //WeiXinUserInfo weiXinUserInfo = new WeiXinUserInfo();
     //weiXinUserInfo.setIsDeleted(1);
     //weiXinUserInfo.setWeiXinUserInfoId(weiXinUserInfoId);
     //weiXinUserInfoMapper.updateWeiXinUserInfoById(weiXinUserInfo);

        weiXinUserInfoMapper.delWeiXinUserInfoById(weiXinUserInfoId);

    }

}
