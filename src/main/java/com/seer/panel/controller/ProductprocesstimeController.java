package com.seer.panel.controller;


import com.seer.panel.model.Productprocesstime;
import com.seer.panel.service.ProductprocesstimeService;
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
 * @version $Id ProductprocesstimeController.java, 2018-08-22 17:12:44 wuhaosoft Exp
 *
 */
@Api("产品加工时间接口")
@RestController
@RequestMapping("/panel")
public class ProductprocesstimeController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ProductprocesstimeService productprocesstimeService;

    @ApiOperation("查询 所有 产品加工时间 分页")
    @RequestMapping(value = "/productprocesstimes", method = RequestMethod.POST)
    public Object getProductprocesstimePageTurn(
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
        return productprocesstimeService.getProductprocesstimePageTurn(rs, pageNo, pageSize);
    }

    @ApiOperation("查询 所有 产品加工时间")
    @RequestMapping(value = "/allProductprocesstimes", method = RequestMethod.POST)
    public JsonResult<Object> selectProductprocesstimeList(
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
        result.setObj(productprocesstimeService.selectProductprocesstimeList(rs));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("新增 产品加工时间")
    @RequestMapping(value = "/productprocesstime", method = RequestMethod.POST)
    public JsonResult<Object> addProductprocesstime(
                @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
                @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Productprocesstime productprocesstime = new Productprocesstime();
        if (StringUtil.isNotEmpty(userId)) {
           productprocesstime.setUserId(userId);
        }
        if (null != num) {
            productprocesstime.setNum(num);
        }
        //productprocesstime.setCreatedDate(new Date());
        productprocesstimeService.addProductprocesstime(productprocesstime);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("更新 产品加工时间")
    @RequestMapping(value = "/productprocesstime/{productprocesstimeId}", method = RequestMethod.PUT)
    public JsonResult<Object> updateProductprocesstimeById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  productprocesstimeId,
             @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
             @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Productprocesstime productprocesstime = new Productprocesstime();
        productprocesstime.setProductprocesstimeId(productprocesstimeId);

         if (StringUtil.isNotEmpty(userId)) {
            productprocesstime.setUserId(userId);
         }
         if (null != num) {
            productprocesstime.setNum(num);
         }
        //productprocesstime.setModifiedDate(new Date());
        productprocesstimeService.updateProductprocesstimeById(productprocesstime);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("删除 产品加工时间")
    @RequestMapping(value = "/productprocesstime/{productprocesstimeId}", method = RequestMethod.DELETE)
    public JsonResult<Object> delProductprocesstimeById(
             @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  productprocesstimeId
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        productprocesstimeService.delProductprocesstimeById(productprocesstimeId);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("查询 产品加工时间")
    @RequestMapping(value = "/productprocesstime/{productprocesstimeId}", method = RequestMethod.GET)
    public JsonResult<Map<String, Object>> getProductprocesstimeById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  productprocesstimeId) throws Exception {
        JsonResult<Map<String, Object>> result = new JsonResult<Map<String, Object>>();
        Map<String, Object> rs = new HashMap<String, Object>();
        result.setObj(productprocesstimeService.getProductprocesstimeById(productprocesstimeId));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }
}

