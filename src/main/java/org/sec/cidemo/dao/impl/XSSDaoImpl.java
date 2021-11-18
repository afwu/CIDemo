package org.sec.cidemo.dao.impl;

import org.sec.cidemo.dao.XSSDao;
import org.sec.cidemo.model.Message;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class XSSDaoImpl implements XSSDao {

    private final JdbcTemplate jdbcTemplate;

    public XSSDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Message get(int id) {
        List<Message> message = jdbcTemplate.query("select * from message where id = ?",
                new BeanPropertyRowMapper(Message.class), id);
        if (message.size() < 1) {
            return null;
        } else {
            return message.get(0);
        }
    }

    @Override
    public String insert(String data) {
        int result = jdbcTemplate.update("insert into message (data) values (?)", data);
        if (result > 0) {
            return "success";
        } else {
            return "error";
        }
    }
}
