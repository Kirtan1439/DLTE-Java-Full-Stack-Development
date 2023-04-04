package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ListOfCustomer {
    private ArrayList<Customer> customers=new ArrayList<>();
}
