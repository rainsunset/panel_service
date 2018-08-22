package com.seer.panel.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.seer.panel.common.BaseService;
import com.seer.panel.model.Knifechangerhistory;
import com.seer.panel.mapper.KnifechangerhistoryMapper;
import com.seer.panel.service.KnifechangerhistoryService;
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
public class KnifechangerhistoryServiceImpl extends BaseService implements KnifechangerhistoryService {

    @Autowired
    private KnifechangerhistoryMapper knifechangerhistoryMapper;

    @Override
    public void  addKnifechangerhistory(Knifechangerhistory knifechangerhistory) {
        knifechangerhistoryMapper.addKnifechangerhistory(knifechangerhistory);
    }

    @Override
    public void  updateKnifechangerhistoryById(Knifechangerhistory knifechangerhistory) {
        knifechangerhistoryMapper.updateKnifechangerhistoryById(knifechangerhistory);
    }

    @Override
    public List<Knifechangerhistory> selectKnifechangerhistoryList(Map<String, Object> param) {
        return knifechangerhistoryMapper.selectKnifechangerhistoryList(param);
    }

    @Override
    public PageInfo<Knifechangerhistory> getKnifechangerhistoryPageTurn(Map<String, Object> param, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize, true);
        List<Knifechangerhistory> knifechangerhistoryList = knifechangerhistoryMapper.selectKnifechangerhistoryList(param);
        PageInfo<Knifechangerhistory> pageInfo = new PageInfo<Knifechangerhistory>(knifechangerhistoryList);
        return pageInfo;
    }

    @Override
    public Knifechangerhistory getKnifechangerhistoryById(Integer knifechangerhistoryId) {
        Knifechangerhistory knifechangerhistoryinfo = new Knifechangerhistory();
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put("knifechangerhistoryId", knifechangerhistoryId);
        List<Knifechangerhistory> knifechangerhistoryList = knifechangerhistoryMapper.selectKnifechangerhistoryList(rs);
        if ((null != knifechangerhistoryList) && (knifechangerhistoryList.size() > 0)) {
            knifechangerhistoryinfo = knifechangerhistoryList.get(0);
        }
        return knifechangerhistoryinfo;
    }

    @Override
    public void delKnifechangerhistoryById(Integer knifechangerhistoryId) {

     //Knifechangerhistory knifechangerhistory = new Knifechangerhistory();
     //knifechangerhistory.setIsDeleted(1);
     //knifechangerhistory.setKnifechangerhistoryId(knifechangerhistoryId);
     //knifechangerhistoryMapper.updateKnifechangerhistoryById(knifechangerhistory);

        knifechangerhistoryMapper.delKnifechangerhistoryById(knifechangerhistoryId);

    }

}
