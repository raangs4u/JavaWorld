package com.hr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rmandada on 26/12/14.
 */
public class AcmIcpc {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int max =0;
        int min = M;
        List<String> list = new ArrayList<String>();
        for(int i = 0; i<N; i++){
            list.add(in.next());
        }
        for (int i = 0; i <N-1 ; i++) {
            for (int j = i+1; j <N ; j++) {
                int tmp = 0;
                for (int k = 0; k < M; k++) {
                    if(list.get(i).charAt(k)=='0' && list.get(j).charAt(k)=='0'){
                        tmp++;
                    }
                }
                if (tmp == min){
                    max++;
                }
                if (tmp < min){
                    min = tmp;
                    max = 1;
                }

            }
        }
        System.out.println(M - min);
        System.out.println(max);
    }

}
