package test;

import com.hr.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by rmandada on 28/1/15.
 */
public class Test5 {
    public static void main(String[] args) throws FileNotFoundException {
        Graph graph = new Graph(200);

        Scanner in = new Scanner(new File("C:\\Users\\RANGA\\Desktop\\kargerMinCut.txt"));
        while (in.hasNext()){
            //System.out.println(in.nextLine());
            String[] str = in.nextLine().split("\t");
            //int[] ints = new int[str.length];
            int v = Integer.parseInt(str[0]);
            //System.out.println(str.length);
            for (int i = 1; i <str.length ; i++) {
                //ints[i] = Integer.parseInt(str[i]);
                graph.addEdge(v, Integer.parseInt(str[i]));
            }
        }
        int noOfV = graph.getV();
        while(noOfV >2){
            Random random = new Random();
            Set<Integer> s = graph.getVerticesSet();
            int v = new ArrayList<Integer>(s).get(random.nextInt(s.size()));
            List<Integer> listv = graph.getAdjacencyList(v);
            int u = listv.get(random.nextInt(listv.size()));
            List<Integer> listu = graph.getAdjacencyList(u);
            graph.removeEdge(v,u);

            int s1 = listv.size();
            int s2 = listu.size();
            if(s1>=s2){
                for(int i : listu){
                    if(!listv.contains(i)){
                        graph.addEdge(v,i);
                    }
                }
                graph.getAdjListMap().remove(u);
            } else {
                for (int i: listv){
                    if(!listu.contains(i)){
                        graph.addEdge(u,i);
                    }
                }
                graph.getAdjListMap().remove(v);
            }
            noOfV--;
        }




        System.out.println(graph.getAdjListMap());
    }
}
