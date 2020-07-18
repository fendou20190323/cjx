package com.fendou.moudle.service.impl;

import com.fendou.moudle.model.BackGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: cjx
 * @Date: 2020-07-09 17:45
 * @Description;
 */
@Service
@Transactional
public class DemoBackGoodsImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void query(){
        RowMapper<BackGoods> rowMapper=new RowMapper<BackGoods>() {
            @Override
            public BackGoods mapRow(ResultSet resultSet, int i) throws SQLException {
                return null;
            }
        };
        List<BackGoods> query = jdbcTemplate.query("SELECT * FROM back_goods", rowMapper);
        System.out.println(query);
    }
}
