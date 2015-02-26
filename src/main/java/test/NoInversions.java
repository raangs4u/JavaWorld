package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rmandada on 21/1/15.
 */
public class NoInversions {
    public static long inv = 0;
    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i <n ; i++) {
            ar[i]=in.nextInt();
        }*/
        //printArray(Arrays.copyOfRange(ar,0,n/2));
        long[] ar = new long[100000];
        try {
            Scanner in = new Scanner(new File("/home/rmandada/workspace-IDEA/hrpractice/src/IntegerArray.txt"));
            for (int j = 0; j < 100000 ; j++) {
                ar[j] = in.nextInt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(ar.length);
        /*int[] ar = new int[10000];
        for (int i = 10000; i >0 ; i--) {
            ar[10000-i] = i;
        }*/
        ar = countInvertions(ar);
        //printArray(ar);
        System.out.println(inv);

    }

    private static long[] countInvertions(long[] a){
        if(a.length<2) return a;
        int mid = a.length/2;
        return merge(countInvertions(Arrays.copyOfRange(a, 0, mid)),countInvertions(Arrays.copyOfRange(a,mid,a.length)));
    }
    private static long[] merge(long[] a, long[] b){
        int i = 0,j = 0;
        long[] result = new long[a.length+b.length];
        while (i<a.length && j<b.length){
            if(a[i]<=b[j]){
                result[i+j] = a[i];
                i++;
            } else {
                result[i+j] = b[j];
                inv=inv+a.length-i;
                j++;
            }
        }
        if(i>=a.length){
            for (int k = j; k <b.length ; k++) {
                result[i + k] = b[k];
            }
        }else if(j>=b.length){
            for (int k = i; k <a.length ; k++) {
                result[j + k] = a[k];
            }
        }
        return result;
    }
    static void printArray(long[] ar) {
        for(long n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
