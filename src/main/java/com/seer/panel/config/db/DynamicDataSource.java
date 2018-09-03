package com.seer.panel.config.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
/**
 * @autheor ligw
 * @date 2018/9/1 13:57
 */

public class DynamicDataSource extends AbstractRoutingDataSource {

	/**
	 * * 取得当前使用哪个数据源
	 * @return
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		return  DataSourceContextHolder.getDbType();
	}
}
