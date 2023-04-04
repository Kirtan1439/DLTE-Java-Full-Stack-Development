package org.example;



import java.util.List;

public interface Operations {
    public String insertDb(Student student);
    List<Student> fetchStudent();
   List<Address> fetchAddress(int reg_no);
   public String deleteDb(int reg_no) throws IdNotfoundException;
   public int makeConnection();

}
