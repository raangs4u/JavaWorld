package test;

/**
 * Created by rmandada on 23/1/15.
 */
public class Test3 {

    private static int[][] mutiplyMatrix(int[][] a, int i, int j, int[][] b, int k, int l){
        return null;
    }
    private static int[][] addMatrix(int[][] a, int[][] b){
        int[][] result = new int[a.length][a.length];
        for (int i = 0; i <a.length ; i++) {
            for (int j = 0; j <a.length ; j++) {
                result[i][j] = a[i][j]+b[i][j];
            }
        }
        return result;
    }
}

