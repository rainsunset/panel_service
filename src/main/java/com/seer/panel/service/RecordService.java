package com.seer.panel.service;

import com.github.pagehelper.PageInfo;
import com.seer.panel.model.Record;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
public interface RecordService {

    /**
     * 添加 
     * @param record
     */
    public void  addRecord(Record record);

    /**
     * 依据主键更新 
     * @param record
     */
    public void  updateRecordById(Record record);

    /**
     * 依据条件查找  列表
     * @param param
     * @return
     */
    public List<Record> selectRecordList(Map<String, Object> param);

    /**
     * 依据条件查找分页  列表
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<Record> getRecordPageTurn(Map<String, Object> param, int pageNo, int pageSize);

    /**
     * 依据Id查找  详情
     * @param recordId
     * @return
     */
    public Record getRecordById(Integer recordId);

    /**
     * 依据Id删除  记录
     * @param recordId
     */
    public void delRecordById(Integer recordId);
}
