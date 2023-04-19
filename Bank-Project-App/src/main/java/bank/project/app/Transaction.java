package bank.project.app;

public class Transaction {

    private  int TxnId;
    private long TxnFrom;
    private int TxnAmount;
    private String TxnStatus;
    private String TxnDate;
    private long TxnTo;

    public int getTxnId() {
        return TxnId;
    }

    public void setTxnId(int txnId) {
        TxnId = txnId;
    }

    public long getTxnFrom() {
        return TxnFrom;
    }

    public void setTxnFrom(long txnFrom) {
        TxnFrom = txnFrom;
    }

    public int getTxnAmount() {
        return TxnAmount;
    }

    public void setTxnAmount(int txnAmount) {
        TxnAmount = txnAmount;
    }

    public String getTxnStatus() {
        return TxnStatus;
    }

    public void setTxnStatus(String txnStatus) {
        TxnStatus = txnStatus;
    }

    public String getTxnDate() {
        return TxnDate;
    }

    public void setTxnDate(String txnDate) {
        TxnDate = txnDate;
    }

    public long getTxnTo() {
        return TxnTo;
    }

    public void setTxnTo(long txnTo) {
        TxnTo = txnTo;
    }
}
