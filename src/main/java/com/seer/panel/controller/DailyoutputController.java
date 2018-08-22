package com.seer.panel.controller;


import com.seer.panel.model.Dailyoutput;
import com.seer.panel.service.DailyoutputService;
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
 * @version $Id DailyoutputController.java, 2018-08-22 17:12:43 wuhaosoft Exp
 *
 */
@Api("日产量表接口")
@RestController
@RequestMapping("/panel")
public class DailyoutputController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DailyoutputService dailyoutputService;

    @ApiOperation("查询 所有 日产量表 分页")
    @RequestMapping(value = "/dailyoutputs", method = RequestMethod.POST)
    public Object getDailyoutputPageTurn(
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
        return dailyoutputService.getDailyoutputPageTurn(rs, pageNo, pageSize);
    }

    @ApiOperation("查询 所有 日产量表")
    @RequestMapping(value = "/allDailyoutputs", method = RequestMethod.POST)
    public JsonResult<Object> selectDailyoutputList(
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
        result.setObj(dailyoutputService.selectDailyoutputList(rs));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("新增 日产量表")
    @RequestMapping(value = "/dailyoutput", method = RequestMethod.POST)
    public JsonResult<Object> addDailyoutput(
                @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
                @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Dailyoutput dailyoutput = new Dailyoutput();
        if (StringUtil.isNotEmpty(userId)) {
           dailyoutput.setUserId(userId);
        }
        if (null != num) {
            dailyoutput.setNum(num);
        }
        //dailyoutput.setCreatedDate(new Date());
        dailyoutputService.addDailyoutput(dailyoutput);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("更新 日产量表")
    @RequestMapping(value = "/dailyoutput/{dailyoutputId}", method = RequestMethod.PUT)
    public JsonResult<Object> updateDailyoutputById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  dailyoutputId,
             @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
             @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Dailyoutput dailyoutput = new Dailyoutput();
        dailyoutput.setDailyoutputId(dailyoutputId);

         if (StringUtil.isNotEmpty(userId)) {
            dailyoutput.setUserId(userId);
         }
         if (null != num) {
            dailyoutput.setNum(num);
         }
        //dailyoutput.setModifiedDate(new Date());
        dailyoutputService.updateDailyoutputById(dailyoutput);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("删除 日产量表")
    @RequestMapping(value = "/dailyoutput/{dailyoutputId}", method = RequestMethod.DELETE)
    public JsonResult<Object> delDailyoutputById(
             @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  dailyoutputId
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        dailyoutputService.delDailyoutputById(dailyoutputId);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("查询 日产量表")
    @RequestMapping(value = "/dailyoutput/{dailyoutputId}", method = RequestMethod.GET)
    public JsonResult<Map<String, Object>> getDailyoutputById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  dailyoutputId) throws Exception {
        JsonResult<Map<String, Object>> result = new JsonResult<Map<String, Object>>();
        Map<String, Object> rs = new HashMap<String, Object>();
        result.setObj(dailyoutputService.getDailyoutputById(dailyoutputId));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }
}

