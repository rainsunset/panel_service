package com.seer.panel.service;

import com.github.pagehelper.PageInfo;
import com.seer.panel.model.SysRunLoginfo;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
public interface SysRunLoginfoService {

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
     * 依据条件查找分页 系统日志表 列表
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<SysRunLoginfo> getSysRunLoginfoPageTurn(Map<String, Object> param, int pageNo, int pageSize);

    /**
     * 依据Id查找 系统日志表 详情
     * @param sysRunLoginfoId
     * @return
     */
    public SysRunLoginfo getSysRunLoginfoById(Integer sysRunLoginfoId);

    /**
     * 依据Id删除 系统日志表 记录
     * @param sysRunLoginfoId
     */
    public void delSysRunLoginfoById(Integer sysRunLoginfoId);
}
