package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Scanner;

public class GenericswithStrings {
    public static void main(String[] args) {
        Generics<String> objectString=new Generics<String>();
        objectString.()
        System.out.println();



    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor

class Generics<T>{
    private T[]  objects;
    public T[]  getObjects(){
        return objects;

    }



}