package com.hr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by RANGA on 2/23/2015.
 */
public class Graph {

    private int V;

    private int E;
    private Map<Integer,List> adjListMap;

    public Graph(int size) {
        V = size;
        E = 0;
        adjListMap = new HashMap<Integer, List>(size);
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
        List list = adjListMap.get(v);
        if(list == null){
            list = new ArrayList();
            list.add(u);
            adjListMap.put(v,list);

        } else {
            list.add(u);
        }
        E++;
    }

    public void removeEdge(int v, int u) {
        List list = adjListMap.get(v);
        if(null != list){
            list.remove(u);
            E--;
        }
    }

    public int degree(int v) {
        return adjListMap.get(v).size();
    }

}