package com.seer.panel.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.seer.panel.common.BaseService;
import com.seer.panel.model.Productionplan;
import com.seer.panel.mapper.ProductionplanMapper;
import com.seer.panel.service.ProductionplanService;
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
public class ProductionplanServiceImpl extends BaseService implements ProductionplanService {

    @Autowired
    private ProductionplanMapper productionplanMapper;

    @Override
    public void  addProductionplan(Productionplan productionplan) {
        productionplanMapper.addProductionplan(productionplan);
    }

    @Override
    public void  updateProductionplanById(Productionplan productionplan) {
        productionplanMapper.updateProductionplanById(productionplan);
    }

    @Override
    public List<Productionplan> selectProductionplanList(Map<String, Object> param) {
        return productionplanMapper.selectProductionplanList(param);
    }

    @Override
    public PageInfo<Productionplan> getProductionplanPageTurn(Map<String, Object> param, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize, true);
        List<Productionplan> productionplanList = productionplanMapper.selectProductionplanList(param);
        PageInfo<Productionplan> pageInfo = new PageInfo<Productionplan>(productionplanList);
        return pageInfo;
    }

    @Override
    public Productionplan getProductionplanById(Integer productionplanId) {
        Productionplan productionplaninfo = new Productionplan();
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put("productionplanId", productionplanId);
        List<Productionplan> productionplanList = productionplanMapper.selectProductionplanList(rs);
        if ((null != productionplanList) && (productionplanList.size() > 0)) {
            productionplaninfo = productionplanList.get(0);
        }
        return productionplaninfo;
    }

    @Override
    public void delProductionplanById(Integer productionplanId) {

     //Productionplan productionplan = new Productionplan();
     //productionplan.setIsDeleted(1);
     //productionplan.setProductionplanId(productionplanId);
     //productionplanMapper.updateProductionplanById(productionplan);

        productionplanMapper.delProductionplanById(productionplanId);

    }

}
