package com.seer.panel.mapper;

import com.seer.panel.model.Machinealarmhistory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
 @Repository
public interface MachinealarmhistoryMapper {

    /**
     * 添加 机床报警历史记录
     * @param machinealarmhistory
     */
    public void  addMachinealarmhistory(Machinealarmhistory machinealarmhistory);

    /**
     * 依据主键更新 机床报警历史记录
     * @param machinealarmhistory
     */
    public void  updateMachinealarmhistoryById(Machinealarmhistory machinealarmhistory);

    /**
     * 依据条件查找 机床报警历史记录 列表
     * @param param
     * @return
     */
    public List<Machinealarmhistory> selectMachinealarmhistoryList(Map<String, Object> param);

    /**
     * 依据主键删除 机床报警历史记录 记录
     * @param machinealarmhistoryId
     */
    public void  delMachinealarmhistoryById(Integer machinealarmhistoryId);

}
