package com.hr;

import com.sun.deploy.util.StringUtils;

import java.util.Scanner;

/**
 * Created by rmandada on 26/12/14.
 */
public class SherlockNBeast {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int k = 0; k <t ; k++) {
            int N = in.nextInt();
            int i = 0;
            int j = 0;
            int f =0;
            if (N%3 ==0){
                i = N/3;
                f =1;
            }
            else if(N%3==1){
                i = N/3 - 2;
                j = 2;
                f=1;
            }
            else {
                i = N/3 - 1;
                j = 1;
                f=1;
            }

            if (f==0){
                System.out.println(-1);
            }
            else {
                String s = new String(new char[3*i]).replace("\0","5")+ new String(new char[5*j]).replace("\0", "3");
                System.out.println(s);
            }

        }


    }
}
