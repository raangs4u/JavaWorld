package com.hr;

import java.util.Scanner;

/**
 * Created by rmandada on 26/12/14.
 */
public class SherlockNSqaures {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i <t ; i++) {
            long a = in.nextLong();
            long b = in.nextLong();
            long sq = a;
            long sqra = (long)Math.ceil(Math.sqrt(a));
            long j = sqra;
            while(sq <=b){
                sq = j*j;
                j++;
            }
            System.out.println(j-sqra-1);
        }

    }
}
