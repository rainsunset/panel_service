package com.seer.panel.controller;


import com.seer.panel.model.Record;
import com.seer.panel.service.RecordService;
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
 * @version $Id RecordController.java, 2018-08-22 17:12:44 wuhaosoft Exp
 *
 */
@Api("接口")
@RestController
@RequestMapping("/panel")
public class RecordController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RecordService recordService;

    @ApiOperation("查询 所有  分页")
    @RequestMapping(value = "/records", method = RequestMethod.POST)
    public Object getRecordPageTurn(
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
        return recordService.getRecordPageTurn(rs, pageNo, pageSize);
    }

    @ApiOperation("查询 所有 ")
    @RequestMapping(value = "/allRecords", method = RequestMethod.POST)
    public JsonResult<Object> selectRecordList(
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
        result.setObj(recordService.selectRecordList(rs));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("新增 ")
    @RequestMapping(value = "/record", method = RequestMethod.POST)
    public JsonResult<Object> addRecord(
                @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
                @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Record record = new Record();
        if (StringUtil.isNotEmpty(userId)) {
           record.setUserId(userId);
        }
        if (null != num) {
            record.setNum(num);
        }
        //record.setCreatedDate(new Date());
        recordService.addRecord(record);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("更新 ")
    @RequestMapping(value = "/record/{recordId}", method = RequestMethod.PUT)
    public JsonResult<Object> updateRecordById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  recordId,
             @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
             @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Record record = new Record();
        record.setRecordId(recordId);

         if (StringUtil.isNotEmpty(userId)) {
            record.setUserId(userId);
         }
         if (null != num) {
            record.setNum(num);
         }
        //record.setModifiedDate(new Date());
        recordService.updateRecordById(record);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("删除 ")
    @RequestMapping(value = "/record/{recordId}", method = RequestMethod.DELETE)
    public JsonResult<Object> delRecordById(
             @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  recordId
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        recordService.delRecordById(recordId);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("查询 ")
    @RequestMapping(value = "/record/{recordId}", method = RequestMethod.GET)
    public JsonResult<Map<String, Object>> getRecordById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  recordId) throws Exception {
        JsonResult<Map<String, Object>> result = new JsonResult<Map<String, Object>>();
        Map<String, Object> rs = new HashMap<String, Object>();
        result.setObj(recordService.getRecordById(recordId));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }
}

