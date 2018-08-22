package com.seer.panel.controller;


import com.seer.panel.model.Knifeorder;
import com.seer.panel.service.KnifeorderService;
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
 * @version $Id KnifeorderController.java, 2018-08-22 17:12:44 wuhaosoft Exp
 *
 */
@Api("机床刀具使用顺序表接口")
@RestController
@RequestMapping("/panel")
public class KnifeorderController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private KnifeorderService knifeorderService;

    @ApiOperation("查询 所有 机床刀具使用顺序表 分页")
    @RequestMapping(value = "/knifeorders", method = RequestMethod.POST)
    public Object getKnifeorderPageTurn(
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
        return knifeorderService.getKnifeorderPageTurn(rs, pageNo, pageSize);
    }

    @ApiOperation("查询 所有 机床刀具使用顺序表")
    @RequestMapping(value = "/allKnifeorders", method = RequestMethod.POST)
    public JsonResult<Object> selectKnifeorderList(
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
        result.setObj(knifeorderService.selectKnifeorderList(rs));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("新增 机床刀具使用顺序表")
    @RequestMapping(value = "/knifeorder", method = RequestMethod.POST)
    public JsonResult<Object> addKnifeorder(
                @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
                @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Knifeorder knifeorder = new Knifeorder();
        if (StringUtil.isNotEmpty(userId)) {
           knifeorder.setUserId(userId);
        }
        if (null != num) {
            knifeorder.setNum(num);
        }
        //knifeorder.setCreatedDate(new Date());
        knifeorderService.addKnifeorder(knifeorder);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("更新 机床刀具使用顺序表")
    @RequestMapping(value = "/knifeorder/{knifeorderId}", method = RequestMethod.PUT)
    public JsonResult<Object> updateKnifeorderById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  knifeorderId,
             @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
             @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Knifeorder knifeorder = new Knifeorder();
        knifeorder.setKnifeorderId(knifeorderId);

         if (StringUtil.isNotEmpty(userId)) {
            knifeorder.setUserId(userId);
         }
         if (null != num) {
            knifeorder.setNum(num);
         }
        //knifeorder.setModifiedDate(new Date());
        knifeorderService.updateKnifeorderById(knifeorder);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("删除 机床刀具使用顺序表")
    @RequestMapping(value = "/knifeorder/{knifeorderId}", method = RequestMethod.DELETE)
    public JsonResult<Object> delKnifeorderById(
             @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  knifeorderId
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        knifeorderService.delKnifeorderById(knifeorderId);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("查询 机床刀具使用顺序表")
    @RequestMapping(value = "/knifeorder/{knifeorderId}", method = RequestMethod.GET)
    public JsonResult<Map<String, Object>> getKnifeorderById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  knifeorderId) throws Exception {
        JsonResult<Map<String, Object>> result = new JsonResult<Map<String, Object>>();
        Map<String, Object> rs = new HashMap<String, Object>();
        result.setObj(knifeorderService.getKnifeorderById(knifeorderId));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }
}

