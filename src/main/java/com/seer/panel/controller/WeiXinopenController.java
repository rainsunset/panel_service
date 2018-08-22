package com.seer.panel.controller;


import com.seer.panel.model.WeiXinopen;
import com.seer.panel.service.WeiXinopenService;
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
 * @version $Id WeiXinopenController.java, 2018-08-22 17:12:45 wuhaosoft Exp
 *
 */
@Api("微信用户表接口")
@RestController
@RequestMapping("/panel")
public class WeiXinopenController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WeiXinopenService weiXinopenService;

    @ApiOperation("查询 所有 微信用户表 分页")
    @RequestMapping(value = "/weiXinopens", method = RequestMethod.POST)
    public Object getWeiXinopenPageTurn(
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
        return weiXinopenService.getWeiXinopenPageTurn(rs, pageNo, pageSize);
    }

    @ApiOperation("查询 所有 微信用户表")
    @RequestMapping(value = "/allWeiXinopens", method = RequestMethod.POST)
    public JsonResult<Object> selectWeiXinopenList(
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
        result.setObj(weiXinopenService.selectWeiXinopenList(rs));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("新增 微信用户表")
    @RequestMapping(value = "/weiXinopen", method = RequestMethod.POST)
    public JsonResult<Object> addWeiXinopen(
                @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
                @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        WeiXinopen weiXinopen = new WeiXinopen();
        if (StringUtil.isNotEmpty(userId)) {
           weiXinopen.setUserId(userId);
        }
        if (null != num) {
            weiXinopen.setNum(num);
        }
        //weiXinopen.setCreatedDate(new Date());
        weiXinopenService.addWeiXinopen(weiXinopen);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("更新 微信用户表")
    @RequestMapping(value = "/weiXinopen/{weiXinopenId}", method = RequestMethod.PUT)
    public JsonResult<Object> updateWeiXinopenById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  weiXinopenId,
             @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
             @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        WeiXinopen weiXinopen = new WeiXinopen();
        weiXinopen.setWeiXinopenId(weiXinopenId);

         if (StringUtil.isNotEmpty(userId)) {
            weiXinopen.setUserId(userId);
         }
         if (null != num) {
            weiXinopen.setNum(num);
         }
        //weiXinopen.setModifiedDate(new Date());
        weiXinopenService.updateWeiXinopenById(weiXinopen);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("删除 微信用户表")
    @RequestMapping(value = "/weiXinopen/{weiXinopenId}", method = RequestMethod.DELETE)
    public JsonResult<Object> delWeiXinopenById(
             @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  weiXinopenId
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        weiXinopenService.delWeiXinopenById(weiXinopenId);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("查询 微信用户表")
    @RequestMapping(value = "/weiXinopen/{weiXinopenId}", method = RequestMethod.GET)
    public JsonResult<Map<String, Object>> getWeiXinopenById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  weiXinopenId) throws Exception {
        JsonResult<Map<String, Object>> result = new JsonResult<Map<String, Object>>();
        Map<String, Object> rs = new HashMap<String, Object>();
        result.setObj(weiXinopenService.getWeiXinopenById(weiXinopenId));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }
}

