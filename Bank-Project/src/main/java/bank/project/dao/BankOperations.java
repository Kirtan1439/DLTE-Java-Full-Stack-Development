package bank.project.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BankOperations {
    List<Customer> listAll();
    public Customer getByUsername(String username);
    public void incrementFailedAttempts(int id);
    public int getAttempts(int id);
    public void decrementAttempts(int id);

    List<Transaction> listDate(String username,String dateFrom, String dateTo) throws ParseException;

    public void updateStatus();

    //List<Transaction> listAmount(String username, int TxnAmount) throws ParseException;

    List<Transaction> listAmount(String username, int amount1, int amount2) throws ParseException;

    public void setAttempts(int id );
//    List<Transaction> listTransactions(String username);
//    public List<Transaction> callListOfTransaction();

}
