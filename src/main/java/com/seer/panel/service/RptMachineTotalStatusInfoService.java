package com.seer.panel.service;

import com.github.pagehelper.PageInfo;
import com.seer.panel.model.RptMachineTotalStatusInfo;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
public interface RptMachineTotalStatusInfoService {

    /**
     * 添加 机床状态运行时长统计
     * @param rptMachineTotalStatusInfo
     */
    public void  addRptMachineTotalStatusInfo(RptMachineTotalStatusInfo rptMachineTotalStatusInfo);

    /**
     * 依据主键更新 机床状态运行时长统计
     * @param rptMachineTotalStatusInfo
     */
    public void  updateRptMachineTotalStatusInfoById(RptMachineTotalStatusInfo rptMachineTotalStatusInfo);

    /**
     * 依据条件查找 机床状态运行时长统计 列表
     * @param param
     * @return
     */
    public List<RptMachineTotalStatusInfo> selectRptMachineTotalStatusInfoList(Map<String, Object> param);

    /**
     * 依据条件查找分页 机床状态运行时长统计 列表
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<RptMachineTotalStatusInfo> getRptMachineTotalStatusInfoPageTurn(Map<String, Object> param, int pageNo, int pageSize);

    /**
     * 依据Id查找 机床状态运行时长统计 详情
     * @param rptMachineTotalStatusInfoId
     * @return
     */
    public RptMachineTotalStatusInfo getRptMachineTotalStatusInfoById(Integer rptMachineTotalStatusInfoId);

    /**
     * 依据Id删除 机床状态运行时长统计 记录
     * @param rptMachineTotalStatusInfoId
     */
    public void delRptMachineTotalStatusInfoById(Integer rptMachineTotalStatusInfoId);
}
