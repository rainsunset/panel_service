package com.seer.panel.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.seer.panel.common.BaseService;
import com.seer.panel.model.Count;
import com.seer.panel.mapper.CountMapper;
import com.seer.panel.service.CountService;
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
public class CountServiceImpl extends BaseService implements CountService {

    @Autowired
    private CountMapper countMapper;

    @Override
    public void  addCount(Count count) {
        countMapper.addCount(count);
    }

    @Override
    public void  updateCountById(Count count) {
        countMapper.updateCountById(count);
    }

    @Override
    public List<Count> selectCountList(Map<String, Object> param) {
        return countMapper.selectCountList(param);
    }

    @Override
    public PageInfo<Count> getCountPageTurn(Map<String, Object> param, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize, true);
        List<Count> countList = countMapper.selectCountList(param);
        PageInfo<Count> pageInfo = new PageInfo<Count>(countList);
        return pageInfo;
    }

    @Override
    public Count getCountById(Integer countId) {
        Count countinfo = new Count();
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put("countId", countId);
        List<Count> countList = countMapper.selectCountList(rs);
        if ((null != countList) && (countList.size() > 0)) {
            countinfo = countList.get(0);
        }
        return countinfo;
    }

    @Override
    public void delCountById(Integer countId) {

     //Count count = new Count();
     //count.setIsDeleted(1);
     //count.setCountId(countId);
     //countMapper.updateCountById(count);

        countMapper.delCountById(countId);

    }

}
