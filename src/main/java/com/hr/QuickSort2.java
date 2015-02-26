package com.hr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rmandada on 29/12/14.
 */
public class QuickSort2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> ar = new ArrayList<Integer>();
        for (int i = 0; i <n ; i++) {
            ar.add(in.nextInt());
        }
        ar = quickSort1(ar);
        //printArray(ar);
    }

    public static List quickSort1(List<Integer> a){
        List<Integer> a1 = new ArrayList<Integer>();
        List<Integer> a2 = new ArrayList<Integer>();
        List<Integer> a3 = new ArrayList<Integer>();
        if (a.size()<=1){
            return a;
        }
        else {
            int p = a.get(0);
            for (int i = 1; i < a.size(); i++) {
                if (a.get(i) <= p) {
                    a1.add(a.get(i));
                } else {
                    a2.add(a.get(i));
                }
            }
            a3.addAll(quickSort1(a1));
            a3.add(p);
            a3.addAll(quickSort1(a2));
            printArray(a3);
            return a3;
        }

    }
    static void printArray(List<Integer> ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
