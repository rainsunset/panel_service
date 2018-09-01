package com.seer.panel.config.db;

/**
 * @autheor ligw
 * @date 2018/9/1 13:57
 */
public enum DataSourceEnum {

	DB1("db1"), DB2("db2");
	private String value;

	DataSourceEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
