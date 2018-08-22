package com.seer.panel.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.seer.panel.common.BaseService;
import com.seer.panel.model.Productprocesstime;
import com.seer.panel.mapper.ProductprocesstimeMapper;
import com.seer.panel.service.ProductprocesstimeService;
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
public class ProductprocesstimeServiceImpl extends BaseService implements ProductprocesstimeService {

    @Autowired
    private ProductprocesstimeMapper productprocesstimeMapper;

    @Override
    public void  addProductprocesstime(Productprocesstime productprocesstime) {
        productprocesstimeMapper.addProductprocesstime(productprocesstime);
    }

    @Override
    public void  updateProductprocesstimeById(Productprocesstime productprocesstime) {
        productprocesstimeMapper.updateProductprocesstimeById(productprocesstime);
    }

    @Override
    public List<Productprocesstime> selectProductprocesstimeList(Map<String, Object> param) {
        return productprocesstimeMapper.selectProductprocesstimeList(param);
    }

    @Override
    public PageInfo<Productprocesstime> getProductprocesstimePageTurn(Map<String, Object> param, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize, true);
        List<Productprocesstime> productprocesstimeList = productprocesstimeMapper.selectProductprocesstimeList(param);
        PageInfo<Productprocesstime> pageInfo = new PageInfo<Productprocesstime>(productprocesstimeList);
        return pageInfo;
    }

    @Override
    public Productprocesstime getProductprocesstimeById(Integer productprocesstimeId) {
        Productprocesstime productprocesstimeinfo = new Productprocesstime();
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put("productprocesstimeId", productprocesstimeId);
        List<Productprocesstime> productprocesstimeList = productprocesstimeMapper.selectProductprocesstimeList(rs);
        if ((null != productprocesstimeList) && (productprocesstimeList.size() > 0)) {
            productprocesstimeinfo = productprocesstimeList.get(0);
        }
        return productprocesstimeinfo;
    }

    @Override
    public void delProductprocesstimeById(Integer productprocesstimeId) {

     //Productprocesstime productprocesstime = new Productprocesstime();
     //productprocesstime.setIsDeleted(1);
     //productprocesstime.setProductprocesstimeId(productprocesstimeId);
     //productprocesstimeMapper.updateProductprocesstimeById(productprocesstime);

        productprocesstimeMapper.delProductprocesstimeById(productprocesstimeId);

    }

}
