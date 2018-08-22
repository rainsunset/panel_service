package com.seer.panel.mapper;

import com.seer.panel.model.RptMachineTotalStatusInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
 @Repository
public interface RptMachineTotalStatusInfoMapper {

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
     * 依据主键删除 机床状态运行时长统计 记录
     * @param rptMachineTotalStatusInfoId
     */
    public void  delRptMachineTotalStatusInfoById(Integer rptMachineTotalStatusInfoId);

}
