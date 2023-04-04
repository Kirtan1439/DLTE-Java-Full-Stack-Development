package com.example.jdbctemplate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service

public class FixedDepositServices {

    @Autowired
  private JdbcTemplate jdbcTemplate;

    public List<FixedDeposit> fixedDep(int amount)
    {
        return jdbcTemplate.query("select from * deposits where deposit_amount=?",new Object[]{amount},new DepositMapper());

    }

    class DepositMapper implements RowMapper<FixedDeposit> {

        @Override
        public FixedDeposit mapRow(ResultSet rs, int rowNum) throws SQLException {
           FixedDeposit deposit=new FixedDeposit();
           deposit.setDeposit_id(rs.getInt("deposit_id"));
           deposit.setDeposit_amount(rs.getInt("deposit_amount"));
           deposit.setDeposit_tenure(rs.getInt("deposit_tenure"));
           deposit.setDeposit_date(rs.getDate("deposit_date"));
           deposit.setInterest_rate(rs.getInt("Interest_rate"));
           deposit.setMature_date(rs.getDate("mature_date"));
           deposit.setMature_amount(rs.getInt("mature_amount"));
           deposit.setMode_of_dividant(rs.getString("Mode_of_dividant"));
           return deposit;
        }


}
}
