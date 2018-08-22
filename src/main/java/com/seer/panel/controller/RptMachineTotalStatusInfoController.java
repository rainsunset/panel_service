package com.seer.panel.controller;


import com.seer.panel.model.RptMachineTotalStatusInfo;
import com.seer.panel.service.RptMachineTotalStatusInfoService;
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
 * @version $Id RptMachineTotalStatusInfoController.java, 2018-08-22 17:12:45 wuhaosoft Exp
 *
 */
@Api("机床状态运行时长统计接口")
@RestController
@RequestMapping("/panel")
public class RptMachineTotalStatusInfoController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RptMachineTotalStatusInfoService rptMachineTotalStatusInfoService;

    @ApiOperation("查询 所有 机床状态运行时长统计 分页")
    @RequestMapping(value = "/rptMachineTotalStatusInfos", method = RequestMethod.POST)
    public Object getRptMachineTotalStatusInfoPageTurn(
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
        return rptMachineTotalStatusInfoService.getRptMachineTotalStatusInfoPageTurn(rs, pageNo, pageSize);
    }

    @ApiOperation("查询 所有 机床状态运行时长统计")
    @RequestMapping(value = "/allRptMachineTotalStatusInfos", method = RequestMethod.POST)
    public JsonResult<Object> selectRptMachineTotalStatusInfoList(
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
        result.setObj(rptMachineTotalStatusInfoService.selectRptMachineTotalStatusInfoList(rs));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("新增 机床状态运行时长统计")
    @RequestMapping(value = "/rptMachineTotalStatusInfo", method = RequestMethod.POST)
    public JsonResult<Object> addRptMachineTotalStatusInfo(
                @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
                @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        RptMachineTotalStatusInfo rptMachineTotalStatusInfo = new RptMachineTotalStatusInfo();
        if (StringUtil.isNotEmpty(userId)) {
           rptMachineTotalStatusInfo.setUserId(userId);
        }
        if (null != num) {
            rptMachineTotalStatusInfo.setNum(num);
        }
        //rptMachineTotalStatusInfo.setCreatedDate(new Date());
        rptMachineTotalStatusInfoService.addRptMachineTotalStatusInfo(rptMachineTotalStatusInfo);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("更新 机床状态运行时长统计")
    @RequestMapping(value = "/rptMachineTotalStatusInfo/{rptMachineTotalStatusInfoId}", method = RequestMethod.PUT)
    public JsonResult<Object> updateRptMachineTotalStatusInfoById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  rptMachineTotalStatusInfoId,
             @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
             @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        RptMachineTotalStatusInfo rptMachineTotalStatusInfo = new RptMachineTotalStatusInfo();
        rptMachineTotalStatusInfo.setRptMachineTotalStatusInfoId(rptMachineTotalStatusInfoId);

         if (StringUtil.isNotEmpty(userId)) {
            rptMachineTotalStatusInfo.setUserId(userId);
         }
         if (null != num) {
            rptMachineTotalStatusInfo.setNum(num);
         }
        //rptMachineTotalStatusInfo.setModifiedDate(new Date());
        rptMachineTotalStatusInfoService.updateRptMachineTotalStatusInfoById(rptMachineTotalStatusInfo);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("删除 机床状态运行时长统计")
    @RequestMapping(value = "/rptMachineTotalStatusInfo/{rptMachineTotalStatusInfoId}", method = RequestMethod.DELETE)
    public JsonResult<Object> delRptMachineTotalStatusInfoById(
             @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  rptMachineTotalStatusInfoId
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        rptMachineTotalStatusInfoService.delRptMachineTotalStatusInfoById(rptMachineTotalStatusInfoId);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("查询 机床状态运行时长统计")
    @RequestMapping(value = "/rptMachineTotalStatusInfo/{rptMachineTotalStatusInfoId}", method = RequestMethod.GET)
    public JsonResult<Map<String, Object>> getRptMachineTotalStatusInfoById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  rptMachineTotalStatusInfoId) throws Exception {
        JsonResult<Map<String, Object>> result = new JsonResult<Map<String, Object>>();
        Map<String, Object> rs = new HashMap<String, Object>();
        result.setObj(rptMachineTotalStatusInfoService.getRptMachineTotalStatusInfoById(rptMachineTotalStatusInfoId));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }
}

