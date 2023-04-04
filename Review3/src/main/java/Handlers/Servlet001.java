package Handlers;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "InsertServlet", value="/insertion")
public class Servlet001 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        int reg_no = Integer.parseInt(request.getParameter("reg_no"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");

        String cDoor = request.getParameter("door_no");
        String cStreet = request.getParameter("street");
        String cCity = request.getParameter("city");
        int cPincode = Integer.parseInt(request.getParameter("pincode"));

        String pDoor = request.getParameter("permanent_door_no");
        String pStreet = request.getParameter("permanent_street");
        String pCity = request.getParameter("permanent_city");
        int pPincode = Integer.parseInt(request.getParameter("permanent_pincode"));

        Student student = new Student(reg_no, name, age, email);
        student.getAddresses().add(new Address(cDoor, cStreet, cCity, cPincode,"Current"));
        student.getAddresses().add(new Address(pDoor, pStreet, pCity, pPincode,"Permanent"));
        DBOoperations dbOperations = new DBOoperations();
        dbOperations.insertDB(student);

        logger.log(Level.INFO, "Insertion Successful");
        RequestDispatcher dispatcher = request.getRequestDispatcher("fetch.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}