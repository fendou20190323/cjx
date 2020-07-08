package com.lss.common.dynamicdatasource;

import com.lss.common.annotation.DataSource;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-1)
public class DataSourceAspect{

    @Before(value = "@annotation(dataSource)")
    public void dataSourcePoint(DataSource dataSource) {
        DynamicDataSourceHolder.putDataSource(dataSource.value());
    }
}
