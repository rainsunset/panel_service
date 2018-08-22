package com.seer.panel.controller;


import com.seer.panel.model.Knifechangerhistory;
import com.seer.panel.service.KnifechangerhistoryService;
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
 * @version $Id KnifechangerhistoryController.java, 2018-08-22 17:12:43 wuhaosoft Exp
 *
 */
@Api("换刀记录接口")
@RestController
@RequestMapping("/panel")
public class KnifechangerhistoryController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private KnifechangerhistoryService knifechangerhistoryService;

    @ApiOperation("查询 所有 换刀记录 分页")
    @RequestMapping(value = "/knifechangerhistorys", method = RequestMethod.POST)
    public Object getKnifechangerhistoryPageTurn(
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
        return knifechangerhistoryService.getKnifechangerhistoryPageTurn(rs, pageNo, pageSize);
    }

    @ApiOperation("查询 所有 换刀记录")
    @RequestMapping(value = "/allKnifechangerhistorys", method = RequestMethod.POST)
    public JsonResult<Object> selectKnifechangerhistoryList(
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
        result.setObj(knifechangerhistoryService.selectKnifechangerhistoryList(rs));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("新增 换刀记录")
    @RequestMapping(value = "/knifechangerhistory", method = RequestMethod.POST)
    public JsonResult<Object> addKnifechangerhistory(
                @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
                @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Knifechangerhistory knifechangerhistory = new Knifechangerhistory();
        if (StringUtil.isNotEmpty(userId)) {
           knifechangerhistory.setUserId(userId);
        }
        if (null != num) {
            knifechangerhistory.setNum(num);
        }
        //knifechangerhistory.setCreatedDate(new Date());
        knifechangerhistoryService.addKnifechangerhistory(knifechangerhistory);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("更新 换刀记录")
    @RequestMapping(value = "/knifechangerhistory/{knifechangerhistoryId}", method = RequestMethod.PUT)
    public JsonResult<Object> updateKnifechangerhistoryById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  knifechangerhistoryId,
             @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
             @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Knifechangerhistory knifechangerhistory = new Knifechangerhistory();
        knifechangerhistory.setKnifechangerhistoryId(knifechangerhistoryId);

         if (StringUtil.isNotEmpty(userId)) {
            knifechangerhistory.setUserId(userId);
         }
         if (null != num) {
            knifechangerhistory.setNum(num);
         }
        //knifechangerhistory.setModifiedDate(new Date());
        knifechangerhistoryService.updateKnifechangerhistoryById(knifechangerhistory);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("删除 换刀记录")
    @RequestMapping(value = "/knifechangerhistory/{knifechangerhistoryId}", method = RequestMethod.DELETE)
    public JsonResult<Object> delKnifechangerhistoryById(
             @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  knifechangerhistoryId
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        knifechangerhistoryService.delKnifechangerhistoryById(knifechangerhistoryId);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("查询 换刀记录")
    @RequestMapping(value = "/knifechangerhistory/{knifechangerhistoryId}", method = RequestMethod.GET)
    public JsonResult<Map<String, Object>> getKnifechangerhistoryById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  knifechangerhistoryId) throws Exception {
        JsonResult<Map<String, Object>> result = new JsonResult<Map<String, Object>>();
        Map<String, Object> rs = new HashMap<String, Object>();
        result.setObj(knifechangerhistoryService.getKnifechangerhistoryById(knifechangerhistoryId));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }
}

