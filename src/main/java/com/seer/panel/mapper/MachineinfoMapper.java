package com.seer.panel.mapper;

import com.seer.panel.model.Machineinfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
 @Repository
public interface MachineinfoMapper {

    /**
     * 添加 机床信息表
     * @param machineinfo
     */
    public void  addMachineinfo(Machineinfo machineinfo);

    /**
     * 依据主键更新 机床信息表
     * @param machineinfo
     */
    public void  updateMachineinfoById(Machineinfo machineinfo);

    /**
     * 依据条件查找 机床信息表 列表
     * @param param
     * @return
     */
    public List<Machineinfo> selectMachineinfoList(Map<String, Object> param);

    /**
     * 依据主键删除 机床信息表 记录
     * @param machineinfoId
     */
    public void  delMachineinfoById(Integer machineinfoId);

}
