package com.seer.panel.mapper;

import com.seer.panel.model.Users;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
 @Repository
public interface UsersMapper {

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
     * 依据主键删除 用户登陆表 记录
     * @param usersId
     */
    public void  delUsersById(Integer usersId);

}
