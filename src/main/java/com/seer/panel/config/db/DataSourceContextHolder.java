package com.seer.panel.config.db;

/**
 * @autheor ligw
 * @date 2018/9/1 13:58
 */
public class DataSourceContextHolder {
	private static final ThreadLocal contextHolder = new ThreadLocal<>();
	/**
	 * 设置数据源
	 * @param dataSourceEnum
	 */
	public static void setDbType(DataSourceEnum dataSourceEnum) {
		System.out.println("设置数据源..."+dataSourceEnum.getValue());
		contextHolder.set(dataSourceEnum.getValue());
	}

	/**
	 * 取得当前数据源
	 * @return
	 */
	public static String getDbType() {
		System.out.println("取得当前数据源..."+ contextHolder.get());
		return (String) contextHolder.get();
	}

	/**
	 * 清除上下文数据
	 */
	public static void clearDbType() {
		System.out.println("清除上下文数据..."+ contextHolder.get());
		contextHolder.remove();
	}
}
