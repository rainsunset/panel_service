package com.seer.panel.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.seer.panel.common.BaseService;
import com.seer.panel.model.Users;
import com.seer.panel.mapper.UsersMapper;
import com.seer.panel.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author whaosoft
 *
 */
@Service
public class UsersServiceImpl extends BaseService implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public void  addUsers(Users users) {
        usersMapper.addUsers(users);
    }

    @Override
    public void  updateUsersById(Users users) {
        usersMapper.updateUsersById(users);
    }

    @Override
    public List<Users> selectUsersList(Map<String, Object> param) {
        return usersMapper.selectUsersList(param);
    }

    @Override
    public PageInfo<Users> getUsersPageTurn(Map<String, Object> param, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize, true);
        List<Users> usersList = usersMapper.selectUsersList(param);
        PageInfo<Users> pageInfo = new PageInfo<Users>(usersList);
        return pageInfo;
    }

    @Override
    public Users getUsersById(Integer usersId) {
        Users usersinfo = new Users();
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put("usersId", usersId);
        List<Users> usersList = usersMapper.selectUsersList(rs);
        if ((null != usersList) && (usersList.size() > 0)) {
            usersinfo = usersList.get(0);
        }
        return usersinfo;
    }

    @Override
    public void delUsersById(Integer usersId) {

     //Users users = new Users();
     //users.setIsDeleted(1);
     //users.setUsersId(usersId);
     //usersMapper.updateUsersById(users);

        usersMapper.delUsersById(usersId);

    }

}
