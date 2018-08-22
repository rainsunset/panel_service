package com.seer.panel.controller;


import com.seer.panel.model.SysRunLoginfo;
import com.seer.panel.service.SysRunLoginfoService;
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
 * @version $Id SysRunLoginfoController.java, 2018-08-22 17:12:45 wuhaosoft Exp
 *
 */
@Api("系统日志表接口")
@RestController
@RequestMapping("/panel")
public class SysRunLoginfoController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SysRunLoginfoService sysRunLoginfoService;

    @ApiOperation("查询 所有 系统日志表 分页")
    @RequestMapping(value = "/sysRunLoginfos", method = RequestMethod.POST)
    public Object getSysRunLoginfoPageTurn(
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
        return sysRunLoginfoService.getSysRunLoginfoPageTurn(rs, pageNo, pageSize);
    }

    @ApiOperation("查询 所有 系统日志表")
    @RequestMapping(value = "/allSysRunLoginfos", method = RequestMethod.POST)
    public JsonResult<Object> selectSysRunLoginfoList(
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
        result.setObj(sysRunLoginfoService.selectSysRunLoginfoList(rs));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("新增 系统日志表")
    @RequestMapping(value = "/sysRunLoginfo", method = RequestMethod.POST)
    public JsonResult<Object> addSysRunLoginfo(
                @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
                @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        SysRunLoginfo sysRunLoginfo = new SysRunLoginfo();
        if (StringUtil.isNotEmpty(userId)) {
           sysRunLoginfo.setUserId(userId);
        }
        if (null != num) {
            sysRunLoginfo.setNum(num);
        }
        //sysRunLoginfo.setCreatedDate(new Date());
        sysRunLoginfoService.addSysRunLoginfo(sysRunLoginfo);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("更新 系统日志表")
    @RequestMapping(value = "/sysRunLoginfo/{sysRunLoginfoId}", method = RequestMethod.PUT)
    public JsonResult<Object> updateSysRunLoginfoById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  sysRunLoginfoId,
             @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
             @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        SysRunLoginfo sysRunLoginfo = new SysRunLoginfo();
        sysRunLoginfo.setSysRunLoginfoId(sysRunLoginfoId);

         if (StringUtil.isNotEmpty(userId)) {
            sysRunLoginfo.setUserId(userId);
         }
         if (null != num) {
            sysRunLoginfo.setNum(num);
         }
        //sysRunLoginfo.setModifiedDate(new Date());
        sysRunLoginfoService.updateSysRunLoginfoById(sysRunLoginfo);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("删除 系统日志表")
    @RequestMapping(value = "/sysRunLoginfo/{sysRunLoginfoId}", method = RequestMethod.DELETE)
    public JsonResult<Object> delSysRunLoginfoById(
             @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  sysRunLoginfoId
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        sysRunLoginfoService.delSysRunLoginfoById(sysRunLoginfoId);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("查询 系统日志表")
    @RequestMapping(value = "/sysRunLoginfo/{sysRunLoginfoId}", method = RequestMethod.GET)
    public JsonResult<Map<String, Object>> getSysRunLoginfoById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  sysRunLoginfoId) throws Exception {
        JsonResult<Map<String, Object>> result = new JsonResult<Map<String, Object>>();
        Map<String, Object> rs = new HashMap<String, Object>();
        result.setObj(sysRunLoginfoService.getSysRunLoginfoById(sysRunLoginfoId));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }
}

