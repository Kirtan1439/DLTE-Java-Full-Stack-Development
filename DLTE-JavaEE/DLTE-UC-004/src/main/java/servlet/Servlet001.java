package servlet;
import oracle.jdbc.OracleDriver;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "IterateServlet", value = "/iterate")
public class Servlet001 extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try{
            Driver driver=new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
            String query="select * from customer";
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                customer cust = null;
                List<customer> profiles = new ArrayList<customer>();
                while (resultSet.next()) {
                    cust=new customer();
                    cust.setacc_number(resultSet.getInt("acc_number"));
                    cust.setPasscode(resultSet.getString("passcode"));
                    cust.setAcc_holder(resultSet.getString("acc_holder"));
                    cust.setAadhaar(resultSet.getLong("aadhaar"));
                    cust.setPan(resultSet.getString("pan"));
                    cust.setEmail(resultSet.getString("email"));
                    cust.setContact(resultSet.getLong("contact"));
                    cust.setacc_balance(resultSet.getDouble("acc_bal"));
                    InputStream inputStream=resultSet.getBinaryStream("address");
                    byte[] tempBinary=new byte[inputStream.available()];
                    inputStream.read(tempBinary);
                    String address=new String(tempBinary);
                    cust.setAddress(address);
                    profiles.add(cust);
                }
                RequestDispatcher dispatcher=request.getRequestDispatcher("available.jsp");
                request.setAttribute("dbData",profiles);
                dispatcher.forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
