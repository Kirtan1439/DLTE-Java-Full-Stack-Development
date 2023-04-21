package bank.project.app;

import bank.project.dao.BankService;
import bank.project.dao.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import project.transaction.soap.ListTransactionRequest;
import project.transaction.soap.ListTransactionResponse;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Endpoint
public class BankEndpoint {
    private static final String url = "http://soap.transaction.project";
    private Logger logger = LoggerFactory.getLogger(BankEndpoint.class);

    @Autowired
    private BankService bankService;
    //soap end point to view customer details

    @PayloadRoot(namespace = url, localPart = "listTransactionRequest")
    @ResponsePayload
    public ListTransactionResponse listTransactionResponse(@RequestPayload ListTransactionRequest listTransactionRequest) throws ParseException {
//        logger.trace(listTransactionRequest. + " received");
        ListTransactionResponse response = new ListTransactionResponse();
//        project.transaction.soap.Transaction transaction=new Transaction();
        List<Transaction> transactionList=bankService.listAmountRange(listTransactionRequest.getUsername(),listTransactionRequest.getAmount1(),listTransactionRequest.getAmount2());
        List<project.transaction.soap.Transaction> list=new ArrayList<>();


     Iterator<Transaction> iterator=transactionList.iterator();
      while (iterator.hasNext()){
          project.transaction.soap.Transaction transaction=new project.transaction.soap.Transaction();
          BeanUtils.copyProperties(iterator.next(),transaction);
          list.add(transaction);
      }

     response.getTransaction().addAll(list);
      logger.info(response.toString());
        return response;
    }
}