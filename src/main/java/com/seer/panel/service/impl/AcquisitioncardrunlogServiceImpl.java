package com.seer.panel.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.seer.panel.common.BaseService;
import com.seer.panel.model.Acquisitioncardrunlog;
import com.seer.panel.mapper.AcquisitioncardrunlogMapper;
import com.seer.panel.service.AcquisitioncardrunlogService;
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
public class AcquisitioncardrunlogServiceImpl extends BaseService implements AcquisitioncardrunlogService {

    @Autowired
    private AcquisitioncardrunlogMapper acquisitioncardrunlogMapper;

    @Override
    public void  addAcquisitioncardrunlog(Acquisitioncardrunlog acquisitioncardrunlog) {
        acquisitioncardrunlogMapper.addAcquisitioncardrunlog(acquisitioncardrunlog);
    }

    @Override
    public void  updateAcquisitioncardrunlogById(Acquisitioncardrunlog acquisitioncardrunlog) {
        acquisitioncardrunlogMapper.updateAcquisitioncardrunlogById(acquisitioncardrunlog);
    }

    @Override
    public List<Acquisitioncardrunlog> selectAcquisitioncardrunlogList(Map<String, Object> param) {
        return acquisitioncardrunlogMapper.selectAcquisitioncardrunlogList(param);
    }

    @Override
    public PageInfo<Acquisitioncardrunlog> getAcquisitioncardrunlogPageTurn(Map<String, Object> param, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize, true);
        List<Acquisitioncardrunlog> acquisitioncardrunlogList = acquisitioncardrunlogMapper.selectAcquisitioncardrunlogList(param);
        PageInfo<Acquisitioncardrunlog> pageInfo = new PageInfo<Acquisitioncardrunlog>(acquisitioncardrunlogList);
        return pageInfo;
    }

    @Override
    public Acquisitioncardrunlog getAcquisitioncardrunlogById(Integer acquisitioncardrunlogId) {
        Acquisitioncardrunlog acquisitioncardrunloginfo = new Acquisitioncardrunlog();
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put("acquisitioncardrunlogId", acquisitioncardrunlogId);
        List<Acquisitioncardrunlog> acquisitioncardrunlogList = acquisitioncardrunlogMapper.selectAcquisitioncardrunlogList(rs);
        if ((null != acquisitioncardrunlogList) && (acquisitioncardrunlogList.size() > 0)) {
            acquisitioncardrunloginfo = acquisitioncardrunlogList.get(0);
        }
        return acquisitioncardrunloginfo;
    }

    @Override
    public void delAcquisitioncardrunlogById(Integer acquisitioncardrunlogId) {

     //Acquisitioncardrunlog acquisitioncardrunlog = new Acquisitioncardrunlog();
     //acquisitioncardrunlog.setIsDeleted(1);
     //acquisitioncardrunlog.setAcquisitioncardrunlogId(acquisitioncardrunlogId);
     //acquisitioncardrunlogMapper.updateAcquisitioncardrunlogById(acquisitioncardrunlog);

        acquisitioncardrunlogMapper.delAcquisitioncardrunlogById(acquisitioncardrunlogId);

    }

}
