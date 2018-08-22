package com.seer.panel.controller;


import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.seer.panel.common.BaseController;
import com.seer.panel.model.Acquisitioncard;
import com.seer.panel.service.AcquisitioncardService;
import com.seer.panel.view.ResponseResult;
import com.seer.panel.view.RestResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author wuhaosoft
 * @version $Id AcquisitioncardController.java, 2018-08-22 17:12:42 wuhaosoft Exp
 *
 */
@Api("采集卡信息接口")
@RestController
@RequestMapping("/panel")
public class AcquisitioncardController extends BaseController {

    @Autowired
    private AcquisitioncardService acquisitioncardService;

    @ApiOperation("查询 所有 采集卡信息 分页")
    @RequestMapping(value = "/acquisitioncards", method = RequestMethod.POST)
    public ResponseResult<PageInfo<Acquisitioncard>> getAcquisitioncardPageTurn(
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
        PageInfo<Acquisitioncard> pageInfo = acquisitioncardService.getAcquisitioncardPageTurn(rs, pageNo, pageSize);
        return RestResultGenerator.genResult(pageInfo);
    }

    @ApiOperation("查询 所有 采集卡信息")
    @RequestMapping(value = "/allAcquisitioncards", method = RequestMethod.POST)
    public ResponseResult<List<Acquisitioncard>> selectAcquisitioncardList(
        @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
        @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
        )throws Exception {
        Map<String, Object> rs = new HashMap<String, Object>();
         if (StringUtil.isNotEmpty(userId)) {
            rs.put("userId", "%" + userId + "%");
         }
        if (null != num) {
            rs.put("num", num);
        }
        List<Acquisitioncard> acquisitioncardList = acquisitioncardService.selectAcquisitioncardList(rs);
        return RestResultGenerator.genResult(acquisitioncardList);
    }

    @ApiOperation("新增 采集卡信息")
    @RequestMapping(value = "/acquisitioncard", method = RequestMethod.POST)
    public ResponseResult<String> addAcquisitioncard(
                @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
                @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        Acquisitioncard acquisitioncard = new Acquisitioncard();
        if (StringUtil.isNotEmpty(userId)) {
           acquisitioncard.setUserId(userId);
        }
        if (null != num) {
            acquisitioncard.setNum(num);
        }
        //acquisitioncard.setCreatedDate(new Date());
        acquisitioncardService.addAcquisitioncard(acquisitioncard);
        return RestResultGenerator.genResult("sucess");
    }

    @ApiOperation("更新 采集卡信息")
    @RequestMapping(value = "/acquisitioncard/{acquisitioncardId}", method = RequestMethod.PUT)
    public ResponseResult<String> updateAcquisitioncardById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  acquisitioncardId,
             @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
             @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        Acquisitioncard acquisitioncard = new Acquisitioncard();
        acquisitioncard.setAcquisitioncard(acquisitioncardId);
         if (StringUtil.isNotEmpty(userId)) {
            acquisitioncard.setUserId(userId);
         }
         if (null != num) {
            acquisitioncard.setNum(num);
         }
        //acquisitioncard.setModifiedDate(new Date());
        acquisitioncardService.updateAcquisitioncardById(acquisitioncard);
        return RestResultGenerator.genResult("sucess");
    }

    @ApiOperation("删除 采集卡信息")
    @RequestMapping(value = "/acquisitioncard/{acquisitioncardId}", method = RequestMethod.DELETE)
    public ResponseResult<String> delAcquisitioncardById(
             @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  acquisitioncardId
            ) throws Exception {
        acquisitioncardService.delAcquisitioncardById(acquisitioncardId);
        return RestResultGenerator.genResult("sucess");
    }

    @ApiOperation("查询 采集卡信息")
    @RequestMapping(value = "/acquisitioncard/{acquisitioncardId}", method = RequestMethod.GET)
    public ResponseResult<Acquisitioncard> getAcquisitioncardById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  acquisitioncardId) throws Exception {
        Map<String, Object> rs = new HashMap<String, Object>();
        return RestResultGenerator.genResult(acquisitioncardService.getAcquisitioncardById(acquisitioncardId));
    }
}

