package com.seer.panel.service;

import com.github.pagehelper.PageInfo;
import com.seer.panel.model.Machinealarmhistory;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
public interface MachinealarmhistoryService {

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
     * 依据条件查找分页 机床报警历史记录 列表
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<Machinealarmhistory> getMachinealarmhistoryPageTurn(Map<String, Object> param, int pageNo, int pageSize);

    /**
     * 依据Id查找 机床报警历史记录 详情
     * @param machinealarmhistoryId
     * @return
     */
    public Machinealarmhistory getMachinealarmhistoryById(Integer machinealarmhistoryId);

    /**
     * 依据Id删除 机床报警历史记录 记录
     * @param machinealarmhistoryId
     */
    public void delMachinealarmhistoryById(Integer machinealarmhistoryId);
}
