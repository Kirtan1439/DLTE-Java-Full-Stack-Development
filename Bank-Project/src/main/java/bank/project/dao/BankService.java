package bank.project.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

@Service
public class BankService implements BankOperations, UserDetailsService {
    ResourceBundle bundle=ResourceBundle.getBundle("message");
    @Autowired
    public JdbcTemplate jdbcTemplate;
    private Logger logger = LoggerFactory.getLogger(Customer.class);

//    public List<Transaction> listloanAll() {
////logger.info("Gives details regarding the loan scheme"+listloanAll());
//        return jdbcTemplate.query("select * from ", new TransactionMapper());
//    }

    @Override
    public int getAttempts(int id){
             int attempts=jdbcTemplate.queryForObject("select failed_attempts from customer_id=?",Integer.class,id);
             return attempts;
    }

    @Override
    public void decrementAttempts(int id){
        jdbcTemplate.update("update customer set failed_attempts = failed_attempts-1 where customer_id=?",id);
        updateStatus();
    }




    @Override
    public List<Transaction> listDate(String username,String dateFrom, String dateTo) throws ParseException {
        logger.info("listDate has started execution");
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = fmt.parse(dateFrom);
        Date toDate = fmt.parse(dateTo);
        logger.info(fromDate+" "+toDate+" "+username);
        List<Transaction> list = jdbcTemplate.query("select * from account join customer on customer.customer_id = account.customer_id and username=? join transaction on (transaction.txn_from=account.account_number or transaction.txn_to=account.account_number) and txn_date between ? and ?",new TransactionMapper(),username,fromDate,toDate);
        logger.info(list.toString());
        return list;
    }


//    @Override
//    public List<Transaction> listAmount(String username, int amount1, int amount2) throws ParseException {
//
//        return list;
//    }



    @Override
     public void setAttempts(int id ){
        jdbcTemplate.update("update customer set failed_attempts=3 where customer_id=?",id);

     }




//
//    @Override
//    public List<Transaction> listTransactions(String username) {
//        logger.info("listtransaction has started executing");
//        return jdbcTemplate.query("select Txn_Id,Txn_From,Txn_Amount,Txn_Status,Txn_Date,Txn_To from CUSTOMER join TRANSACTION on customer.customer_id = transaction.customer_id where username=?",new TransactionMapper());
//    }


//    @Override
//    public List<Transaction> listOne(String date1, String date2) {
//        return  jdbcTemplate.query("select * from Transaction where Txn_Date BETWEEN '29-07-2020' AND '22-06-2022'",new TransactionMapper());;
//    }




    @Override
    public void updateStatus() {
        jdbcTemplate.update("update customer set customer_status='inactive' where failed-attempts=0");
    }


    @Override
    public List<Transaction> listAmount(String username, int amount1, int amount2) throws ParseException {
        logger.info("listAmount has started execution");
        logger.info(amount1+" "+amount2+" "+username);
        List<Transaction> list = jdbcTemplate.query("select * from account join customer on customer.customer_id = account.customer_id and username=? join transaction on (transaction.txn_from=account.account_number or transaction.txn_to=account.account_number) and txn_amount between ? and ?",new TransactionMapper(),username,amount1,amount2);
        logger.info(list.toString());
        return list;
    }


    @Override
    public List<Customer> listAll() {
        logger.info("Customer list is started executing");
        return jdbcTemplate.query("select * from Customer",new CustomerMapper());
    }

    @Override
    public Customer getByUsername(String username) {
        try {
            Customer customer = jdbcTemplate.queryForObject("select * from CUSTOMER where USERNAME=?", new CustomerMapper(), username);
            return customer;
        } catch (DataAccessException e) {
            return null;
        }

    }
    @Override
    public void incrementFailedAttempts(int id) {
        jdbcTemplate.update("update CUSTOMER set FAILED_ATTEMPTS = FAILED_ATTEMPTS + 1 where CUSTOMER_ID=?",id);
        jdbcTemplate.update("update CUSTOMER set CUSTOMER_STATUS='Inactive' where FAILED_ATTEMPTS=3");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = getByUsername(username);
        if (customer == null) {
            throw new UsernameNotFoundException(bundle.getString("userNotExist"));
        }
        return customer;
    }



    class CustomerMapper implements RowMapper<Customer> {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setCustomer_id(rs.getInt("customer_id"));
            customer.setCustomer_name(rs.getString("customer_name"));
            customer.setCustomer_address(rs.getString("customer_address"));
            customer.setContact(rs.getLong("customer_contact"));
            customer.setCustomer_status(rs.getString("customer_status"));
            customer.setUsername(rs.getString("username"));
            customer.setPassword(rs.getString("password"));
            customer.setFailed_attempts(rs.getInt("failed_attempts"));
            return customer;
        }
    }


    class TransactionMapper implements RowMapper<Transaction>{
       @Override
        public Transaction mapRow(ResultSet rs,int rowNum) throws SQLException{
            Transaction transaction=new Transaction();
            transaction.setTxnId(rs.getInt("Txn_Id"));
            transaction.setTxnFrom(rs.getLong("Txn_From"));
            transaction.setTxnAmount(rs.getInt("Txn_Amount"));
            transaction.setTxnStatus(rs.getString("Txn_Status"));
            transaction.setTxnDate(rs.getString("Txn_Date"));
            transaction.setTxnTo(rs.getLong("Txn_To"));
            return transaction;
        }


    }
}

