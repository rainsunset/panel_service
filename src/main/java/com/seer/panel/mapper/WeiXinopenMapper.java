package com.seer.panel.mapper;

import com.seer.panel.model.WeiXinopen;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
 @Repository
public interface WeiXinopenMapper {

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
     * 依据主键删除 微信用户表 记录
     * @param weiXinopenId
     */
    public void  delWeiXinopenById(Integer weiXinopenId);

}
