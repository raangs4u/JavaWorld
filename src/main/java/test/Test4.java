package test;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rmandada on 27/1/15.
 */
public class Test4 {

    public static void main(String[] args) {
        long[] ar = new long[100000];
        try {
            Scanner in = new Scanner(new File("/home/rmandada/workspace-IDEA/hrpractice/src/IntegerArray.txt"));
            for (int j = 0; j < 100000 ; j++) {
                ar[j] = in.nextInt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long result =0;
        for (int i = 0; i <ar.length ; i++) {
            for (int j = i+1; j <ar.length ; j++) {
                if(ar[i]>ar[j]){
                    result++;
                }
            }
        }
        System.out.println(result);
    }

}
