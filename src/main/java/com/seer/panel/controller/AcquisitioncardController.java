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
 * @version $Id AcquisitioncardController.java, 2018-08-23 10:45:24 wuhaosoft Exp
 *
 */
@Api(tags = "采集卡信息接口")
@RestController
@RequestMapping("/panel")
public class AcquisitioncardController extends BaseController{

    @Autowired
    private AcquisitioncardService acquisitioncardService;

    @ApiOperation("查询 所有 采集卡信息 分页")
    @RequestMapping(value = "/acquisitioncards", method = RequestMethod.POST)
    public ResponseResult<PageInfo<Acquisitioncard>> getAcquisitioncardPageTurn(
            @ApiParam(value = "采集卡名称 (非必传参数)") @RequestParam(required = false) String acquisitionCardName,
            @ApiParam(value = "采集卡规格型号 (非必传参数)") @RequestParam(required = false) String acquisitionCardModel,
            @ApiParam(value = "通道数量 (非必传参数)") @RequestParam(required = false) Integer channelNums,
            @ApiParam(value = "ip (非必传参数)") @RequestParam(required = false) String ip,
            @ApiParam(value = "端口号 (非必传参数)") @RequestParam(required = false) Integer port,
            @ApiParam(value = "状态 (非必传参数)") @RequestParam(required = false) Integer status,
            @ApiParam(value = "创建人 (非必传参数)") @RequestParam(required = false) String creator,
            @ApiParam(value = "修改人 (非必传参数)") @RequestParam(required = false) String modifier,
            @ApiParam(value = "创建时间 (非必传参数)") @RequestParam(required = false) Date createTime,
            @ApiParam(value = "修改时间 (非必传参数)") @RequestParam(required = false) Date modifyTime,
            @ApiParam(value = "页码(必传)") @RequestParam Integer pageNo,
            @ApiParam(value = "每页显示多少数据(必传)") @RequestParam Integer pageSize) throws Exception {
        Map<String, Object> rs = new HashMap<String, Object>();
        if (StringUtil.isNotEmpty(acquisitionCardName)) {
           rs.put("acquisitionCardName", "%" + acquisitionCardName + "%");
        }
        if (StringUtil.isNotEmpty(acquisitionCardModel)) {
           rs.put("acquisitionCardModel", "%" + acquisitionCardModel + "%");
        }
        if (null != channelNums) {
           rs.put("channelNums", channelNums);
        }
        if (StringUtil.isNotEmpty(ip)) {
           rs.put("ip", "%" + ip + "%");
        }
        if (null != port) {
           rs.put("port", port);
        }
        if (null != status) {
           rs.put("status", status);
        }
        if (StringUtil.isNotEmpty(creator)) {
           rs.put("creator", "%" + creator + "%");
        }
        if (StringUtil.isNotEmpty(modifier)) {
           rs.put("modifier", "%" + modifier + "%");
        }
        if (null != createTime) {
           rs.put("createTime", createTime);
        }
        if (null != modifyTime) {
           rs.put("modifyTime", modifyTime);
        }
        PageInfo<Acquisitioncard> pageInfo = acquisitioncardService.getAcquisitioncardPageTurn(rs, pageNo, pageSize);
        return RestResultGenerator.genResult(pageInfo);
    }

