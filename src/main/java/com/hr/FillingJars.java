package com.hr;

import java.util.Scanner;

/**
 * Created by rmandada on 26/12/14.
 */
public class FillingJars {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long noJars = in.nextLong();
        long noOp = in.nextLong();
        long[] jars = new long[(int)noJars];
        long sum = 0;
        for (int i = 0; i < noOp ; i++) {
            long a = in.nextLong();
            long b = in.nextLong();
            long n = in.nextLong();
            sum+= (b-a+1)*n;

        }
        System.out.println(sum/noJars);
    }
}
