package com.seer.panel.controller;


import com.seer.panel.model.Brokenknifedetail;
import com.seer.panel.service.BrokenknifedetailService;
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
 * @version $Id BrokenknifedetailController.java, 2018-08-22 17:12:43 wuhaosoft Exp
 *
 */
@Api("断刀记录明细接口")
@RestController
@RequestMapping("/panel")
public class BrokenknifedetailController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BrokenknifedetailService brokenknifedetailService;

    @ApiOperation("查询 所有 断刀记录明细 分页")
    @RequestMapping(value = "/brokenknifedetails", method = RequestMethod.POST)
    public Object getBrokenknifedetailPageTurn(
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
        return brokenknifedetailService.getBrokenknifedetailPageTurn(rs, pageNo, pageSize);
    }

    @ApiOperation("查询 所有 断刀记录明细")
    @RequestMapping(value = "/allBrokenknifedetails", method = RequestMethod.POST)
    public JsonResult<Object> selectBrokenknifedetailList(
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
        result.setObj(brokenknifedetailService.selectBrokenknifedetailList(rs));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("新增 断刀记录明细")
    @RequestMapping(value = "/brokenknifedetail", method = RequestMethod.POST)
    public JsonResult<Object> addBrokenknifedetail(
                @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
                @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Brokenknifedetail brokenknifedetail = new Brokenknifedetail();
        if (StringUtil.isNotEmpty(userId)) {
           brokenknifedetail.setUserId(userId);
        }
        if (null != num) {
            brokenknifedetail.setNum(num);
        }
        //brokenknifedetail.setCreatedDate(new Date());
        brokenknifedetailService.addBrokenknifedetail(brokenknifedetail);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("更新 断刀记录明细")
    @RequestMapping(value = "/brokenknifedetail/{brokenknifedetailId}", method = RequestMethod.PUT)
    public JsonResult<Object> updateBrokenknifedetailById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  brokenknifedetailId,
             @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
             @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Brokenknifedetail brokenknifedetail = new Brokenknifedetail();
        brokenknifedetail.setBrokenknifedetailId(brokenknifedetailId);

         if (StringUtil.isNotEmpty(userId)) {
            brokenknifedetail.setUserId(userId);
         }
         if (null != num) {
            brokenknifedetail.setNum(num);
         }
        //brokenknifedetail.setModifiedDate(new Date());
        brokenknifedetailService.updateBrokenknifedetailById(brokenknifedetail);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("删除 断刀记录明细")
    @RequestMapping(value = "/brokenknifedetail/{brokenknifedetailId}", method = RequestMethod.DELETE)
    public JsonResult<Object> delBrokenknifedetailById(
             @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  brokenknifedetailId
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        brokenknifedetailService.delBrokenknifedetailById(brokenknifedetailId);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("查询 断刀记录明细")
    @RequestMapping(value = "/brokenknifedetail/{brokenknifedetailId}", method = RequestMethod.GET)
    public JsonResult<Map<String, Object>> getBrokenknifedetailById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  brokenknifedetailId) throws Exception {
        JsonResult<Map<String, Object>> result = new JsonResult<Map<String, Object>>();
        Map<String, Object> rs = new HashMap<String, Object>();
        result.setObj(brokenknifedetailService.getBrokenknifedetailById(brokenknifedetailId));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }
}

