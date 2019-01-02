package com.seer.panel.config.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 多数据源配置 - 公有方法
 * @author : ligangwei / ligangwei@seerbigdata.com
 * @version : 1.0
 * @autheor ligw
 * @date 2018 /9/1 13:58
 */
public class DataSourceContextHolder {

	/**
	 * logger
	 */
	public static Logger logger = LoggerFactory.getLogger(DataSourceContextHolder.class);

	/**
	 * contextHolder
	 */
	private static final ThreadLocal contextHolder = new ThreadLocal<>();

	/**
	 * 设置数据源
	 *
	 * @param dataSourceEnum the data source enum
	 * @author : ligangwei / 2018-12-29
	 */
	public static void setDbType(DataSourceEnum dataSourceEnum) {
		logger.info("设置数据源..."+dataSourceEnum.getValue());
		contextHolder.set(dataSourceEnum.getValue());
	}

	/**
	 * 取得当前数据源
	 *
	 * @return string
	 * @author : ligangwei / 2018-12-29
	 */
	public static String getDbType() {
		logger.info("取得当前数据源..."+ contextHolder.get());
		return (String) contextHolder.get();
	}

	/**
	 * 清除上下文数据
	 *
	 * @author : ligangwei / 2018-12-29
	 */
	public static void clearDbType() {
		logger.info("清除上下文数据..."+ contextHolder.get());
		contextHolder.remove();
	}
}
