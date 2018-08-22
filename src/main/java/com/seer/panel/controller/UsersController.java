package com.seer.panel.controller;


import com.seer.panel.model.Users;
import com.seer.panel.service.UsersService;
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
 * @version $Id UsersController.java, 2018-08-22 17:12:45 wuhaosoft Exp
 *
 */
@Api("用户登陆表接口")
@RestController
@RequestMapping("/panel")
public class UsersController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UsersService usersService;

    @ApiOperation("查询 所有 用户登陆表 分页")
    @RequestMapping(value = "/userss", method = RequestMethod.POST)
    public Object getUsersPageTurn(
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
        return usersService.getUsersPageTurn(rs, pageNo, pageSize);
    }

    @ApiOperation("查询 所有 用户登陆表")
    @RequestMapping(value = "/allUserss", method = RequestMethod.POST)
    public JsonResult<Object> selectUsersList(
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
        result.setObj(usersService.selectUsersList(rs));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("新增 用户登陆表")
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public JsonResult<Object> addUsers(
                @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
                @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Users users = new Users();
        if (StringUtil.isNotEmpty(userId)) {
           users.setUserId(userId);
        }
        if (null != num) {
            users.setNum(num);
        }
        //users.setCreatedDate(new Date());
        usersService.addUsers(users);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("更新 用户登陆表")
    @RequestMapping(value = "/users/{usersId}", method = RequestMethod.PUT)
    public JsonResult<Object> updateUsersById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  usersId,
             @ApiParam(value = "userId (非必传参数)") @RequestParam(required = false) String userId,
             @ApiParam(value = "num (非必传参数)") @RequestParam(required = false) Integer num
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        Users users = new Users();
        users.setUsersId(usersId);

         if (StringUtil.isNotEmpty(userId)) {
            users.setUserId(userId);
         }
         if (null != num) {
            users.setNum(num);
         }
        //users.setModifiedDate(new Date());
        usersService.updateUsersById(users);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("删除 用户登陆表")
    @RequestMapping(value = "/users/{usersId}", method = RequestMethod.DELETE)
    public JsonResult<Object> delUsersById(
             @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  usersId
            ) throws Exception {
        JsonResult<Object> result = new JsonResult<Object>();
        usersService.delUsersById(usersId);
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }

    @ApiOperation("查询 用户登陆表")
    @RequestMapping(value = "/users/{usersId}", method = RequestMethod.GET)
    public JsonResult<Map<String, Object>> getUsersById(
            @ApiParam(value = "111111 (必传参数)") @PathVariable Integer  usersId) throws Exception {
        JsonResult<Map<String, Object>> result = new JsonResult<Map<String, Object>>();
        Map<String, Object> rs = new HashMap<String, Object>();
        result.setObj(usersService.getUsersById(usersId));
        result.setCode(ResultCode.SUCCESS.getCode());
        return result;
    }
}

