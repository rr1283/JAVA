package com.startjava.lesson2;

public class WolfTest {

  public static void main(String[] args) {
 
    Wolf WolfOne = new Wolf();  
 
    System.out.println("name = " + WolfOne.name);
    WolfOne.name = "Mulan";
    System.out.println("name = " + WolfOne.name);
    System.out.println("Hunter = " + WolfOne.Hunter()); 

    }
}