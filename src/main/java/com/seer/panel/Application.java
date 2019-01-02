package com.seer.panel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author : ligangwei / ligangwei@seerbigdata.com
 * @version : 1.0
 */
@SpringBootApplication
@MapperScan("com.seer.panel.mapper.db*")
@EnableTransactionManagement
public class Application {

	/**
	 * @param args the input arguments
	 * @author : ligangwei / 2018-12-29
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
