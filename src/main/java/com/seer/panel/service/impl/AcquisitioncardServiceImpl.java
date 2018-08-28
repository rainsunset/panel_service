package com.seer.panel.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.seer.panel.common.BaseService;
import com.seer.panel.model.Acquisitioncard;
import com.seer.panel.mapper.AcquisitioncardMapper;
import com.seer.panel.service.AcquisitioncardService;
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
public class AcquisitioncardServiceImpl extends BaseService implements AcquisitioncardService {

    @Autowired
    private AcquisitioncardMapper acquisitioncardMapper;

    @Override
    public void  addAcquisitioncard(Acquisitioncard acquisitioncard) {
        acquisitioncardMapper.addAcquisitioncard(acquisitioncard);
    }

    @Override
    public void  updateAcquisitioncardById(Acquisitioncard acquisitioncard) {
        acquisitioncardMapper.updateAcquisitioncardById(acquisitioncard);
    }

    @Override
    public List<Acquisitioncard> selectAcquisitioncardList(Map<String, Object> param) {
        return acquisitioncardMapper.selectAcquisitioncardList(param);
    }

    @Override
    public PageInfo<Acquisitioncard> getAcquisitioncardPageTurn(Map<String, Object> param, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize, true);
        List<Acquisitioncard> acquisitioncardList = acquisitioncardMapper.selectAcquisitioncardList(param);
        PageInfo<Acquisitioncard> pageInfo = new PageInfo<Acquisitioncard>(acquisitioncardList);
        return pageInfo;
    }

    @Override
    public Acquisitioncard getAcquisitioncardById(String acquisitionCardCode) {
        Acquisitioncard acquisitioncardinfo = new Acquisitioncard();
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put("acquisitionCardCode", acquisitionCardCode);
        List<Acquisitioncard> acquisitioncardList = acquisitioncardMapper.selectAcquisitioncardList(rs);
        if ((null != acquisitioncardList) && (acquisitioncardList.size() > 0)) {
            acquisitioncardinfo = acquisitioncardList.get(0);
        }
        return acquisitioncardinfo;
    }

    @Override
    public void delAcquisitioncardById(String acquisitionCardCode) {

     //Acquisitioncard acquisitioncard = new Acquisitioncard();
     //acquisitioncard.setIsDeleted(1);
     //acquisitioncard.setAcquisitionCardCode(acquisitionCardCode);
     //acquisitioncardMapper.updateAcquisitioncardById(acquisitioncard);

        acquisitioncardMapper.delAcquisitioncardById(acquisitionCardCode);

    }

}
