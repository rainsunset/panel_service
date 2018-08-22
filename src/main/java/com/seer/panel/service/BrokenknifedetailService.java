package com.seer.panel.service;

import com.github.pagehelper.PageInfo;
import com.seer.panel.model.Brokenknifedetail;

import java.util.List;
import java.util.Map;

/**
 *
 * @author whaosoft
 *
 */
public interface BrokenknifedetailService {

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
     * 依据条件查找分页 断刀记录明细 列表
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<Brokenknifedetail> getBrokenknifedetailPageTurn(Map<String, Object> param, int pageNo, int pageSize);

    /**
     * 依据Id查找 断刀记录明细 详情
     * @param brokenknifedetailId
     * @return
     */
    public Brokenknifedetail getBrokenknifedetailById(Integer brokenknifedetailId);

    /**
     * 依据Id删除 断刀记录明细 记录
     * @param brokenknifedetailId
     */
    public void delBrokenknifedetailById(Integer brokenknifedetailId);
}
