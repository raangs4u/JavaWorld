package com.hr;

import java.util.*;
import java.util.Map.Entry;

/**
 * Created by RANGA on 3/2/2015.
 */
public class Graph1 {

    private int n;
    private final Map<Integer,List<Integer>> adjList;
    private final Random random = new Random();

    public Graph1(int n) {
        this.n = n;
        this.adjList = createAdjList(n);
    }

    private Graph1(Graph1 copy){
        this.n = copy.getN();
        this.adjList = new LinkedHashMap<Integer, List<Integer>>();

        for (Entry<Integer,List<Integer>> entry: copy.adjList.entrySet()) {
            adjList.put(entry.getKey(),entry.getValue());
        }
    }

    public Graph1 copy(){
        return new Graph1(this);
    }
    private Map<Integer,List<Integer>> createAdjList(int n) {
        Map<Integer,List<Integer>> map = new LinkedHashMap<Integer, List<Integer>>();
        int i =0;
        while (i<n){
            map.put(i,new ArrayList<Integer>());
            i++;
        }
        return map;
    }

    public void addEdge(int v, int u) {
        adjList.get(v).add(u);
    }

    public List<Integer> adjacentTo(int v) {
        if (!adjList.containsKey(v)) {
            throw new IllegalArgumentException(v+" is already removed");
        }
        return adjList.get(v);
    }

    public void contract(int v, int u) {
        List<Integer> newList = new ArrayList<Integer>();

        for (int fromFirst: adjList.get(v)){
            if (fromFirst!=u){
                newList.add(fromFirst);
            }
        }

        for (int fromSecond: adjList.get(u)){
            if (fromSecond!=v){
                newList.add(fromSecond);
            }
        }

        adjList.remove(v);
        adjList.remove(u);
        n--;

        for (Entry<Integer,List<Integer>> entry: adjList.entrySet()){
            List<Integer> list = entry.getValue();
            for (int i = 0; i <list.size() ; i++) {
                if (list.get(i).intValue() == u){
                    list.set(i,v);
                } else if (entry.getKey()==list.get(i)){
                    list.remove(i);
                }
            }

        }

        adjList.put(v,newList);
    }

    public int randomVertex(){
        int[] avail = new int[n];
        int i = 0;
        for (Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            if (!entry.getValue().isEmpty()){
                avail[i] = entry.getKey();
                i++;
            }
        }

        return avail[random.nextInt(i)];
    }

    public int getN(){
        return n;
    }

    public Map<Integer, List<Integer>> adjacencyList(){
        return adjList;
    }

    public Pair randomEdge(){
        int[] avail = new int[n];
        int i = 0;
        for (Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            if (!entry.getValue().isEmpty()){
                avail[i] = entry.getKey();
                i++;
            }
        }

        int vertexU = avail[random.nextInt(i)];
        List<Integer> edges = adjList.get(vertexU);
        int vertexV = edges.get(random.nextInt(edges.size()));
        return Pair.of(vertexU,vertexV);
    }
}