    @ApiOperation("查询 所有 采集卡信息")
    @RequestMapping(value = "/allAcquisitioncards", method = RequestMethod.POST)
    public ResponseResult<List<Acquisitioncard>> selectAcquisitioncardList(
        @ApiParam(value = "采集卡名称 (非必传参数)") @RequestParam(required = false) String acquisitionCardName,
        @ApiParam(value = "采集卡规格型号 (非必传参数)") @RequestParam(required = false) String acquisitionCardModel,
        @ApiParam(value = "通道数量 (非必传参数)") @RequestParam(required = false) Integer channelNums,
        @ApiParam(value = "ip (非必传参数)") @RequestParam(required = false) String ip,
        @ApiParam(value = "端口号 (非必传参数)") @RequestParam(required = false) Integer port,
        @ApiParam(value = "状态 (非必传参数)") @RequestParam(required = false) Integer status,
        @ApiParam(value = "创建人 (非必传参数)") @RequestParam(required = false) String creator,
        @ApiParam(value = "修改人 (非必传参数)") @RequestParam(required = false) String modifier,
        @ApiParam(value = "创建时间 (非必传参数)") @RequestParam(required = false) Date createTime,
        @ApiParam(value = "修改时间 (非必传参数)") @RequestParam(required = false) Date modifyTime
        )throws Exception {
        Map<String, Object> rs = new HashMap<String, Object>();
         if (StringUtil.isNotEmpty(acquisitionCardName)) {
            rs.put("acquisitionCardName", "%" + acquisitionCardName + "%");
         }
         if (StringUtil.isNotEmpty(acquisitionCardModel)) {
            rs.put("acquisitionCardModel", "%" + acquisitionCardModel + "%");
         }
        if (null != channelNums) {
            rs.put("channelNums", channelNums);
        }
         if (StringUtil.isNotEmpty(ip)) {
            rs.put("ip", "%" + ip + "%");
         }
        if (null != port) {
            rs.put("port", port);
        }
        if (null != status) {
            rs.put("status", status);
        }
         if (StringUtil.isNotEmpty(creator)) {
            rs.put("creator", "%" + creator + "%");
         }
         if (StringUtil.isNotEmpty(modifier)) {
            rs.put("modifier", "%" + modifier + "%");
         }
        if (null != createTime) {
            rs.put("createTime", createTime);
        }
        if (null != modifyTime) {
            rs.put("modifyTime", modifyTime);
        }
        List<Acquisitioncard> acquisitioncardList = acquisitioncardService.selectAcquisitioncardList(rs);
        return RestResultGenerator.genResult(acquisitioncardList);
    }

    @ApiOperation("新增 采集卡信息")
    @RequestMapping(value = "/acquisitioncard", method = RequestMethod.POST)
    public ResponseResult<String> addAcquisitioncard(
                @ApiParam(value = "采集卡名称 (非必传参数)") @RequestParam(required = false) String acquisitionCardName,
                @ApiParam(value = "采集卡规格型号 (非必传参数)") @RequestParam(required = false) String acquisitionCardModel,
                @ApiParam(value = "通道数量 (非必传参数)") @RequestParam(required = false) Integer channelNums,
                @ApiParam(value = "ip (非必传参数)") @RequestParam(required = false) String ip,
                @ApiParam(value = "端口号 (非必传参数)") @RequestParam(required = false) Integer port,
                @ApiParam(value = "状态 (非必传参数)") @RequestParam(required = false) Integer status,
                @ApiParam(value = "创建人 (非必传参数)") @RequestParam(required = false) String creator,
                @ApiParam(value = "修改人 (非必传参数)") @RequestParam(required = false) String modifier,
                @ApiParam(value = "创建时间 (非必传参数)") @RequestParam(required = false) Date createTime,
                @ApiParam(value = "修改时间 (非必传参数)") @RequestParam(required = false) Date modifyTime
            ) throws Exception {
        Acquisitioncard acquisitioncard = new Acquisitioncard();
        if (StringUtil.isNotEmpty(acquisitionCardName)) {
           acquisitioncard.setAcquisitionCardName(acquisitionCardName);
        }
        if (StringUtil.isNotEmpty(acquisitionCardModel)) {
           acquisitioncard.setAcquisitionCardModel(acquisitionCardModel);
        }
        if (null != channelNums) {
            acquisitioncard.setChannelNums(channelNums);
        }
        if (StringUtil.isNotEmpty(ip)) {
           acquisitioncard.setIp(ip);
        }
        if (null != port) {
            acquisitioncard.setPort(port);
        }
        if (null != status) {
            acquisitioncard.setStatus(status);
        }
        if (StringUtil.isNotEmpty(creator)) {
           acquisitioncard.setCreator(creator);
        }
        if (StringUtil.isNotEmpty(modifier)) {
           acquisitioncard.setModifier(modifier);
        }
        if (null != createTime) {
            acquisitioncard.setCreateTime(createTime);
        }
        if (null != modifyTime) {
            acquisitioncard.setModifyTime(modifyTime);
        }
        //acquisitioncard.setCreatedDate(new Date());
        acquisitioncardService.addAcquisitioncard(acquisitioncard);
        return RestResultGenerator.genResult("sucess");
    }

