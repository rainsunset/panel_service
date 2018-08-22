package com.seer.panel.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.seer.panel.common.BaseService;
import com.seer.panel.model.Productprocesstimehistory;
import com.seer.panel.mapper.ProductprocesstimehistoryMapper;
import com.seer.panel.service.ProductprocesstimehistoryService;
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
public class ProductprocesstimehistoryServiceImpl extends BaseService implements ProductprocesstimehistoryService {

    @Autowired
    private ProductprocesstimehistoryMapper productprocesstimehistoryMapper;

    @Override
    public void  addProductprocesstimehistory(Productprocesstimehistory productprocesstimehistory) {
        productprocesstimehistoryMapper.addProductprocesstimehistory(productprocesstimehistory);
    }

    @Override
    public void  updateProductprocesstimehistoryById(Productprocesstimehistory productprocesstimehistory) {
        productprocesstimehistoryMapper.updateProductprocesstimehistoryById(productprocesstimehistory);
    }

    @Override
    public List<Productprocesstimehistory> selectProductprocesstimehistoryList(Map<String, Object> param) {
        return productprocesstimehistoryMapper.selectProductprocesstimehistoryList(param);
    }

    @Override
    public PageInfo<Productprocesstimehistory> getProductprocesstimehistoryPageTurn(Map<String, Object> param, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize, true);
        List<Productprocesstimehistory> productprocesstimehistoryList = productprocesstimehistoryMapper.selectProductprocesstimehistoryList(param);
        PageInfo<Productprocesstimehistory> pageInfo = new PageInfo<Productprocesstimehistory>(productprocesstimehistoryList);
        return pageInfo;
    }

    @Override
    public Productprocesstimehistory getProductprocesstimehistoryById(Integer productprocesstimehistoryId) {
        Productprocesstimehistory productprocesstimehistoryinfo = new Productprocesstimehistory();
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put("productprocesstimehistoryId", productprocesstimehistoryId);
        List<Productprocesstimehistory> productprocesstimehistoryList = productprocesstimehistoryMapper.selectProductprocesstimehistoryList(rs);
        if ((null != productprocesstimehistoryList) && (productprocesstimehistoryList.size() > 0)) {
            productprocesstimehistoryinfo = productprocesstimehistoryList.get(0);
        }
        return productprocesstimehistoryinfo;
    }

    @Override
    public void delProductprocesstimehistoryById(Integer productprocesstimehistoryId) {

     //Productprocesstimehistory productprocesstimehistory = new Productprocesstimehistory();
     //productprocesstimehistory.setIsDeleted(1);
     //productprocesstimehistory.setProductprocesstimehistoryId(productprocesstimehistoryId);
     //productprocesstimehistoryMapper.updateProductprocesstimehistoryById(productprocesstimehistory);

        productprocesstimehistoryMapper.delProductprocesstimehistoryById(productprocesstimehistoryId);

    }

}
