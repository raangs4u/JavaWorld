package com.hr;

/**
 * Created by RANGA on 3/3/2015.
 */
public class Utils {

    public static int[] parseIntArray(String[] strings){
        int[] res = new int[strings.length];
        for (int i = 0; i <strings.length ; i++) {
            res[i] = Integer.parseInt(strings[i]);
        }
        return res;
    }
}
