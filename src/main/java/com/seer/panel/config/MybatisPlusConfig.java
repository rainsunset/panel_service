package com.seer.panel.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.seer.panel.config.db.DataSourceEnum;
import com.seer.panel.config.db.DynamicDataSource;
import org.apache.ibatis.plugin.Interceptor;

import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Profile;

/**
 * myBatis 多数据源配置
 * @author : ligangwei / ligangwei@seerbigdata.com
 * @version : 1.0
 * @date 2018 /9/1 13:55
 */
@Configuration
@MapperScan(value ={"com.seer.panel.mapper.db*"})
public class MybatisPlusConfig {

	/**
	 * 分页插件，自动识别数据库类型 多租户，请参考官网【插件扩展】
	 *
	 * @return pagination interceptor
	 * @author : ligangwei / 2018-12-29
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
		return paginationInterceptor;
	}

	/**
	 * SQL执行效率插件
	 *
	 * @return the performance interceptor
	 * @author : ligangwei / 2018-12-29
	 */
	@Bean
	@Profile({"dev","test"})// 设置 dev test 环境开启
	public PerformanceInterceptor performanceInterceptor() {
		PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
		performanceInterceptor.setMaxTime(1000);
		performanceInterceptor.setFormat(true);
		return performanceInterceptor;
	}

	/**
	 * Db 1 data source.
	 *
	 * @return the data source
	 * @author : ligangwei / 2018-12-29
	 */
	@Bean(name = "db1")
	@ConfigurationProperties(prefix = "spring.datasource.druid.db1")
	public DataSource db1() {
		return DruidDataSourceBuilder.create().build();
	}

	/**
	 * Db 2 data source.
	 *
	 * @return the data source
	 * @author : ligangwei / 2018-12-29
	 */
	@Bean(name = "db2")
	@ConfigurationProperties(prefix = "spring.datasource.druid.db2")
	public DataSource db2() {
		return DruidDataSourceBuilder.create().build();
	}

	/**
	 * 动态数据源配置
	 *
	 * @param db1 the db 1
	 * @param db2 the db 2
	 * @return the data source
	 * @author : ligangwei / 2018-12-29
	 */
	@Bean(name ="datasource")
	@Primary
	public DataSource multipleDataSource(@Qualifier("db1") DataSource db1,
			@Qualifier("db2") DataSource db2) {
		DynamicDataSource dynamicDataSource = new DynamicDataSource();
		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put(DataSourceEnum.DB1.getValue(), db1);
		targetDataSources.put(DataSourceEnum.DB2.getValue(), db2);
		//添加数据源
		dynamicDataSource.setTargetDataSources(targetDataSources);
		//设置默认数据源
		dynamicDataSource.setDefaultTargetDataSource(db1);
		return dynamicDataSource;
	}

	/**
	 * Sql session factory mybatis sql session factory bean.
	 *
	 * @return the mybatis sql session factory bean
	 * @throws Exception the exception
	 * @author : ligangwei / 2018-12-29
	 */
	@Bean("sqlSessionFactory")
	@ConfigurationProperties(prefix = "mybatis-plus")
	@ConfigurationPropertiesBinding()
	@Primary
	public MybatisSqlSessionFactoryBean sqlSessionFactory() throws Exception {
		MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(multipleDataSource(db1(), db2()));
		MybatisConfiguration configuration = new MybatisConfiguration();
		configuration.setJdbcTypeForNull(JdbcType.NULL);
		configuration.setMapUnderscoreToCamelCase(true);
		configuration.setCacheEnabled(false);
		sqlSessionFactory.setConfiguration(configuration);
		//添加分页功能
		sqlSessionFactory.setPlugins(new Interceptor[]{
				paginationInterceptor()
		});
		return sqlSessionFactory;
	}
}
