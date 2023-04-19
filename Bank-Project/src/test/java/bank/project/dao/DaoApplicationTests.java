package bank.project.dao;

import bank.project.dao.BankService;
import bank.project.dao.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class DaoApplicationTests {
    @Mock
    JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BankService bankService;


    @Test
    public void testGetUsername() {

        Customer customer = new Customer(101,"karthik","121-mysoreRoad","Active",43463465,"karthik","karthik@123",0);
        String uname = "karthik";

        when(jdbcTemplate.queryForObject(eq("select * from Customer where username=?"),any(RowMapper.class),eq(uname)))
                .thenReturn(customer);


        Customer customer1 = bankService.getByUsername("karthik");
        assertEquals(customer.getUsername(),uname);
    }
 @Test
    public void testListAll(){ Customer customer1=new Customer(1324,"kiran","101-Road,CDE street","Active",34568786,"kiran","kiran@123",0);
     Customer customer2=new Customer(54678,"varun","111-Road,YTD street","Active",897867567,"varun","varun@123",0);
     Customer customer3=new Customer(6768,"ashish","189-Road,IIJ street","Active",9009707,"ashish","ashish@123",2);
     List<Customer> tempList=Stream.of(customer1,customer2,customer3).collect(Collectors.toList());

     when(jdbcTemplate.query(eq("select * from Customer"),any(RowMapper.class))).thenReturn(tempList);
     assertEquals(customer1,bankService.listAll().get(0));
 }
    @Test
    public void testListDate() throws ParseException {
        Transaction t1 = new Transaction(101,456789876,20000,"Success","02-02-2022",23456767);
        Transaction t2 = new Transaction(111, 3465768, 50000, "Success", "01-01-2001",43567);
        Transaction t3 =  new Transaction(121,876879656,10000,"Success","04-01-2002",8067679);
        List<Transaction> tempList = Stream.of(t1,t2,t3).collect(Collectors.toList());
        String str = "Kirtan";
        String date1="2022-02-02";
        String date2="2023-01-02";
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = fmt.parse(date1);
        Date toDate = fmt.parse(date2);
        when(jdbcTemplate.query(eq("select * from account join customer on customer.customer_id = account.customer_id and username=? join transaction on (transaction.txn_from=account.account_number or transaction.txn_to=account.account_number) and txn_date between ? and ?"), any(RowMapper.class),eq(str),eq(fromDate),eq(toDate))).thenReturn(tempList);
        assertEquals(tempList, bankService.listDate(str,date1,date2));

    }

    @Test
    public void testListAmount() throws ParseException {
        Transaction t1 = new Transaction(101,456789876,20000,"Success","02-02-2022",23456767);
        Transaction t2 = new Transaction(111, 3465768, 50000, "Success", "01-01-2001",43567);
        Transaction t3 =  new Transaction(121,876879656,10000,"Success","04-01-2002",8067679);
        List<Transaction> tempList = Stream.of(t1,t2,t3).collect(Collectors.toList());
        String str="Kiran";
        int amount1=5465;
        int amount2=4566;
        when(jdbcTemplate.query(eq("select * from account join customer on customer.customer_id = account.customer_id and username=? join transaction on (transaction.txn_from=account.account_number or transaction.txn_to=account.account_number) and txn_amount between ? and ?"),any(RowMapper.class),eq(str),eq(amount1),eq(amount2))).thenReturn(tempList);
        assertEquals(tempList,bankService.listAmount(str,amount1,amount2));
    }

}

