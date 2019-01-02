package com.seer.panel.mapper.db2;

import com.seer.panel.model.ProdLineProdReport;
import com.seer.panel.view.ProductLineDTO;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author dgd123 : ligangwei / ligangwei@seerbigdata.com
 * @version : 1.0
 * @since 2018 -02-10
 */
@Repository
public interface MesInfoMapper {

    /**
     * Get prod line prod report prod line prod report.
     *
     * @param productLineDTO the product line dto
     * @return the prod line prod report
     * @throws Exception the exception
     * @author : ligangwei / 2018-12-29
     */
    public ProdLineProdReport getProdLineProdReport(ProductLineDTO productLineDTO)throws Exception;

}
