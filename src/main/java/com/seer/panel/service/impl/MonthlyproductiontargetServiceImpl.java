package com.seer.panel.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.seer.panel.common.BaseService;
import com.seer.panel.model.Monthlyproductiontarget;
import com.seer.panel.mapper.MonthlyproductiontargetMapper;
import com.seer.panel.service.MonthlyproductiontargetService;
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
public class MonthlyproductiontargetServiceImpl extends BaseService implements MonthlyproductiontargetService {

    @Autowired
    private MonthlyproductiontargetMapper monthlyproductiontargetMapper;

    @Override
    public void  addMonthlyproductiontarget(Monthlyproductiontarget monthlyproductiontarget) {
        monthlyproductiontargetMapper.addMonthlyproductiontarget(monthlyproductiontarget);
    }

    @Override
    public void  updateMonthlyproductiontargetById(Monthlyproductiontarget monthlyproductiontarget) {
        monthlyproductiontargetMapper.updateMonthlyproductiontargetById(monthlyproductiontarget);
    }

    @Override
    public List<Monthlyproductiontarget> selectMonthlyproductiontargetList(Map<String, Object> param) {
        return monthlyproductiontargetMapper.selectMonthlyproductiontargetList(param);
    }

    @Override
    public PageInfo<Monthlyproductiontarget> getMonthlyproductiontargetPageTurn(Map<String, Object> param, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize, true);
        List<Monthlyproductiontarget> monthlyproductiontargetList = monthlyproductiontargetMapper.selectMonthlyproductiontargetList(param);
        PageInfo<Monthlyproductiontarget> pageInfo = new PageInfo<Monthlyproductiontarget>(monthlyproductiontargetList);
        return pageInfo;
    }

    @Override
    public Monthlyproductiontarget getMonthlyproductiontargetById(Integer monthlyproductiontargetId) {
        Monthlyproductiontarget monthlyproductiontargetinfo = new Monthlyproductiontarget();
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put("monthlyproductiontargetId", monthlyproductiontargetId);
        List<Monthlyproductiontarget> monthlyproductiontargetList = monthlyproductiontargetMapper.selectMonthlyproductiontargetList(rs);
        if ((null != monthlyproductiontargetList) && (monthlyproductiontargetList.size() > 0)) {
            monthlyproductiontargetinfo = monthlyproductiontargetList.get(0);
        }
        return monthlyproductiontargetinfo;
    }

    @Override
    public void delMonthlyproductiontargetById(Integer monthlyproductiontargetId) {

     //Monthlyproductiontarget monthlyproductiontarget = new Monthlyproductiontarget();
     //monthlyproductiontarget.setIsDeleted(1);
     //monthlyproductiontarget.setMonthlyproductiontargetId(monthlyproductiontargetId);
     //monthlyproductiontargetMapper.updateMonthlyproductiontargetById(monthlyproductiontarget);

        monthlyproductiontargetMapper.delMonthlyproductiontargetById(monthlyproductiontargetId);

    }

}
