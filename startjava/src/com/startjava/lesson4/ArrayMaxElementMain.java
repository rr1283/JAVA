package com.startjava.lesson4;

import java.util.Scanner;

public class ArrayMaxElementMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите длину массива: ");
        int maxLength = scanner.nextInt();
        int[] numbers = new int[maxLength];

        System.out.println("Заполните массив целыми числами через пробел: ");

        for(int i=0; i<maxLength;i++) {
            numbers[i]=scanner.nextInt();
        }

        int max = numbers[0];
        for(int i=0; i<maxLength-1;i++) {
            if(max<numbers[i+1]) {
                max = numbers[i+1];
            }

        }
        System.out.println("Максимальное число = "+max);
    }
}
