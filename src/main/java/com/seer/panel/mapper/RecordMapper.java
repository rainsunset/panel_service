package com.seer.panel.mapper;

import com.seer.panel.model.Record;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
 @Repository
public interface RecordMapper {

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
     * 依据主键删除  记录
     * @param recordId
     */
    public void  delRecordById(Integer recordId);

}
