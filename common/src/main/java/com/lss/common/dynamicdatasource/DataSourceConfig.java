package com.lss.common.dynamicdatasource;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 主从分离数据源设置
 * @author wangyg
 * */

@Configuration
public class DataSourceConfig {

    @Bean(name = "masterDataSource")
    @ConfigurationProperties(prefix = "spirng.master.datasource")
    public HikariDataSource masterDataSource() {
        return new HikariDataSource();
    }


    @Bean(name = "slaveDataSource")
    @ConfigurationProperties(prefix = "spirng.slave.datasource")
    public HikariDataSource slaveDataSource() {
        return new HikariDataSource();
    }

    //动态数据源
    @Bean(name = "dynamicDataSource")
    //解决互相依赖关系
    @DependsOn({ "masterDataSource", "slaveDataSource"})
    @Primary
    public DataSource getDataSource() {
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSources());
        return dataSource;
    }

    private Map<Object, Object> targetDataSources() {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceType.MASTER.getType(), masterDataSource());
        targetDataSources.put(DataSourceType.SLAVE.getType(), slaveDataSource());
        return targetDataSources;
    }
}
