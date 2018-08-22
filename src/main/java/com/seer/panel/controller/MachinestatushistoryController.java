package com.seer.panel.controller;


import com.seer.panel.model.Machinestatushistory;
import com.seer.panel.service.MachinestatushistoryService;
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
 * @version $Id MachinestatushistoryController.java, 2018-08-22 17:12:44 wuhaosoft Exp
 *
 */
@Api("机床状态历史记录接口")
@RestController
@RequestMapping("/panel")
public class MachinestatushistoryController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MachinestatushistoryService machinestatushistoryService;

    @ApiOperation("查询 所有 机床状态历史记录 分页")
    @RequestMapping(value = "/machinestatushistorys", method = RequestMethod.POST)
    public Object getMachinestatushistoryPageTurn(
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
        return machinestatushistoryService.getMachinestatushistoryPageTurn(rs, pageNo, pageSize);
    }

    @ApiOperation("查询 所有 机床状态历史记录")
    @RequestMapping(value = "/allMachinestatushistorys", method = RequestMethod.POST)
    public JsonResult<Object> selectMachinestatushistoryList(
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
        result.setObj(machinestatushistoryService.selectMachinestatushistoryList(rs));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("新增 机床状态历史记录")
    @RequestMapping(value = "/machinestatushistory", method = RequestMethod.POST)
    public JsonResult<Object> addMachinestatushistory(
                @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
                @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Machinestatushistory machinestatushistory = new Machinestatushistory();
        if (StringUtil.isNotEmpty(userId)) {
           machinestatushistory.setUserId(userId);
        }
        if (null != num) {
            machinestatushistory.setNum(num);
        }
        //machinestatushistory.setCreatedDate(new Date());
        machinestatushistoryService.addMachinestatushistory(machinestatushistory);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("更新 机床状态历史记录")
    @RequestMapping(value = "/machinestatushistory/{machinestatushistoryId}", method = RequestMethod.PUT)
    public JsonResult<Object> updateMachinestatushistoryById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  machinestatushistoryId,
             @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
             @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Machinestatushistory machinestatushistory = new Machinestatushistory();
        machinestatushistory.setMachinestatushistoryId(machinestatushistoryId);

         if (StringUtil.isNotEmpty(userId)) {
            machinestatushistory.setUserId(userId);
         }
         if (null != num) {
            machinestatushistory.setNum(num);
         }
        //machinestatushistory.setModifiedDate(new Date());
        machinestatushistoryService.updateMachinestatushistoryById(machinestatushistory);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("删除 机床状态历史记录")
    @RequestMapping(value = "/machinestatushistory/{machinestatushistoryId}", method = RequestMethod.DELETE)
    public JsonResult<Object> delMachinestatushistoryById(
             @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  machinestatushistoryId
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        machinestatushistoryService.delMachinestatushistoryById(machinestatushistoryId);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("查询 机床状态历史记录")
    @RequestMapping(value = "/machinestatushistory/{machinestatushistoryId}", method = RequestMethod.GET)
    public JsonResult<Map<String, Object>> getMachinestatushistoryById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  machinestatushistoryId) throws Exception {
        JsonResult<Map<String, Object>> result = new JsonResult<Map<String, Object>>();
        Map<String, Object> rs = new HashMap<String, Object>();
        result.setObj(machinestatushistoryService.getMachinestatushistoryById(machinestatushistoryId));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }
}

