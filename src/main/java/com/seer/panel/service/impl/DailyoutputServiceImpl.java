package com.seer.panel.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.seer.panel.common.BaseService;
import com.seer.panel.model.Dailyoutput;
import com.seer.panel.mapper.DailyoutputMapper;
import com.seer.panel.service.DailyoutputService;
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
public class DailyoutputServiceImpl extends BaseService implements DailyoutputService {

    @Autowired
    private DailyoutputMapper dailyoutputMapper;

    @Override
    public void  addDailyoutput(Dailyoutput dailyoutput) {
        dailyoutputMapper.addDailyoutput(dailyoutput);
    }

    @Override
    public void  updateDailyoutputById(Dailyoutput dailyoutput) {
        dailyoutputMapper.updateDailyoutputById(dailyoutput);
    }

    @Override
    public List<Dailyoutput> selectDailyoutputList(Map<String, Object> param) {
        return dailyoutputMapper.selectDailyoutputList(param);
    }

    @Override
    public PageInfo<Dailyoutput> getDailyoutputPageTurn(Map<String, Object> param, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize, true);
        List<Dailyoutput> dailyoutputList = dailyoutputMapper.selectDailyoutputList(param);
        PageInfo<Dailyoutput> pageInfo = new PageInfo<Dailyoutput>(dailyoutputList);
        return pageInfo;
    }

    @Override
    public Dailyoutput getDailyoutputById(Integer dailyoutputId) {
        Dailyoutput dailyoutputinfo = new Dailyoutput();
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put("dailyoutputId", dailyoutputId);
        List<Dailyoutput> dailyoutputList = dailyoutputMapper.selectDailyoutputList(rs);
        if ((null != dailyoutputList) && (dailyoutputList.size() > 0)) {
            dailyoutputinfo = dailyoutputList.get(0);
        }
        return dailyoutputinfo;
    }

    @Override
    public void delDailyoutputById(Integer dailyoutputId) {

     //Dailyoutput dailyoutput = new Dailyoutput();
     //dailyoutput.setIsDeleted(1);
     //dailyoutput.setDailyoutputId(dailyoutputId);
     //dailyoutputMapper.updateDailyoutputById(dailyoutput);

        dailyoutputMapper.delDailyoutputById(dailyoutputId);

    }

}
