package com.seer.panel.mapper;

import com.seer.panel.model.Sensorinfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
 @Repository
public interface SensorinfoMapper {

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
     * 依据主键删除 传感器信息 记录
     * @param sensorinfoId
     */
    public void  delSensorinfoById(Integer sensorinfoId);

}
