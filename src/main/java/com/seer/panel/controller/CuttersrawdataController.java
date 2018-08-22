package com.seer.panel.controller;


import com.seer.panel.model.Cuttersrawdata;
import com.seer.panel.service.CuttersrawdataService;
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
 * @version $Id CuttersrawdataController.java, 2018-08-22 17:12:43 wuhaosoft Exp
 *
 */
@Api("断刀原始数据接口")
@RestController
@RequestMapping("/panel")
public class CuttersrawdataController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CuttersrawdataService cuttersrawdataService;

    @ApiOperation("查询 所有 断刀原始数据 分页")
    @RequestMapping(value = "/cuttersrawdatas", method = RequestMethod.POST)
    public Object getCuttersrawdataPageTurn(
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
        return cuttersrawdataService.getCuttersrawdataPageTurn(rs, pageNo, pageSize);
    }

    @ApiOperation("查询 所有 断刀原始数据")
    @RequestMapping(value = "/allCuttersrawdatas", method = RequestMethod.POST)
    public JsonResult<Object> selectCuttersrawdataList(
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
        result.setObj(cuttersrawdataService.selectCuttersrawdataList(rs));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("新增 断刀原始数据")
    @RequestMapping(value = "/cuttersrawdata", method = RequestMethod.POST)
    public JsonResult<Object> addCuttersrawdata(
                @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
                @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Cuttersrawdata cuttersrawdata = new Cuttersrawdata();
        if (StringUtil.isNotEmpty(userId)) {
           cuttersrawdata.setUserId(userId);
        }
        if (null != num) {
            cuttersrawdata.setNum(num);
        }
        //cuttersrawdata.setCreatedDate(new Date());
        cuttersrawdataService.addCuttersrawdata(cuttersrawdata);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("更新 断刀原始数据")
    @RequestMapping(value = "/cuttersrawdata/{cuttersrawdataId}", method = RequestMethod.PUT)
    public JsonResult<Object> updateCuttersrawdataById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  cuttersrawdataId,
             @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
             @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Cuttersrawdata cuttersrawdata = new Cuttersrawdata();
        cuttersrawdata.setCuttersrawdataId(cuttersrawdataId);

         if (StringUtil.isNotEmpty(userId)) {
            cuttersrawdata.setUserId(userId);
         }
         if (null != num) {
            cuttersrawdata.setNum(num);
         }
        //cuttersrawdata.setModifiedDate(new Date());
        cuttersrawdataService.updateCuttersrawdataById(cuttersrawdata);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("删除 断刀原始数据")
    @RequestMapping(value = "/cuttersrawdata/{cuttersrawdataId}", method = RequestMethod.DELETE)
    public JsonResult<Object> delCuttersrawdataById(
             @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  cuttersrawdataId
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        cuttersrawdataService.delCuttersrawdataById(cuttersrawdataId);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("查询 断刀原始数据")
    @RequestMapping(value = "/cuttersrawdata/{cuttersrawdataId}", method = RequestMethod.GET)
    public JsonResult<Map<String, Object>> getCuttersrawdataById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  cuttersrawdataId) throws Exception {
        JsonResult<Map<String, Object>> result = new JsonResult<Map<String, Object>>();
        Map<String, Object> rs = new HashMap<String, Object>();
        result.setObj(cuttersrawdataService.getCuttersrawdataById(cuttersrawdataId));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }
}

