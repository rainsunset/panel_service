package com.seer.panel.annotation;

/**
 * @autheor ligw
 * @date 2018/9/1 18:08
 */

import com.seer.panel.config.db.DataSourceEnum;
import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
	DataSourceEnum value() default DataSourceEnum.DB1;
}
