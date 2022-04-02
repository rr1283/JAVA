package com.startjava.lesson4;

public class ArrayMain {

    public static void main(String[] args) {

        int[] numbers = new int[6];

        float[] numbers1 = {5.1f, .5f, 200.5f};

        System.out.println(numbers.length);
        System.out.println(numbers1.length);
//        System.out.println(numbers);
        for(int i=0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
        }
        System.out.println();

        for(int i=0; i < numbers1.length; i++) {
            System.out.print(numbers1[i]+" ");
        }

        System.out.println();

        for(int i=0; i < numbers.length; i++) {
            numbers[i] = i * 10;
        }

        for (int number : numbers) {
            System.out.print(number + " ");
        }

//       System.out.print(numbers[10]);

        System.out.println();
        String[] text = new String[3];
//      text
        for (int i = 0; i < text.length; i++) {
            String string = text[i];
            System.out.println(string);
        }
    }
}
