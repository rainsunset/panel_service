package com.seer.panel.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.seer.panel.common.BaseService;
import com.seer.panel.model.WeiXinopen;
import com.seer.panel.mapper.WeiXinopenMapper;
import com.seer.panel.service.WeiXinopenService;
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
public class WeiXinopenServiceImpl extends BaseService implements WeiXinopenService {

    @Autowired
    private WeiXinopenMapper weiXinopenMapper;

    @Override
    public void  addWeiXinopen(WeiXinopen weiXinopen) {
        weiXinopenMapper.addWeiXinopen(weiXinopen);
    }

    @Override
    public void  updateWeiXinopenById(WeiXinopen weiXinopen) {
        weiXinopenMapper.updateWeiXinopenById(weiXinopen);
    }

    @Override
    public List<WeiXinopen> selectWeiXinopenList(Map<String, Object> param) {
        return weiXinopenMapper.selectWeiXinopenList(param);
    }

    @Override
    public PageInfo<WeiXinopen> getWeiXinopenPageTurn(Map<String, Object> param, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize, true);
        List<WeiXinopen> weiXinopenList = weiXinopenMapper.selectWeiXinopenList(param);
        PageInfo<WeiXinopen> pageInfo = new PageInfo<WeiXinopen>(weiXinopenList);
        return pageInfo;
    }

    @Override
    public WeiXinopen getWeiXinopenById(Integer weiXinopenId) {
        WeiXinopen weiXinopeninfo = new WeiXinopen();
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put("weiXinopenId", weiXinopenId);
        List<WeiXinopen> weiXinopenList = weiXinopenMapper.selectWeiXinopenList(rs);
        if ((null != weiXinopenList) && (weiXinopenList.size() > 0)) {
            weiXinopeninfo = weiXinopenList.get(0);
        }
        return weiXinopeninfo;
    }

    @Override
    public void delWeiXinopenById(Integer weiXinopenId) {

     //WeiXinopen weiXinopen = new WeiXinopen();
     //weiXinopen.setIsDeleted(1);
     //weiXinopen.setWeiXinopenId(weiXinopenId);
     //weiXinopenMapper.updateWeiXinopenById(weiXinopen);

        weiXinopenMapper.delWeiXinopenById(weiXinopenId);

    }

}
