package com.seer.panel.mapper.db2;

import com.seer.panel.model.ProdLineProdReport;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dgd123
 * @since 2018-02-10
 */
@Repository
public interface MesInfoMapper {

    public ProdLineProdReport getProdLineProdReport()throws Exception;

}
