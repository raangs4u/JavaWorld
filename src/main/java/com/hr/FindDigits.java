package com.hr;

import java.util.Scanner;

/**
 * Created by rmandada on 24/12/14.
 */
public class FindDigits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++) {
            System.out.println(findDigits(in.nextLong()));
        }
    }
    public static int findDigits(long n) {
        long rem = 0;
        int result = 0;
        long N = n;
        while (n > 0) {
            rem = n % 10;
            if (rem > 0 && N % rem == 0) {
                result++;
            }
            n = n/10;
        }
        return result;
    }
}
