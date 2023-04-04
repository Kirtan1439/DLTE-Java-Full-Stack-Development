package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Customer {
    private int Customer_Id,Customer_pin,Limit,Mobile;
    private String Cutomer_Name,Customer_Status,Pan;
    private Date Expriry_Date;
    private long Acc_Number,Addhar;





}
