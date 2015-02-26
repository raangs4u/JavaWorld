package com.hr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rmandada on 29/12/14.
 */
public class QuickSort1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i <n ; i++) {
            ar[i]=in.nextInt();
        }
        quickSort1(ar);
    }

    public static void quickSort1(int[] a){
        List<Integer> a1 = new ArrayList<Integer>();
        List<Integer> a2 = new ArrayList<Integer>();
        for (int i = 1; i <a.length ; i++) {
            if (a[i]<=a[0]){
                a1.add(a[i]);
            }
            else {
                a2.add(a[i]);
            }
        }
        a1.add(a[0]);
        a1.addAll(a2);
        //a1.toArray();
        Integer[] a3 = a1.toArray(new Integer[a1.size()]);
        printArray(a3);
    }
    static void printArray(Integer[] ar) {
        for(Integer n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
