package com.seer.panel.config.db;

/**
 * 数据源枚举
 * @author : ligangwei / ligangwei@seerbigdata.com
 * @version : 1.0
 * @date 2018 /9/1 13:57
 */
public enum DataSourceEnum {

	/**
	 * Db 1 data source enum.
	 */
	DB1("db1"),
	/**
	 * Db 2 data source enum.
	 */
	DB2("db2");
	/**
	 * Value
	 */
	private String value;

	/**
	 * Data source enum.
	 *
	 * @param value the value
	 */
	DataSourceEnum(String value) {
		this.value = value;
	}

	/**
	 * Get value string.
	 *
	 * @return the string
	 * @author : ligangwei / 2018-12-29
	 */
	public String getValue() {
		return value;
	}

}
