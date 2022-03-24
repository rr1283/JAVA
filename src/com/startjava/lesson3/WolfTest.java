//package com.startjava.wolf;

public class WolfTest {

  public static void main(String[] args) {
 
    Wolf WolfOne = new Wolf();  
 
    System.out.println("name = " + WolfOne.getName());

    WolfOne.setName("");

    System.out.println("name = " + WolfOne.getName());

    }
}