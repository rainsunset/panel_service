package com.seer.panel.controller;


import com.seer.panel.model.Acquisitioncardrunlog;
import com.seer.panel.service.AcquisitioncardrunlogService;
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
 * @version $Id AcquisitioncardrunlogController.java, 2018-08-22 17:12:43 wuhaosoft Exp
 *
 */
@Api("采集卡运行状态接口")
@RestController
@RequestMapping("/panel")
public class AcquisitioncardrunlogController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AcquisitioncardrunlogService acquisitioncardrunlogService;

    @ApiOperation("查询 所有 采集卡运行状态 分页")
    @RequestMapping(value = "/acquisitioncardrunlogs", method = RequestMethod.POST)
    public Object getAcquisitioncardrunlogPageTurn(
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
        return acquisitioncardrunlogService.getAcquisitioncardrunlogPageTurn(rs, pageNo, pageSize);
    }

    @ApiOperation("查询 所有 采集卡运行状态")
    @RequestMapping(value = "/allAcquisitioncardrunlogs", method = RequestMethod.POST)
    public JsonResult<Object> selectAcquisitioncardrunlogList(
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
        result.setObj(acquisitioncardrunlogService.selectAcquisitioncardrunlogList(rs));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("新增 采集卡运行状态")
    @RequestMapping(value = "/acquisitioncardrunlog", method = RequestMethod.POST)
    public JsonResult<Object> addAcquisitioncardrunlog(
                @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
                @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Acquisitioncardrunlog acquisitioncardrunlog = new Acquisitioncardrunlog();
        if (StringUtil.isNotEmpty(userId)) {
           acquisitioncardrunlog.setUserId(userId);
        }
        if (null != num) {
            acquisitioncardrunlog.setNum(num);
        }
        //acquisitioncardrunlog.setCreatedDate(new Date());
        acquisitioncardrunlogService.addAcquisitioncardrunlog(acquisitioncardrunlog);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("更新 采集卡运行状态")
    @RequestMapping(value = "/acquisitioncardrunlog/{acquisitioncardrunlogId}", method = RequestMethod.PUT)
    public JsonResult<Object> updateAcquisitioncardrunlogById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  acquisitioncardrunlogId,
             @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
             @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Acquisitioncardrunlog acquisitioncardrunlog = new Acquisitioncardrunlog();
        acquisitioncardrunlog.setAcquisitioncardrunlogId(acquisitioncardrunlogId);

         if (StringUtil.isNotEmpty(userId)) {
            acquisitioncardrunlog.setUserId(userId);
         }
         if (null != num) {
            acquisitioncardrunlog.setNum(num);
         }
        //acquisitioncardrunlog.setModifiedDate(new Date());
        acquisitioncardrunlogService.updateAcquisitioncardrunlogById(acquisitioncardrunlog);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("删除 采集卡运行状态")
    @RequestMapping(value = "/acquisitioncardrunlog/{acquisitioncardrunlogId}", method = RequestMethod.DELETE)
    public JsonResult<Object> delAcquisitioncardrunlogById(
             @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  acquisitioncardrunlogId
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        acquisitioncardrunlogService.delAcquisitioncardrunlogById(acquisitioncardrunlogId);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("查询 采集卡运行状态")
    @RequestMapping(value = "/acquisitioncardrunlog/{acquisitioncardrunlogId}", method = RequestMethod.GET)
    public JsonResult<Map<String, Object>> getAcquisitioncardrunlogById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  acquisitioncardrunlogId) throws Exception {
        JsonResult<Map<String, Object>> result = new JsonResult<Map<String, Object>>();
        Map<String, Object> rs = new HashMap<String, Object>();
        result.setObj(acquisitioncardrunlogService.getAcquisitioncardrunlogById(acquisitioncardrunlogId));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }
}

