package com.seer.panel.controller;


import com.seer.panel.model.Sensorinfo;
import com.seer.panel.service.SensorinfoService;
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
 * @version $Id SensorinfoController.java, 2018-08-22 17:12:45 wuhaosoft Exp
 *
 */
@Api("传感器信息接口")
@RestController
@RequestMapping("/panel")
public class SensorinfoController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SensorinfoService sensorinfoService;

    @ApiOperation("查询 所有 传感器信息 分页")
    @RequestMapping(value = "/sensorinfos", method = RequestMethod.POST)
    public Object getSensorinfoPageTurn(
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
        return sensorinfoService.getSensorinfoPageTurn(rs, pageNo, pageSize);
    }

    @ApiOperation("查询 所有 传感器信息")
    @RequestMapping(value = "/allSensorinfos", method = RequestMethod.POST)
    public JsonResult<Object> selectSensorinfoList(
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
        result.setObj(sensorinfoService.selectSensorinfoList(rs));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("新增 传感器信息")
    @RequestMapping(value = "/sensorinfo", method = RequestMethod.POST)
    public JsonResult<Object> addSensorinfo(
                @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
                @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Sensorinfo sensorinfo = new Sensorinfo();
        if (StringUtil.isNotEmpty(userId)) {
           sensorinfo.setUserId(userId);
        }
        if (null != num) {
            sensorinfo.setNum(num);
        }
        //sensorinfo.setCreatedDate(new Date());
        sensorinfoService.addSensorinfo(sensorinfo);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("更新 传感器信息")
    @RequestMapping(value = "/sensorinfo/{sensorinfoId}", method = RequestMethod.PUT)
    public JsonResult<Object> updateSensorinfoById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  sensorinfoId,
             @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
             @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Sensorinfo sensorinfo = new Sensorinfo();
        sensorinfo.setSensorinfoId(sensorinfoId);

         if (StringUtil.isNotEmpty(userId)) {
            sensorinfo.setUserId(userId);
         }
         if (null != num) {
            sensorinfo.setNum(num);
         }
        //sensorinfo.setModifiedDate(new Date());
        sensorinfoService.updateSensorinfoById(sensorinfo);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("删除 传感器信息")
    @RequestMapping(value = "/sensorinfo/{sensorinfoId}", method = RequestMethod.DELETE)
    public JsonResult<Object> delSensorinfoById(
             @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  sensorinfoId
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        sensorinfoService.delSensorinfoById(sensorinfoId);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("查询 传感器信息")
    @RequestMapping(value = "/sensorinfo/{sensorinfoId}", method = RequestMethod.GET)
    public JsonResult<Map<String, Object>> getSensorinfoById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  sensorinfoId) throws Exception {
        JsonResult<Map<String, Object>> result = new JsonResult<Map<String, Object>>();
        Map<String, Object> rs = new HashMap<String, Object>();
        result.setObj(sensorinfoService.getSensorinfoById(sensorinfoId));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }
}

