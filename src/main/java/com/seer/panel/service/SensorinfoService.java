package com.seer.panel.service;

import com.github.pagehelper.PageInfo;
import com.seer.panel.model.Sensorinfo;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
public interface SensorinfoService {

    /**
     * 添加 传感器信息
     * @param sensorinfo
     */
    public void  addSensorinfo(Sensorinfo sensorinfo);

    /**
     * 依据主键更新 传感器信息
     * @param sensorinfo
     */
    public void  updateSensorinfoById(Sensorinfo sensorinfo);

    /**
     * 依据条件查找 传感器信息 列表
     * @param param
     * @return
     */
    public List<Sensorinfo> selectSensorinfoList(Map<String, Object> param);

    /**
     * 依据条件查找分页 传感器信息 列表
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<Sensorinfo> getSensorinfoPageTurn(Map<String, Object> param, int pageNo, int pageSize);

    /**
     * 依据Id查找 传感器信息 详情
     * @param sensorinfoId
     * @return
     */
    public Sensorinfo getSensorinfoById(Integer sensorinfoId);

    /**
     * 依据Id删除 传感器信息 记录
     * @param sensorinfoId
     */
    public void delSensorinfoById(Integer sensorinfoId);
}
