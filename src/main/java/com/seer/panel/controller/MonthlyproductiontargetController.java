package com.seer.panel.controller;


import com.seer.panel.model.Monthlyproductiontarget;
import com.seer.panel.service.MonthlyproductiontargetService;
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
 * @version $Id MonthlyproductiontargetController.java, 2018-08-22 17:12:44 wuhaosoft Exp
 *
 */
@Api("月度生产目标表接口")
@RestController
@RequestMapping("/panel")
public class MonthlyproductiontargetController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MonthlyproductiontargetService monthlyproductiontargetService;

    @ApiOperation("查询 所有 月度生产目标表 分页")
    @RequestMapping(value = "/monthlyproductiontargets", method = RequestMethod.POST)
    public Object getMonthlyproductiontargetPageTurn(
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
        return monthlyproductiontargetService.getMonthlyproductiontargetPageTurn(rs, pageNo, pageSize);
    }

    @ApiOperation("查询 所有 月度生产目标表")
    @RequestMapping(value = "/allMonthlyproductiontargets", method = RequestMethod.POST)
    public JsonResult<Object> selectMonthlyproductiontargetList(
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
        result.setObj(monthlyproductiontargetService.selectMonthlyproductiontargetList(rs));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("新增 月度生产目标表")
    @RequestMapping(value = "/monthlyproductiontarget", method = RequestMethod.POST)
    public JsonResult<Object> addMonthlyproductiontarget(
                @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
                @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Monthlyproductiontarget monthlyproductiontarget = new Monthlyproductiontarget();
        if (StringUtil.isNotEmpty(userId)) {
           monthlyproductiontarget.setUserId(userId);
        }
        if (null != num) {
            monthlyproductiontarget.setNum(num);
        }
        //monthlyproductiontarget.setCreatedDate(new Date());
        monthlyproductiontargetService.addMonthlyproductiontarget(monthlyproductiontarget);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("更新 月度生产目标表")
    @RequestMapping(value = "/monthlyproductiontarget/{monthlyproductiontargetId}", method = RequestMethod.PUT)
    public JsonResult<Object> updateMonthlyproductiontargetById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  monthlyproductiontargetId,
             @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
             @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Monthlyproductiontarget monthlyproductiontarget = new Monthlyproductiontarget();
        monthlyproductiontarget.setMonthlyproductiontargetId(monthlyproductiontargetId);

         if (StringUtil.isNotEmpty(userId)) {
            monthlyproductiontarget.setUserId(userId);
         }
         if (null != num) {
            monthlyproductiontarget.setNum(num);
         }
        //monthlyproductiontarget.setModifiedDate(new Date());
        monthlyproductiontargetService.updateMonthlyproductiontargetById(monthlyproductiontarget);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("删除 月度生产目标表")
    @RequestMapping(value = "/monthlyproductiontarget/{monthlyproductiontargetId}", method = RequestMethod.DELETE)
    public JsonResult<Object> delMonthlyproductiontargetById(
             @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  monthlyproductiontargetId
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        monthlyproductiontargetService.delMonthlyproductiontargetById(monthlyproductiontargetId);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("查询 月度生产目标表")
    @RequestMapping(value = "/monthlyproductiontarget/{monthlyproductiontargetId}", method = RequestMethod.GET)
    public JsonResult<Map<String, Object>> getMonthlyproductiontargetById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  monthlyproductiontargetId) throws Exception {
        JsonResult<Map<String, Object>> result = new JsonResult<Map<String, Object>>();
        Map<String, Object> rs = new HashMap<String, Object>();
        result.setObj(monthlyproductiontargetService.getMonthlyproductiontargetById(monthlyproductiontargetId));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }
}

