package com.dhakad.graph;

public class GraphMatrix {

    private int[][] adjMatrix;
    private int nodes;

    public GraphMatrix(int nodes){
        this.nodes = nodes;
        this.adjMatrix = new int[nodes][nodes];
    }

    public void addEdge(int source, int destination){
        adjMatrix[source][destination] = 1;
    }

    public void printGraph(){
        for (int i = 0; i < nodes; i++){
            for (int j = 0; j < nodes; j++){
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
