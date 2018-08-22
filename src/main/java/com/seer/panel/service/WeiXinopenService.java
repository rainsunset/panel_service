package com.seer.panel.service;

import com.github.pagehelper.PageInfo;
import com.seer.panel.model.WeiXinopen;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
public interface WeiXinopenService {

    /**
     * 添加 微信用户表
     * @param weiXinopen
     */
    public void  addWeiXinopen(WeiXinopen weiXinopen);

    /**
     * 依据主键更新 微信用户表
     * @param weiXinopen
     */
    public void  updateWeiXinopenById(WeiXinopen weiXinopen);

    /**
     * 依据条件查找 微信用户表 列表
     * @param param
     * @return
     */
    public List<WeiXinopen> selectWeiXinopenList(Map<String, Object> param);

    /**
     * 依据条件查找分页 微信用户表 列表
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<WeiXinopen> getWeiXinopenPageTurn(Map<String, Object> param, int pageNo, int pageSize);

    /**
     * 依据Id查找 微信用户表 详情
     * @param weiXinopenId
     * @return
     */
    public WeiXinopen getWeiXinopenById(Integer weiXinopenId);

    /**
     * 依据Id删除 微信用户表 记录
     * @param weiXinopenId
     */
    public void delWeiXinopenById(Integer weiXinopenId);
}
