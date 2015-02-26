package com.hr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rmandada on 29/12/14.
 */
public class QuickSortInplace {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i <n ; i++) {
            ar[i]=in.nextInt();
        }
        quickSort(ar);
    }

    public static void quickSort(int[] a){
        if(a.length<2){
            return ;
        }
        else {
            a = partition(a, 0, a.length - 1);
            //printArray(a);
        }
    }
    public static int[] partition(int[] a, int x, int y){
        int i =x;
        int j= y;
        if(j-i<1){
            return a ;
        }
        else {
            int p = a[j];
            while (i < j) {
                while (a[i] <= p && i<j) {
                    i = i + 1;
                }
                while (a[j] >= p && i<j) {
                    j = j - 1;
                }
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
            int tmp = a[i];
            a[i] = p;
            a[y] = tmp;
            //printArray(a);
            a = partition(a,x,j-1);
            a = partition(a,j,y);
            //printArray(a);
            return a;
        }
        //printArray(a);
    }
    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}