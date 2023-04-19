package bank.project.app;

import bank.project.dao.BankService;
import bank.project.dao.Customer;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;
import org.slf4j.Logger;



@Configuration
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Autowired
    BankService bankService;
    ResourceBundle bundle =ResourceBundle.getBundle("message");
    Logger logger= LoggerFactory.getLogger(Customer.class);


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        ResourceBundle bundle = ResourceBundle.getBundle("messages");
        String userName=request.getParameter("username");
        Customer customer= bankService.getByUsername(userName);


        if(customer!=null) {
            bankService.decrementAttempts(customer.getCustomer_id());
            int attempts = bankService.getAttempts(customer.getCustomer_id());
            if(attempts==2){
                logger.info(bundle.getString("inPass")+bundle.getString("attempt1"));
                super.setDefaultFailureUrl("/web/?error=" + bundle.getString("inPass")+bundle.getString("attempt1"));

            }
            else if(attempts==1){
                logger.info(bundle.getString("inPass")+bundle.getString("attempt2"));
                super.setDefaultFailureUrl("/web/?error=" + bundle.getString("inPass")+bundle.getString("attempt2"));
            }
            else {
                logger.info(bundle.getString("inactive"));
                super.setDefaultFailureUrl("/web/?error=" + bundle.getString("inactive"));
            }
        exception = new LockedException("Incorrect Password");
         super.setDefaultFailureUrl("/web/?error="+"Incorrect Password..");
        }
        else {
            logger.info(exception.toString());
            super.setDefaultFailureUrl("/web/?error=" +bundle.getString("notExist") );
        }
        super.onAuthenticationFailure(request, response, exception);
    }

    }


