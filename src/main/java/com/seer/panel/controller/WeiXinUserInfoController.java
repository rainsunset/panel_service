package com.seer.panel.controller;


import com.seer.panel.model.WeiXinUserInfo;
import com.seer.panel.service.WeiXinUserInfoService;
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
 * @version $Id WeiXinUserInfoController.java, 2018-08-22 17:12:45 wuhaosoft Exp
 *
 */
@Api("用户微信帐号（OpenId）接口")
@RestController
@RequestMapping("/panel")
public class WeiXinUserInfoController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WeiXinUserInfoService weiXinUserInfoService;

    @ApiOperation("查询 所有 用户微信帐号（OpenId） 分页")
    @RequestMapping(value = "/weiXinUserInfos", method = RequestMethod.POST)
    public Object getWeiXinUserInfoPageTurn(
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
        return weiXinUserInfoService.getWeiXinUserInfoPageTurn(rs, pageNo, pageSize);
    }

    @ApiOperation("查询 所有 用户微信帐号（OpenId）")
    @RequestMapping(value = "/allWeiXinUserInfos", method = RequestMethod.POST)
    public JsonResult<Object> selectWeiXinUserInfoList(
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
        result.setObj(weiXinUserInfoService.selectWeiXinUserInfoList(rs));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("新增 用户微信帐号（OpenId）")
    @RequestMapping(value = "/weiXinUserInfo", method = RequestMethod.POST)
    public JsonResult<Object> addWeiXinUserInfo(
                @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
                @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        WeiXinUserInfo weiXinUserInfo = new WeiXinUserInfo();
        if (StringUtil.isNotEmpty(userId)) {
           weiXinUserInfo.setUserId(userId);
        }
        if (null != num) {
            weiXinUserInfo.setNum(num);
        }
        //weiXinUserInfo.setCreatedDate(new Date());
        weiXinUserInfoService.addWeiXinUserInfo(weiXinUserInfo);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("更新 用户微信帐号（OpenId）")
    @RequestMapping(value = "/weiXinUserInfo/{weiXinUserInfoId}", method = RequestMethod.PUT)
    public JsonResult<Object> updateWeiXinUserInfoById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  weiXinUserInfoId,
             @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
             @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        WeiXinUserInfo weiXinUserInfo = new WeiXinUserInfo();
        weiXinUserInfo.setWeiXinUserInfoId(weiXinUserInfoId);

         if (StringUtil.isNotEmpty(userId)) {
            weiXinUserInfo.setUserId(userId);
         }
         if (null != num) {
            weiXinUserInfo.setNum(num);
         }
        //weiXinUserInfo.setModifiedDate(new Date());
        weiXinUserInfoService.updateWeiXinUserInfoById(weiXinUserInfo);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("删除 用户微信帐号（OpenId）")
    @RequestMapping(value = "/weiXinUserInfo/{weiXinUserInfoId}", method = RequestMethod.DELETE)
    public JsonResult<Object> delWeiXinUserInfoById(
             @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  weiXinUserInfoId
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        weiXinUserInfoService.delWeiXinUserInfoById(weiXinUserInfoId);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("查询 用户微信帐号（OpenId）")
    @RequestMapping(value = "/weiXinUserInfo/{weiXinUserInfoId}", method = RequestMethod.GET)
    public JsonResult<Map<String, Object>> getWeiXinUserInfoById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  weiXinUserInfoId) throws Exception {
        JsonResult<Map<String, Object>> result = new JsonResult<Map<String, Object>>();
        Map<String, Object> rs = new HashMap<String, Object>();
        result.setObj(weiXinUserInfoService.getWeiXinUserInfoById(weiXinUserInfoId));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }
}

