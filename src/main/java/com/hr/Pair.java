package com.hr;

/**
 * Created by RANGA on 3/3/2015.
 */
public class Pair {
    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public Pair(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public static Pair of(int left, int right){
        return new Pair(left,right);
    }

    private int left;
    private int right;

}
