package com.dhakad.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphList {
    private List<List<Integer>> grid;
    private int nodes;

    public GraphList(int nodes){
        this.nodes = nodes;
        this.grid = new ArrayList<>(nodes);
        for (int i = 0; i < nodes; i++){
            grid.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination){
        grid.get(source).add(destination);
    }

    public void printGraph(){
        for (int i = 0; i < nodes; i++){
            for (int edge : grid.get(i)){
                System.out.print(edge + " ");
            }
            System.out.println();
        }
    }
}