    @ApiOperation("更新 采集卡信息")
    @RequestMapping(value = "/acquisitioncard/{acquisitionCardCode}", method = RequestMethod.PUT)
    public ResponseResult<String> updateAcquisitioncardById(
            @ApiParam(value = "采集卡编码 (必传参数)") @PathVariable String  acquisitionCardCode,
             @ApiParam(value = "采集卡名称 (非必传参数)") @RequestParam(required = false) String acquisitionCardName,
             @ApiParam(value = "采集卡规格型号 (非必传参数)") @RequestParam(required = false) String acquisitionCardModel,
             @ApiParam(value = "通道数量 (非必传参数)") @RequestParam(required = false) Integer channelNums,
             @ApiParam(value = "ip (非必传参数)") @RequestParam(required = false) String ip,
             @ApiParam(value = "端口号 (非必传参数)") @RequestParam(required = false) Integer port,
             @ApiParam(value = "状态 (非必传参数)") @RequestParam(required = false) Integer status,
             @ApiParam(value = "创建人 (非必传参数)") @RequestParam(required = false) String creator,
             @ApiParam(value = "修改人 (非必传参数)") @RequestParam(required = false) String modifier,
             @ApiParam(value = "创建时间 (非必传参数)") @RequestParam(required = false) Date createTime,
             @ApiParam(value = "修改时间 (非必传参数)") @RequestParam(required = false) Date modifyTime
            ) throws Exception {
        Acquisitioncard acquisitioncard = new Acquisitioncard();
        acquisitioncard.setAcquisitionCardCode(acquisitionCardCode);

         if (StringUtil.isNotEmpty(acquisitionCardName)) {
            acquisitioncard.setAcquisitionCardName(acquisitionCardName);
         }
         if (StringUtil.isNotEmpty(acquisitionCardModel)) {
            acquisitioncard.setAcquisitionCardModel(acquisitionCardModel);
         }
         if (null != channelNums) {
            acquisitioncard.setChannelNums(channelNums);
         }
         if (StringUtil.isNotEmpty(ip)) {
            acquisitioncard.setIp(ip);
         }
         if (null != port) {
            acquisitioncard.setPort(port);
         }
         if (null != status) {
            acquisitioncard.setStatus(status);
         }
         if (StringUtil.isNotEmpty(creator)) {
            acquisitioncard.setCreator(creator);
         }
         if (StringUtil.isNotEmpty(modifier)) {
            acquisitioncard.setModifier(modifier);
         }
         if (null != createTime) {
            acquisitioncard.setCreateTime(createTime);
         }
         if (null != modifyTime) {
            acquisitioncard.setModifyTime(modifyTime);
         }
        //acquisitioncard.setModifiedDate(new Date());
        acquisitioncardService.updateAcquisitioncardById(acquisitioncard);
        return RestResultGenerator.genResult("sucess");
    }

    @ApiOperation("删除 采集卡信息")
    @RequestMapping(value = "/acquisitioncard/{acquisitionCardCode}", method = RequestMethod.DELETE)
    public ResponseResult<String> delAcquisitioncardById(
             @ApiParam(value = "采集卡编码 (必传参数)") @PathVariable String  acquisitionCardCode
            ) throws Exception {
        acquisitioncardService.delAcquisitioncardById(acquisitionCardCode);
        return RestResultGenerator.genResult("sucess");
    }

    @ApiOperation("查询 采集卡信息")
    @RequestMapping(value = "/acquisitioncard/{acquisitionCardCode}", method = RequestMethod.GET)
    public ResponseResult<Acquisitioncard> getAcquisitioncardById(
            @ApiParam(value = "采集卡编码 (必传参数)") @PathVariable String  acquisitionCardCode) throws Exception {
        return RestResultGenerator.genResult(acquisitioncardService.getAcquisitioncardById(acquisitionCardCode));
    }
}

