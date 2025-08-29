package com.aleksgolds.bell.integrator.developer.tests;

import java.util.Random;

public class Task3 {

    public static void main(String[] args) {
        int[][] array = new int[9][9];
        Random random = new Random();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                array[i][j] = random.nextInt(100);
                if (i == 4 && j == 4) {
                    array[i][j] = 1;
                }
                System.out.printf("%4d", array[i][j]);// числа от 0 до 99
            }
            System.out.println();
        }
        System.out.println(findMinAtSecondaryDiagonal(array));
    }

    public static int findMinAtSecondaryDiagonal(int[][] array) {
        int min = Integer.MAX_VALUE;
        int center = array.length / 2;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array.length % 2 == 1 && i == center && j == center) {
                    continue;
                }
                if (array[i][j] < min && j == array[i].length - i - 1) {
                    min = array[i][j];
                }
            }
        }
        return min;
    }
}
