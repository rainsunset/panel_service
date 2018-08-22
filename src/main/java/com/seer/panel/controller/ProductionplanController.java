package com.seer.panel.controller;


import com.seer.panel.model.Productionplan;
import com.seer.panel.service.ProductionplanService;
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
 * @version $Id ProductionplanController.java, 2018-08-22 17:12:44 wuhaosoft Exp
 *
 */
@Api("生产计划接口")
@RestController
@RequestMapping("/panel")
public class ProductionplanController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ProductionplanService productionplanService;

    @ApiOperation("查询 所有 生产计划 分页")
    @RequestMapping(value = "/productionplans", method = RequestMethod.POST)
    public Object getProductionplanPageTurn(
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
        return productionplanService.getProductionplanPageTurn(rs, pageNo, pageSize);
    }

    @ApiOperation("查询 所有 生产计划")
    @RequestMapping(value = "/allProductionplans", method = RequestMethod.POST)
    public JsonResult<Object> selectProductionplanList(
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
        result.setObj(productionplanService.selectProductionplanList(rs));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("新增 生产计划")
    @RequestMapping(value = "/productionplan", method = RequestMethod.POST)
    public JsonResult<Object> addProductionplan(
                @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
                @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Productionplan productionplan = new Productionplan();
        if (StringUtil.isNotEmpty(userId)) {
           productionplan.setUserId(userId);
        }
        if (null != num) {
            productionplan.setNum(num);
        }
        //productionplan.setCreatedDate(new Date());
        productionplanService.addProductionplan(productionplan);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("更新 生产计划")
    @RequestMapping(value = "/productionplan/{productionplanId}", method = RequestMethod.PUT)
    public JsonResult<Object> updateProductionplanById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  productionplanId,
             @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
             @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Productionplan productionplan = new Productionplan();
        productionplan.setProductionplanId(productionplanId);

         if (StringUtil.isNotEmpty(userId)) {
            productionplan.setUserId(userId);
         }
         if (null != num) {
            productionplan.setNum(num);
         }
        //productionplan.setModifiedDate(new Date());
        productionplanService.updateProductionplanById(productionplan);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("删除 生产计划")
    @RequestMapping(value = "/productionplan/{productionplanId}", method = RequestMethod.DELETE)
    public JsonResult<Object> delProductionplanById(
             @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  productionplanId
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        productionplanService.delProductionplanById(productionplanId);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("查询 生产计划")
    @RequestMapping(value = "/productionplan/{productionplanId}", method = RequestMethod.GET)
    public JsonResult<Map<String, Object>> getProductionplanById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  productionplanId) throws Exception {
        JsonResult<Map<String, Object>> result = new JsonResult<Map<String, Object>>();
        Map<String, Object> rs = new HashMap<String, Object>();
        result.setObj(productionplanService.getProductionplanById(productionplanId));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }
}

