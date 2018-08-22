package com.seer.panel.mapper;

import com.seer.panel.model.WeiXinUserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
 @Repository
public interface WeiXinUserInfoMapper {

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
     * 依据主键删除 用户微信帐号（OpenId） 记录
     * @param weiXinUserInfoId
     */
    public void  delWeiXinUserInfoById(Integer weiXinUserInfoId);

}
