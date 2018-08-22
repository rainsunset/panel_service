package com.seer.panel.mapper;

import com.seer.panel.model.Brokenknifedetail;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
 @Repository
public interface BrokenknifedetailMapper {

    /**
     * 添加 断刀记录明细
     * @param brokenknifedetail
     */
    public void  addBrokenknifedetail(Brokenknifedetail brokenknifedetail);

    /**
     * 依据主键更新 断刀记录明细
     * @param brokenknifedetail
     */
    public void  updateBrokenknifedetailById(Brokenknifedetail brokenknifedetail);

    /**
     * 依据条件查找 断刀记录明细 列表
     * @param param
     * @return
     */
    public List<Brokenknifedetail> selectBrokenknifedetailList(Map<String, Object> param);

    /**
     * 依据主键删除 断刀记录明细 记录
     * @param brokenknifedetailId
     */
    public void  delBrokenknifedetailById(Integer brokenknifedetailId);

}
