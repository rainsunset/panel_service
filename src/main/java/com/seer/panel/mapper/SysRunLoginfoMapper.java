package com.seer.panel.mapper;

import com.seer.panel.model.SysRunLoginfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
 @Repository
public interface SysRunLoginfoMapper {

    /**
     * 添加 系统日志表
     * @param sysRunLoginfo
     */
    public void  addSysRunLoginfo(SysRunLoginfo sysRunLoginfo);

    /**
     * 依据主键更新 系统日志表
     * @param sysRunLoginfo
     */
    public void  updateSysRunLoginfoById(SysRunLoginfo sysRunLoginfo);

    /**
     * 依据条件查找 系统日志表 列表
     * @param param
     * @return
     */
    public List<SysRunLoginfo> selectSysRunLoginfoList(Map<String, Object> param);

    /**
     * 依据主键删除 系统日志表 记录
     * @param sysRunLoginfoId
     */
    public void  delSysRunLoginfoById(Integer sysRunLoginfoId);

}
