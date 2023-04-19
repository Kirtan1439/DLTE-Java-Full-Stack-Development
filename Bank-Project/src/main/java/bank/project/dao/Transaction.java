package bank.project.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Transaction {

    private  int TxnId;
    private long TxnFrom;
    private int TxnAmount;
    private String TxnStatus;
    private String TxnDate;
    private long TxnTo;

    public Transaction(int txnId, long txnFrom, int txnAmount, String txnStatus, String txnDate, long txnTo) {
        TxnId = txnId;
        TxnFrom = txnFrom;
        TxnAmount = txnAmount;
        TxnStatus = txnStatus;
        TxnDate = txnDate;
        TxnTo = txnTo;
    }

    public Transaction() {
    }

    public int getTxnId() {
        return TxnId;
    }

    public long getTxnFrom() {
        return TxnFrom;
    }

    public int getTxnAmount() {
        return TxnAmount;
    }

    public String getTxnStatus() {
        return TxnStatus;
    }

    public String getTxnDate() {
        return TxnDate;
    }

    public long getTxnTo() {
        return TxnTo;
    }

    public void setTxnId(int txnId) {
        TxnId = txnId;
    }

    public void setTxnFrom(long txnFrom) {
        TxnFrom = txnFrom;
    }

    public void setTxnAmount(int txnAmount) {
        TxnAmount = txnAmount;
    }

    public void setTxnStatus(String txnStatus) {
        TxnStatus = txnStatus;
    }

    public void setTxnDate(String txnDate) {
        TxnDate = txnDate;
    }

    public void setTxnTo(long txnTo) {
        TxnTo = txnTo;
    }


//
//    @Override
//    public String toString() {
//        return "Transaction{" +
//                "TxnId=" + TxnId +
//                ", TxnFrom=" + TxnFrom +
//                ", TxnAmount=" + TxnAmount +
//                ", TxnStatus='" + TxnStatus + '\'' +
//                ", TxnDate=" + TxnDate +
//                ", TxnTo=" + TxnTo +
//                '}';
//    }
}
