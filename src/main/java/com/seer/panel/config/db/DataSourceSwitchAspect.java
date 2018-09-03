package com.seer.panel.config.db;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @autheor ligw
 * @date 2018/9/1 13:58
 */
@Component
@Order(value = -100)
@Aspect
public class DataSourceSwitchAspect {
	@Pointcut("execution(* com.seer.panel.mapper.db1..*.*(..))")
	private void db1Aspect() {
	}

	@Pointcut("execution(* com.seer.panel.mapper.db2..*.*(..))")
	private void db2Aspect() {
	}

	@Before("db1Aspect()")
	public void db1() {
		System.out.println(String.format("切换到%s 数据源...",DataSourceEnum.DB1));
		DataSourceContextHolder.setDbType(DataSourceEnum.DB1);
	}

	@Before("db2Aspect()")
	public void db2() {
		System.out.println(String.format("切换到%s 数据源...",DataSourceEnum.DB2));
		DataSourceContextHolder.setDbType(DataSourceEnum.DB2);
	}

}
