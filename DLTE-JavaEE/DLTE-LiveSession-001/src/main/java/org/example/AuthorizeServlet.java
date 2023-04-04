package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(name = "AuthorizeServlet",value = "/authorized")
public class AuthorizeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        DAOoperations daOoperations=new DAOoperations();
        daOoperations.authenticate(username,password);
        System.out.println(username);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
