package com.startjava.wolf;

public class Wolf {

    private char sex = 'M';
    private String name = "Alex";
    private int weith = 100;
    private int age = 5;

    public String getName() {
      return name;
    }
 
    void setName(String name) {
        if(name == "" ) {
            System.out.println("  ");
        } 
        else if(name == "8" ) {
            System.out.println("== 8");      
        } 
        else {
            this.name = name;
        }
    }

}