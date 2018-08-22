package com.seer.panel.controller;


import com.seer.panel.model.Machinealarmhistory;
import com.seer.panel.service.MachinealarmhistoryService;
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
 * @version $Id MachinealarmhistoryController.java, 2018-08-22 17:12:44 wuhaosoft Exp
 *
 */
@Api("机床报警历史记录接口")
@RestController
@RequestMapping("/panel")
public class MachinealarmhistoryController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MachinealarmhistoryService machinealarmhistoryService;

    @ApiOperation("查询 所有 机床报警历史记录 分页")
    @RequestMapping(value = "/machinealarmhistorys", method = RequestMethod.POST)
    public Object getMachinealarmhistoryPageTurn(
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
        return machinealarmhistoryService.getMachinealarmhistoryPageTurn(rs, pageNo, pageSize);
    }

    @ApiOperation("查询 所有 机床报警历史记录")
    @RequestMapping(value = "/allMachinealarmhistorys", method = RequestMethod.POST)
    public JsonResult<Object> selectMachinealarmhistoryList(
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
        result.setObj(machinealarmhistoryService.selectMachinealarmhistoryList(rs));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("新增 机床报警历史记录")
    @RequestMapping(value = "/machinealarmhistory", method = RequestMethod.POST)
    public JsonResult<Object> addMachinealarmhistory(
                @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
                @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Machinealarmhistory machinealarmhistory = new Machinealarmhistory();
        if (StringUtil.isNotEmpty(userId)) {
           machinealarmhistory.setUserId(userId);
        }
        if (null != num) {
            machinealarmhistory.setNum(num);
        }
        //machinealarmhistory.setCreatedDate(new Date());
        machinealarmhistoryService.addMachinealarmhistory(machinealarmhistory);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("更新 机床报警历史记录")
    @RequestMapping(value = "/machinealarmhistory/{machinealarmhistoryId}", method = RequestMethod.PUT)
    public JsonResult<Object> updateMachinealarmhistoryById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  machinealarmhistoryId,
             @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
             @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Machinealarmhistory machinealarmhistory = new Machinealarmhistory();
        machinealarmhistory.setMachinealarmhistoryId(machinealarmhistoryId);

         if (StringUtil.isNotEmpty(userId)) {
            machinealarmhistory.setUserId(userId);
         }
         if (null != num) {
            machinealarmhistory.setNum(num);
         }
        //machinealarmhistory.setModifiedDate(new Date());
        machinealarmhistoryService.updateMachinealarmhistoryById(machinealarmhistory);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("删除 机床报警历史记录")
    @RequestMapping(value = "/machinealarmhistory/{machinealarmhistoryId}", method = RequestMethod.DELETE)
    public JsonResult<Object> delMachinealarmhistoryById(
             @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  machinealarmhistoryId
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        machinealarmhistoryService.delMachinealarmhistoryById(machinealarmhistoryId);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("查询 机床报警历史记录")
    @RequestMapping(value = "/machinealarmhistory/{machinealarmhistoryId}", method = RequestMethod.GET)
    public JsonResult<Map<String, Object>> getMachinealarmhistoryById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  machinealarmhistoryId) throws Exception {
        JsonResult<Map<String, Object>> result = new JsonResult<Map<String, Object>>();
        Map<String, Object> rs = new HashMap<String, Object>();
        result.setObj(machinealarmhistoryService.getMachinealarmhistoryById(machinealarmhistoryId));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }
}

