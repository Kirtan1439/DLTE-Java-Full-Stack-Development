package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BankService {
    @Autowired
    public JdbcTemplate jdbcTemplate;

    public List<Customer> listAll(){
        return jdbcTemplate.query("select * from Customer",new CustomerMapper());
    }
    class CustomerMapper implements RowMapper<Customer> {

        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setCustomer_id(rs.getInt("customer_id"));
            customer.getCustomer_name(rs.getString("customer_name"));
            customer.setCustomer_address(rs.getString("customer_address"));
            customer.setContact(rs.getInt("contact"));
            customer.setUsername(rs.getString("username"));
            customer.setPassword(rs.getString("password"));
            return customer;
        }
    }
}
