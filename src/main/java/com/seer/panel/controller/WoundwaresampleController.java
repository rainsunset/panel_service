package com.seer.panel.controller;


import com.seer.panel.model.Woundwaresample;
import com.seer.panel.service.WoundwaresampleService;
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
 * @version $Id WoundwaresampleController.java, 2018-08-22 17:12:45 wuhaosoft Exp
 *
 */
@Api("虚拟发声波形样本数据接口")
@RestController
@RequestMapping("/panel")
public class WoundwaresampleController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WoundwaresampleService woundwaresampleService;

    @ApiOperation("查询 所有 虚拟发声波形样本数据 分页")
    @RequestMapping(value = "/woundwaresamples", method = RequestMethod.POST)
    public Object getWoundwaresamplePageTurn(
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
        return woundwaresampleService.getWoundwaresamplePageTurn(rs, pageNo, pageSize);
    }

    @ApiOperation("查询 所有 虚拟发声波形样本数据")
    @RequestMapping(value = "/allWoundwaresamples", method = RequestMethod.POST)
    public JsonResult<Object> selectWoundwaresampleList(
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
        result.setObj(woundwaresampleService.selectWoundwaresampleList(rs));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("新增 虚拟发声波形样本数据")
    @RequestMapping(value = "/woundwaresample", method = RequestMethod.POST)
    public JsonResult<Object> addWoundwaresample(
                @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
                @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Woundwaresample woundwaresample = new Woundwaresample();
        if (StringUtil.isNotEmpty(userId)) {
           woundwaresample.setUserId(userId);
        }
        if (null != num) {
            woundwaresample.setNum(num);
        }
        //woundwaresample.setCreatedDate(new Date());
        woundwaresampleService.addWoundwaresample(woundwaresample);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("更新 虚拟发声波形样本数据")
    @RequestMapping(value = "/woundwaresample/{woundwaresampleId}", method = RequestMethod.PUT)
    public JsonResult<Object> updateWoundwaresampleById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  woundwaresampleId,
             @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
             @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Woundwaresample woundwaresample = new Woundwaresample();
        woundwaresample.setWoundwaresampleId(woundwaresampleId);

         if (StringUtil.isNotEmpty(userId)) {
            woundwaresample.setUserId(userId);
         }
         if (null != num) {
            woundwaresample.setNum(num);
         }
        //woundwaresample.setModifiedDate(new Date());
        woundwaresampleService.updateWoundwaresampleById(woundwaresample);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("删除 虚拟发声波形样本数据")
    @RequestMapping(value = "/woundwaresample/{woundwaresampleId}", method = RequestMethod.DELETE)
    public JsonResult<Object> delWoundwaresampleById(
             @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  woundwaresampleId
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        woundwaresampleService.delWoundwaresampleById(woundwaresampleId);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("查询 虚拟发声波形样本数据")
    @RequestMapping(value = "/woundwaresample/{woundwaresampleId}", method = RequestMethod.GET)
    public JsonResult<Map<String, Object>> getWoundwaresampleById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  woundwaresampleId) throws Exception {
        JsonResult<Map<String, Object>> result = new JsonResult<Map<String, Object>>();
        Map<String, Object> rs = new HashMap<String, Object>();
        result.setObj(woundwaresampleService.getWoundwaresampleById(woundwaresampleId));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }
}

