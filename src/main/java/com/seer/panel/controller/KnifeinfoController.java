package com.seer.panel.controller;


import com.seer.panel.model.Knifeinfo;
import com.seer.panel.service.KnifeinfoService;
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
 * @version $Id KnifeinfoController.java, 2018-08-22 17:12:43 wuhaosoft Exp
 *
 */
@Api("刀具信息表接口")
@RestController
@RequestMapping("/panel")
public class KnifeinfoController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private KnifeinfoService knifeinfoService;

    @ApiOperation("查询 所有 刀具信息表 分页")
    @RequestMapping(value = "/knifeinfos", method = RequestMethod.POST)
    public Object getKnifeinfoPageTurn(
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
        return knifeinfoService.getKnifeinfoPageTurn(rs, pageNo, pageSize);
    }

    @ApiOperation("查询 所有 刀具信息表")
    @RequestMapping(value = "/allKnifeinfos", method = RequestMethod.POST)
    public JsonResult<Object> selectKnifeinfoList(
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
        result.setObj(knifeinfoService.selectKnifeinfoList(rs));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("新增 刀具信息表")
    @RequestMapping(value = "/knifeinfo", method = RequestMethod.POST)
    public JsonResult<Object> addKnifeinfo(
                @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
                @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Knifeinfo knifeinfo = new Knifeinfo();
        if (StringUtil.isNotEmpty(userId)) {
           knifeinfo.setUserId(userId);
        }
        if (null != num) {
            knifeinfo.setNum(num);
        }
        //knifeinfo.setCreatedDate(new Date());
        knifeinfoService.addKnifeinfo(knifeinfo);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("更新 刀具信息表")
    @RequestMapping(value = "/knifeinfo/{knifeinfoId}", method = RequestMethod.PUT)
    public JsonResult<Object> updateKnifeinfoById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  knifeinfoId,
             @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
             @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Knifeinfo knifeinfo = new Knifeinfo();
        knifeinfo.setKnifeinfoId(knifeinfoId);

         if (StringUtil.isNotEmpty(userId)) {
            knifeinfo.setUserId(userId);
         }
         if (null != num) {
            knifeinfo.setNum(num);
         }
        //knifeinfo.setModifiedDate(new Date());
        knifeinfoService.updateKnifeinfoById(knifeinfo);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("删除 刀具信息表")
    @RequestMapping(value = "/knifeinfo/{knifeinfoId}", method = RequestMethod.DELETE)
    public JsonResult<Object> delKnifeinfoById(
             @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  knifeinfoId
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        knifeinfoService.delKnifeinfoById(knifeinfoId);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("查询 刀具信息表")
    @RequestMapping(value = "/knifeinfo/{knifeinfoId}", method = RequestMethod.GET)
    public JsonResult<Map<String, Object>> getKnifeinfoById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  knifeinfoId) throws Exception {
        JsonResult<Map<String, Object>> result = new JsonResult<Map<String, Object>>();
        Map<String, Object> rs = new HashMap<String, Object>();
        result.setObj(knifeinfoService.getKnifeinfoById(knifeinfoId));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }
}

