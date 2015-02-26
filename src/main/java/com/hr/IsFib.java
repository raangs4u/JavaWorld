package com.hr;

import java.util.Scanner;

/**
 * Created by rmandada on 23/12/14.
 */
public class IsFib {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int j = 0; j < t; j++) {
            double n = in.nextDouble();
            System.out.println(isFib(n));
        }
    }
    private static String isFib(double n) {
        double one = (5 * n * n) + 4;
        double two = (5 * n * n) - 4;

        if (isPerfectSquare(one) || isPerfectSquare(two)) {
            return  "IsFibo";
        }
        else {
            return  "IsNotFibo";
        }
    }
    private static boolean isPerfectSquare(double n) {
        if (Math.sqrt(n) % 1 == 0) {
            return true;
        }
        else {
            return  false;
        }
    }
}
