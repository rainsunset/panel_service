package com.seer.panel.controller;


import com.seer.panel.model.Machineinfo;
import com.seer.panel.service.MachineinfoService;
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
 * @version $Id MachineinfoController.java, 2018-08-22 17:12:44 wuhaosoft Exp
 *
 */
@Api("机床信息表接口")
@RestController
@RequestMapping("/panel")
public class MachineinfoController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MachineinfoService machineinfoService;

    @ApiOperation("查询 所有 机床信息表 分页")
    @RequestMapping(value = "/machineinfos", method = RequestMethod.POST)
    public Object getMachineinfoPageTurn(
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
        return machineinfoService.getMachineinfoPageTurn(rs, pageNo, pageSize);
    }

    @ApiOperation("查询 所有 机床信息表")
    @RequestMapping(value = "/allMachineinfos", method = RequestMethod.POST)
    public JsonResult<Object> selectMachineinfoList(
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
        result.setObj(machineinfoService.selectMachineinfoList(rs));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("新增 机床信息表")
    @RequestMapping(value = "/machineinfo", method = RequestMethod.POST)
    public JsonResult<Object> addMachineinfo(
                @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
                @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Machineinfo machineinfo = new Machineinfo();
        if (StringUtil.isNotEmpty(userId)) {
           machineinfo.setUserId(userId);
        }
        if (null != num) {
            machineinfo.setNum(num);
        }
        //machineinfo.setCreatedDate(new Date());
        machineinfoService.addMachineinfo(machineinfo);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("更新 机床信息表")
    @RequestMapping(value = "/machineinfo/{machineinfoId}", method = RequestMethod.PUT)
    public JsonResult<Object> updateMachineinfoById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  machineinfoId,
             @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
             @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Machineinfo machineinfo = new Machineinfo();
        machineinfo.setMachineinfoId(machineinfoId);

         if (StringUtil.isNotEmpty(userId)) {
            machineinfo.setUserId(userId);
         }
         if (null != num) {
            machineinfo.setNum(num);
         }
        //machineinfo.setModifiedDate(new Date());
        machineinfoService.updateMachineinfoById(machineinfo);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("删除 机床信息表")
    @RequestMapping(value = "/machineinfo/{machineinfoId}", method = RequestMethod.DELETE)
    public JsonResult<Object> delMachineinfoById(
             @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  machineinfoId
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        machineinfoService.delMachineinfoById(machineinfoId);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("查询 机床信息表")
    @RequestMapping(value = "/machineinfo/{machineinfoId}", method = RequestMethod.GET)
    public JsonResult<Map<String, Object>> getMachineinfoById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  machineinfoId) throws Exception {
        JsonResult<Map<String, Object>> result = new JsonResult<Map<String, Object>>();
        Map<String, Object> rs = new HashMap<String, Object>();
        result.setObj(machineinfoService.getMachineinfoById(machineinfoId));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }
}

