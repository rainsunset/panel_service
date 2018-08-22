package com.seer.panel.service;

import com.github.pagehelper.PageInfo;
import com.seer.panel.model.WeiXinUserInfo;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
public interface WeiXinUserInfoService {

    /**
     * 添加 用户微信帐号（OpenId）
     * @param weiXinUserInfo
     */
    public void  addWeiXinUserInfo(WeiXinUserInfo weiXinUserInfo);

    /**
     * 依据主键更新 用户微信帐号（OpenId）
     * @param weiXinUserInfo
     */
    public void  updateWeiXinUserInfoById(WeiXinUserInfo weiXinUserInfo);

    /**
     * 依据条件查找 用户微信帐号（OpenId） 列表
     * @param param
     * @return
     */
    public List<WeiXinUserInfo> selectWeiXinUserInfoList(Map<String, Object> param);

    /**
     * 依据条件查找分页 用户微信帐号（OpenId） 列表
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<WeiXinUserInfo> getWeiXinUserInfoPageTurn(Map<String, Object> param, int pageNo, int pageSize);

    /**
     * 依据Id查找 用户微信帐号（OpenId） 详情
     * @param weiXinUserInfoId
     * @return
     */
    public WeiXinUserInfo getWeiXinUserInfoById(Integer weiXinUserInfoId);

    /**
     * 依据Id删除 用户微信帐号（OpenId） 记录
     * @param weiXinUserInfoId
     */
    public void delWeiXinUserInfoById(Integer weiXinUserInfoId);
}
