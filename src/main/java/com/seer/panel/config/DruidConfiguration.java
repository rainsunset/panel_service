package com.seer.panel.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * alibaba 数据库连接池监控配置
 * @author : ligangwei / ligangwei@seerbigdata.com
 * @version : 1.0
 */
@Configuration
public class DruidConfiguration {

	/**
	 * Start view servlet servlet registration bean.
	 *
	 * @return the servlet registration bean
	 * @author : ligangwei / 2018-12-29
	 */
	@Bean
	public ServletRegistrationBean startViewServlet(){
		// 监控查看地址 http://ip：port/projectName/druid/index.html
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
		// IP白名单
		servletRegistrationBean.addInitParameter("allow","127.0.0.1");
		// IP黑名单(共同存在时，deny优先于allow)
		// servletRegistrationBean.addInitParameter("deny","127.0.0.1");
		//控制台管理用户
		servletRegistrationBean.addInitParameter("loginUsername","admin");
		servletRegistrationBean.addInitParameter("loginPassword","123456");
		//是否能够重置数据
		servletRegistrationBean.addInitParameter("resetEnable","false");
		return servletRegistrationBean;
	}

	/**
	 * Stat filter filter registration bean.
	 *
	 * @return the filter registration bean
	 * @author : ligangwei / 2018-12-29
	 */
	@Bean
	public FilterRegistrationBean statFilter(){
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
		//添加过滤规则
		filterRegistrationBean.addUrlPatterns("/*");
		//忽略过滤的格式
		filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return filterRegistrationBean;
	}
}
