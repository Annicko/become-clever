package com.bytespaces.datasources;

import java.lang.annotation.*;

/**
 * 动态数据源(default:DataSourceContextHolder.PRIMARY_DATA_SOURCE)
 *
 * @author Annicko
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface DataSource {

    String value() default DataSourceContextHolder.PRIMARY_DATA_SOURCE;

}