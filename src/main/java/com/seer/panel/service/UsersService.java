package com.seer.panel.service;

import com.github.pagehelper.PageInfo;
import com.seer.panel.model.Users;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
public interface UsersService {

    /**
     * 添加 用户登陆表
     * @param users
     */
    public void  addUsers(Users users);

    /**
     * 依据主键更新 用户登陆表
     * @param users
     */
    public void  updateUsersById(Users users);

    /**
     * 依据条件查找 用户登陆表 列表
     * @param param
     * @return
     */
    public List<Users> selectUsersList(Map<String, Object> param);

    /**
     * 依据条件查找分页 用户登陆表 列表
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<Users> getUsersPageTurn(Map<String, Object> param, int pageNo, int pageSize);

    /**
     * 依据Id查找 用户登陆表 详情
     * @param usersId
     * @return
     */
    public Users getUsersById(Integer usersId);

    /**
     * 依据Id删除 用户登陆表 记录
     * @param usersId
     */
    public void delUsersById(Integer usersId);
}
