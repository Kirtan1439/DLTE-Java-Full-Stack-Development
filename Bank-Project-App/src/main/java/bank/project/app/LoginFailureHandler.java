package bank.project.app;

import bank.project.dao.BankService;
import bank.project.dao.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@Component
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

    @Autowired
    private BankService bankService;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String userName = request.getParameter("username");
  //      String passWord = request.getParameter("password");
        Customer customer = bankService.getByUsername(userName);
        if (customer == null) {

            exception = new LockedException(resourceBundle.getString("user"));
            super.setDefaultFailureUrl("/web/login?error=" + resourceBundle.getString("user"));
        } else {
            if (customer.getCustomer_status().equalsIgnoreCase("inactive")) {
                logger.info(resourceBundle.getString("unsuccessfull"));
                exception = new LockedException(resourceBundle.getString("unsuccessfull"));
                super.setDefaultFailureUrl("/web/login?error=" + resourceBundle.getString("unsuccessfull"));
            } else {
                bankService.incrementFailedAttempts(customer.getCustomer_id());
                //GEtting the number of attempts the user is left with
                int attempts = bankService.getAttempts(customer.getCustomer_id());
                if (attempts == 1) {
                    logger.info(resourceBundle.getString("incorrect_pw") + resourceBundle.getString("attempt2"));
                    exception = new LockedException(resourceBundle.getString("attempt2") + resourceBundle.getString("incorrect_pw"));
                    super.setDefaultFailureUrl("/web/login?error=" + resourceBundle.getString("incorrect_pw") + resourceBundle.getString("attempt2"));
                } else if (attempts == 2) {
                    logger.info(resourceBundle.getString("incorrect_pw") + resourceBundle.getString("attempt1"));
                    exception = new LockedException(resourceBundle.getString("attempt1") + resourceBundle.getString("incorrect_pw"));
                    super.setDefaultFailureUrl("/web/login?error=" + resourceBundle.getString("incorrect_pw") + resourceBundle.getString("attempt1"));
                } else {
                    logger.info(resourceBundle.getString("unsuccessfull"));
                    exception = new LockedException(resourceBundle.getString("unsuccessfull"));
                    bankService.updateStatus();
                    super.setDefaultFailureUrl("/web/login?error=" + resourceBundle.getString("unsuccessfull"));
                }
            }
        }
        super.onAuthenticationFailure(request, response, exception);

    }
}