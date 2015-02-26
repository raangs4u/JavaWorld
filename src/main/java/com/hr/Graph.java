package com.hr;

import java.util.*;

/**
 * Created by RANGA on 2/23/2015.
 */
public class Graph {

    private int V;

    private int E;

    public Map<Integer, List<Integer>> getAdjListMap() {
        return adjListMap;
    }

    private Map<Integer,List<Integer>> adjListMap;

    public Set getVerticesSet() {
        return verticesSet;
    }

    private Set<Integer> verticesSet = new HashSet<Integer>();

    public Graph(int size) {
        V = size;
        E = 0;
        adjListMap = new HashMap<Integer, List<Integer>>(size);
    }

    public int getV() {
        return V;
    }

    public void setV(int v) {
        V = v;
    }

    public int getE() {
        return E;
    }

    public void setE(int e) {
        E = e;
    }

    public void addEdge(int v, int u) {
        verticesSet.add(v);
        verticesSet.add(u);
        List listv = adjListMap.get(v);
        if(listv == null){
            listv = new ArrayList<Integer>();
            listv.add(u);
            adjListMap.put(v,listv);
            verticesSet.add(v);
        } else {
            listv.add(u);
        }
        List listu =adjListMap.get(u);
        if(listu == null){
            listu = new ArrayList<Integer>();
            listu.add(v);
            adjListMap.put(u,listu);
            verticesSet.add(u);
        } else {
            listu.add(v);
        }
        E++;
    }

    public void removeEdge(int v, int u) {
        List listv = adjListMap.get(v);
        if(null != listv){
            listv.remove(listv.indexOf(u));
            if(listv.size()==0){
                adjListMap.remove(v);
                verticesSet.remove(v);
            }
            //E--;
        }
        List listu = adjListMap.get(u);
        if(listu != null){
            listu.remove(listu.indexOf(v));
            if(listu.size()==0){
                adjListMap.remove(u);
                verticesSet.remove(u);
            }
        }
        E--;
    }

    public List<Integer> getAdjacencyList(int v){
        return adjListMap.get(v);
    }

    public int degree(int v) {
        return adjListMap.get(v).size();
    }

}