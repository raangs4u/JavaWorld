package com.hr;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map.Entry;

/**
 * Created by RANGA on 3/3/2015.
 */
public class RandContraction {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner  in = new Scanner(new File("C:\\Users\\RANGA\\Desktop\\kargerMinCut.txt"));
        Random rand = new Random();

        int n = 200;
        Graph1 graph = new Graph1(n);

        for (int i = 0; i <n ; i++) {
            String nextLine = in.nextLine();
            int[] line = Utils.parseIntArray(nextLine.split("\\s+"));
            int v = line[0];
            for (int j = 1; j <line.length ; j++) {
                graph.addEdge(v-1,line[j]-1);
            }
        }
        Graph1 initialGraph = graph.copy();
        int best = Integer.MAX_VALUE;
        for (int i = 0; i <200 ; i++) {
            graph = initialGraph.copy();
            while (graph.getN()>2) {
                /*int randV = graph.randomVertex();
                List<Integer> listV = graph.adjacentTo(randV);
                int randU = listV.get(rand.nextInt(listV.size()));*/
                Pair randomedge = graph.randomEdge();

                graph.contract(randomedge.getLeft(), randomedge.getRight());
            }

            Iterator<Entry<Integer, List<Integer>>> iterator = graph.adjacencyList().entrySet().iterator();
            List<Integer> first = iterator.next().getValue();
            Set<Integer> firstKey = graph.adjacencyList().keySet();
            List<Integer> second = iterator.next().getValue();
            /*System.out.println(first.toString());
            System.out.println(second.toString());*/
            assertEqua

                if(best>first.size()){
                best = first.size();}
            if(best == 0){
                System.out.println(firstKey.toString());
                System.out.println(first.toString());
                System.out.println(second.toString());
                System.out.println();
            }

            //System.out.println(best);
        }
        System.out.println(best);
    }
}
