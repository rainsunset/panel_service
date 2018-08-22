package com.seer.panel.controller;


import com.seer.panel.model.Count;
import com.seer.panel.service.CountService;
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
 * @version $Id CountController.java, 2018-08-22 17:12:43 wuhaosoft Exp
 *
 */
@Api("接口")
@RestController
@RequestMapping("/panel")
public class CountController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CountService countService;

    @ApiOperation("查询 所有  分页")
    @RequestMapping(value = "/counts", method = RequestMethod.POST)
    public Object getCountPageTurn(
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
        return countService.getCountPageTurn(rs, pageNo, pageSize);
    }

    @ApiOperation("查询 所有 ")
    @RequestMapping(value = "/allCounts", method = RequestMethod.POST)
    public JsonResult<Object> selectCountList(
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
        result.setObj(countService.selectCountList(rs));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("新增 ")
    @RequestMapping(value = "/count", method = RequestMethod.POST)
    public JsonResult<Object> addCount(
                @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
                @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Count count = new Count();
        if (StringUtil.isNotEmpty(userId)) {
           count.setUserId(userId);
        }
        if (null != num) {
            count.setNum(num);
        }
        //count.setCreatedDate(new Date());
        countService.addCount(count);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("更新 ")
    @RequestMapping(value = "/count/{countId}", method = RequestMethod.PUT)
    public JsonResult<Object> updateCountById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  countId,
             @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
             @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Count count = new Count();
        count.setCountId(countId);

         if (StringUtil.isNotEmpty(userId)) {
            count.setUserId(userId);
         }
         if (null != num) {
            count.setNum(num);
         }
        //count.setModifiedDate(new Date());
        countService.updateCountById(count);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("删除 ")
    @RequestMapping(value = "/count/{countId}", method = RequestMethod.DELETE)
    public JsonResult<Object> delCountById(
             @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  countId
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        countService.delCountById(countId);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("查询 ")
    @RequestMapping(value = "/count/{countId}", method = RequestMethod.GET)
    public JsonResult<Map<String, Object>> getCountById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  countId) throws Exception {
        JsonResult<Map<String, Object>> result = new JsonResult<Map<String, Object>>();
        Map<String, Object> rs = new HashMap<String, Object>();
        result.setObj(countService.getCountById(countId));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }
}

