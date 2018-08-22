package com.seer.panel.controller;


import com.seer.panel.model.Knifelife;
import com.seer.panel.service.KnifelifeService;
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
 * @version $Id KnifelifeController.java, 2018-08-22 17:12:44 wuhaosoft Exp
 *
 */
@Api("刀具寿命接口")
@RestController
@RequestMapping("/panel")
public class KnifelifeController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private KnifelifeService knifelifeService;

    @ApiOperation("查询 所有 刀具寿命 分页")
    @RequestMapping(value = "/knifelifes", method = RequestMethod.POST)
    public Object getKnifelifePageTurn(
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
        return knifelifeService.getKnifelifePageTurn(rs, pageNo, pageSize);
    }

    @ApiOperation("查询 所有 刀具寿命")
    @RequestMapping(value = "/allKnifelifes", method = RequestMethod.POST)
    public JsonResult<Object> selectKnifelifeList(
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
        result.setObj(knifelifeService.selectKnifelifeList(rs));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("新增 刀具寿命")
    @RequestMapping(value = "/knifelife", method = RequestMethod.POST)
    public JsonResult<Object> addKnifelife(
                @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
                @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Knifelife knifelife = new Knifelife();
        if (StringUtil.isNotEmpty(userId)) {
           knifelife.setUserId(userId);
        }
        if (null != num) {
            knifelife.setNum(num);
        }
        //knifelife.setCreatedDate(new Date());
        knifelifeService.addKnifelife(knifelife);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("更新 刀具寿命")
    @RequestMapping(value = "/knifelife/{knifelifeId}", method = RequestMethod.PUT)
    public JsonResult<Object> updateKnifelifeById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  knifelifeId,
             @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
             @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Knifelife knifelife = new Knifelife();
        knifelife.setKnifelifeId(knifelifeId);

         if (StringUtil.isNotEmpty(userId)) {
            knifelife.setUserId(userId);
         }
         if (null != num) {
            knifelife.setNum(num);
         }
        //knifelife.setModifiedDate(new Date());
        knifelifeService.updateKnifelifeById(knifelife);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("删除 刀具寿命")
    @RequestMapping(value = "/knifelife/{knifelifeId}", method = RequestMethod.DELETE)
    public JsonResult<Object> delKnifelifeById(
             @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  knifelifeId
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        knifelifeService.delKnifelifeById(knifelifeId);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("查询 刀具寿命")
    @RequestMapping(value = "/knifelife/{knifelifeId}", method = RequestMethod.GET)
    public JsonResult<Map<String, Object>> getKnifelifeById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  knifelifeId) throws Exception {
        JsonResult<Map<String, Object>> result = new JsonResult<Map<String, Object>>();
        Map<String, Object> rs = new HashMap<String, Object>();
        result.setObj(knifelifeService.getKnifelifeById(knifelifeId));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }
}

