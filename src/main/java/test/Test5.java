package test;

import com.hr.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rmandada on 28/1/15.
 */
public class Test5 {
    public static void main(String[] args) throws FileNotFoundException {
        Graph graph = new Graph(200);

        Scanner in = new Scanner(new File("/home/rmandada/Downloads/kargerMinCut.txt"));
        while (in.hasNext()){
            System.out.println(in.nextLine());
        }
    }
}
