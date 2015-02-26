package test;

import java.io.File;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rmandada on 28/1/15.
 */
public class Test5 {
    public static void main(String[] args) {

        long[] ar = new long[10000];
        try {
            Scanner in = new Scanner(new File("/home/rmandada/workspace-IDEA/hrpractice/src/IntegerArray.txt"));
            for (int j = 0; j < 10000 ; j++) {
                ar[j] = in.nextInt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
