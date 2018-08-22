package com.seer.panel.controller;


import com.seer.panel.model.Productprocesstimehistory;
import com.seer.panel.service.ProductprocesstimehistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author wuhaosoft
 * @version $Id ProductprocesstimehistoryController.java, 2018-08-22 17:12:44 wuhaosoft Exp
 *
 */
@Api("产品加工时间历史接口")
@RestController
@RequestMapping("/panel")
public class ProductprocesstimehistoryController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ProductprocesstimehistoryService productprocesstimehistoryService;

    @ApiOperation("查询 所有 产品加工时间历史 分页")
    @RequestMapping(value = "/productprocesstimehistorys", method = RequestMethod.POST)
    public Object getProductprocesstimehistoryPageTurn(
            @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
            @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num,
            @ApiParam(value = "页码(必传)") @RequestParam Integer pageNo,
            @ApiParam(value = "每页显示多少数据(必传)") @RequestParam Integer pageSize) throws Exception {
        Map<String, Object> rs = new HashMap<String, Object>();
        if (StringUtil.isNotEmpty(userId)) {
           rs.put("userId", "%" + userId + "%");
        }
        if (null != num) {
           rs.put("num", num);
        }
        return productprocesstimehistoryService.getProductprocesstimehistoryPageTurn(rs, pageNo, pageSize);
    }

    @ApiOperation("查询 所有 产品加工时间历史")
    @RequestMapping(value = "/allProductprocesstimehistorys", method = RequestMethod.POST)
    public JsonResult<Object> selectProductprocesstimehistoryList(
        @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
        @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
        )throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Map<String, Object> rs = new HashMap<String, Object>();
         if (StringUtil.isNotEmpty(userId)) {
            rs.put("userId", "%" + userId + "%");
         }
        if (null != num) {
            rs.put("num", num);
        }
        result.setObj(productprocesstimehistoryService.selectProductprocesstimehistoryList(rs));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("新增 产品加工时间历史")
    @RequestMapping(value = "/productprocesstimehistory", method = RequestMethod.POST)
    public JsonResult<Object> addProductprocesstimehistory(
                @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
                @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Productprocesstimehistory productprocesstimehistory = new Productprocesstimehistory();
        if (StringUtil.isNotEmpty(userId)) {
           productprocesstimehistory.setUserId(userId);
        }
        if (null != num) {
            productprocesstimehistory.setNum(num);
        }
        //productprocesstimehistory.setCreatedDate(new Date());
        productprocesstimehistoryService.addProductprocesstimehistory(productprocesstimehistory);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("更新 产品加工时间历史")
    @RequestMapping(value = "/productprocesstimehistory/{productprocesstimehistoryId}", method = RequestMethod.PUT)
    public JsonResult<Object> updateProductprocesstimehistoryById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  productprocesstimehistoryId,
             @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
             @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Productprocesstimehistory productprocesstimehistory = new Productprocesstimehistory();
        productprocesstimehistory.setProductprocesstimehistoryId(productprocesstimehistoryId);

         if (StringUtil.isNotEmpty(userId)) {
            productprocesstimehistory.setUserId(userId);
         }
         if (null != num) {
            productprocesstimehistory.setNum(num);
         }
        //productprocesstimehistory.setModifiedDate(new Date());
        productprocesstimehistoryService.updateProductprocesstimehistoryById(productprocesstimehistory);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("删除 产品加工时间历史")
    @RequestMapping(value = "/productprocesstimehistory/{productprocesstimehistoryId}", method = RequestMethod.DELETE)
    public JsonResult<Object> delProductprocesstimehistoryById(
             @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  productprocesstimehistoryId
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        productprocesstimehistoryService.delProductprocesstimehistoryById(productprocesstimehistoryId);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("查询 产品加工时间历史")
    @RequestMapping(value = "/productprocesstimehistory/{productprocesstimehistoryId}", method = RequestMethod.GET)
    public JsonResult<Map<String, Object>> getProductprocesstimehistoryById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  productprocesstimehistoryId) throws Exception {
        JsonResult<Map<String, Object>> result = new JsonResult<Map<String, Object>>();
        Map<String, Object> rs = new HashMap<String, Object>();
        result.setObj(productprocesstimehistoryService.getProductprocesstimehistoryById(productprocesstimehistoryId));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }
}

