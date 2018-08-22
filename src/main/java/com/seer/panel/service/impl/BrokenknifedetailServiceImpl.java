package com.seer.panel.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.seer.panel.common.BaseService;
import com.seer.panel.model.Brokenknifedetail;
import com.seer.panel.mapper.BrokenknifedetailMapper;
import com.seer.panel.service.BrokenknifedetailService;
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
public class BrokenknifedetailServiceImpl extends BaseService implements BrokenknifedetailService {

    @Autowired
    private BrokenknifedetailMapper brokenknifedetailMapper;

    @Override
    public void  addBrokenknifedetail(Brokenknifedetail brokenknifedetail) {
        brokenknifedetailMapper.addBrokenknifedetail(brokenknifedetail);
    }

    @Override
    public void  updateBrokenknifedetailById(Brokenknifedetail brokenknifedetail) {
        brokenknifedetailMapper.updateBrokenknifedetailById(brokenknifedetail);
    }

    @Override
    public List<Brokenknifedetail> selectBrokenknifedetailList(Map<String, Object> param) {
        return brokenknifedetailMapper.selectBrokenknifedetailList(param);
    }

    @Override
    public PageInfo<Brokenknifedetail> getBrokenknifedetailPageTurn(Map<String, Object> param, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize, true);
        List<Brokenknifedetail> brokenknifedetailList = brokenknifedetailMapper.selectBrokenknifedetailList(param);
        PageInfo<Brokenknifedetail> pageInfo = new PageInfo<Brokenknifedetail>(brokenknifedetailList);
        return pageInfo;
    }

    @Override
    public Brokenknifedetail getBrokenknifedetailById(Integer brokenknifedetailId) {
        Brokenknifedetail brokenknifedetailinfo = new Brokenknifedetail();
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put("brokenknifedetailId", brokenknifedetailId);
        List<Brokenknifedetail> brokenknifedetailList = brokenknifedetailMapper.selectBrokenknifedetailList(rs);
        if ((null != brokenknifedetailList) && (brokenknifedetailList.size() > 0)) {
            brokenknifedetailinfo = brokenknifedetailList.get(0);
        }
        return brokenknifedetailinfo;
    }

    @Override
    public void delBrokenknifedetailById(Integer brokenknifedetailId) {

     //Brokenknifedetail brokenknifedetail = new Brokenknifedetail();
     //brokenknifedetail.setIsDeleted(1);
     //brokenknifedetail.setBrokenknifedetailId(brokenknifedetailId);
     //brokenknifedetailMapper.updateBrokenknifedetailById(brokenknifedetail);

        brokenknifedetailMapper.delBrokenknifedetailById(brokenknifedetailId);

    }

}
