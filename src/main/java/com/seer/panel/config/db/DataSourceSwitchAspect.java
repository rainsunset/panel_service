package com.seer.panel.config.db;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 数据源切换切面
 * @author : ligangwei / ligangwei@seerbigdata.com
 * @version : 1.0
 * @date 2018 /9/1 13:58
 */
@Component
@Order(value = -100)
@Aspect
public class DataSourceSwitchAspect {

	/**
	 * logger
	 */
	private static Logger logger = LoggerFactory.getLogger(DataSourceSwitchAspect.class);

	/**
	 * Db 1 aspect.
	 *
	 * @author : ligangwei / 2018-12-29
	 */
	@Pointcut("execution(* com.seer.panel.mapper.db1..*.*(..))")
	private void db1Aspect() {
	}

	/**
	 * Db 2 aspect.
	 *
	 * @author : ligangwei / 2018-12-29
	 */
	@Pointcut("execution(* com.seer.panel.mapper.db2..*.*(..))")
	private void db2Aspect() {
	}

	/**
	 * Db 1.
	 *
	 * @author : ligangwei / 2018-12-29
	 */
	@Before("db1Aspect()")
	public void db1() {
		logger.info(String.format("切换到%s 数据源...",DataSourceEnum.DB1));
		DataSourceContextHolder.setDbType(DataSourceEnum.DB1);
	}

	/**
	 * Db 2.
	 *
	 * @author : ligangwei / 2018-12-29
	 */
	@Before("db2Aspect()")
	public void db2() {
		logger.info(String.format("切换到%s 数据源...",DataSourceEnum.DB2));
		DataSourceContextHolder.setDbType(DataSourceEnum.DB2);
	}

}
