package com.startjava.lesson4;

import java.util.Scanner;
import static java.lang.Math.*;

public class ArrayMaxElementMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите длину массива: ");
        int maxLength = scanner.nextInt();
        int[] numbers = new int[maxLength];

        System.out.println("Заполните массив целыми числами через пробел: ");

        numbers[0] = scanner.nextInt();
        int nextScanner = 0;

        for(int i=1; i<maxLength; i++) {
            nextScanner = scanner.nextInt();
            if (abs(numbers[0]) != nextScanner) {
                numbers[i] = nextScanner;
            }
        }

        for (int number : numbers) {
            System.out.print(number + " ");
        }

        System.out.println();


        int v_max = numbers[0];
        int v_num = 0;

        for (int j = 0; j < maxLength - 1; j++) {
            if (abs(v_max) < abs(numbers[j + 1])) v_max = numbers[j + 1];
            if (v_max != numbers[0]) v_num = j + 1;
        }
        System.out.println("Максимальное число = " + v_max);
        System.out.println("Номер элемента в массиве = " + v_num);
    }
}
