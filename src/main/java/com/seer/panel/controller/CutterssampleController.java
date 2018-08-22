package com.seer.panel.controller;


import com.seer.panel.model.Cutterssample;
import com.seer.panel.service.CutterssampleService;
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
 * @version $Id CutterssampleController.java, 2018-08-22 17:12:43 wuhaosoft Exp
 *
 */
@Api("断刀样本接口")
@RestController
@RequestMapping("/panel")
public class CutterssampleController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CutterssampleService cutterssampleService;

    @ApiOperation("查询 所有 断刀样本 分页")
    @RequestMapping(value = "/cutterssamples", method = RequestMethod.POST)
    public Object getCutterssamplePageTurn(
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
        return cutterssampleService.getCutterssamplePageTurn(rs, pageNo, pageSize);
    }

    @ApiOperation("查询 所有 断刀样本")
    @RequestMapping(value = "/allCutterssamples", method = RequestMethod.POST)
    public JsonResult<Object> selectCutterssampleList(
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
        result.setObj(cutterssampleService.selectCutterssampleList(rs));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("新增 断刀样本")
    @RequestMapping(value = "/cutterssample", method = RequestMethod.POST)
    public JsonResult<Object> addCutterssample(
                @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
                @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Cutterssample cutterssample = new Cutterssample();
        if (StringUtil.isNotEmpty(userId)) {
           cutterssample.setUserId(userId);
        }
        if (null != num) {
            cutterssample.setNum(num);
        }
        //cutterssample.setCreatedDate(new Date());
        cutterssampleService.addCutterssample(cutterssample);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("更新 断刀样本")
    @RequestMapping(value = "/cutterssample/{cutterssampleId}", method = RequestMethod.PUT)
    public JsonResult<Object> updateCutterssampleById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  cutterssampleId,
             @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
             @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Cutterssample cutterssample = new Cutterssample();
        cutterssample.setCutterssampleId(cutterssampleId);

         if (StringUtil.isNotEmpty(userId)) {
            cutterssample.setUserId(userId);
         }
         if (null != num) {
            cutterssample.setNum(num);
         }
        //cutterssample.setModifiedDate(new Date());
        cutterssampleService.updateCutterssampleById(cutterssample);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("删除 断刀样本")
    @RequestMapping(value = "/cutterssample/{cutterssampleId}", method = RequestMethod.DELETE)
    public JsonResult<Object> delCutterssampleById(
             @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  cutterssampleId
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        cutterssampleService.delCutterssampleById(cutterssampleId);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("查询 断刀样本")
    @RequestMapping(value = "/cutterssample/{cutterssampleId}", method = RequestMethod.GET)
    public JsonResult<Map<String, Object>> getCutterssampleById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  cutterssampleId) throws Exception {
        JsonResult<Map<String, Object>> result = new JsonResult<Map<String, Object>>();
        Map<String, Object> rs = new HashMap<String, Object>();
        result.setObj(cutterssampleService.getCutterssampleById(cutterssampleId));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }
}

