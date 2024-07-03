package com.dhakad.graph;

import lombok.*;

import java.util.*;

public class Kruskal {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder(toBuilder = true)
    @ToString
    public static class Edge implements Comparable<Edge> {
        private int weight;
        private int source;
        private int destination;


        @Override
        public int compareTo(Edge edge) {
            return this.weight - edge.weight;
        }
    }

    public static class Graph {
        private int nodes;
        private List<Edge> edges;


        public Graph(int nodes, List<Edge> edges) {
            this.nodes = nodes;
            this.edges = edges;
        }

        public static int find(int[] parent, int source){
            if (parent[source] == -1){
                return source;
            }
            return find(parent, parent[source]);
        }

        public static void union(int[] parent, int x, int y){
            int xRoot = find(parent, x);
            int yRoot = find(parent, y);
            parent[xRoot] = yRoot;
        }


        public int minimumSpanning(){
            int[] parent = new int[nodes];
            Arrays.fill(parent, -1);
            int min = 0;
            for (Edge edge : edges){
                int x = edge.getSource();
                int y = edge.getDestination();
                int cost = edge.getWeight();

                if (find(parent,x) != find(parent, y)){
                    min += cost;
                    union(parent, x, y);
                }
            }
            return min;
        }
    }

    public static void main(String[] args) {

        Edge edge1 = Edge.builder()
                .source(0).destination(1)
                .weight(1).build();

        Edge edge2 = Edge.builder()
                .source(0).destination(2)
                .weight(7).build();

        Edge edge3 = Edge.builder()
                .source(1).destination(3)
                .weight(4).build();

        Edge edge4 = Edge.builder()
                .source(1).destination(2)
                .weight(5).build();

        Edge edge5 = Edge.builder()
                .source(1).destination(4)
                .weight(3).build();

        Edge edge6 = Edge.builder()
                .source(2).destination(4)
                .weight(6).build();

        Edge edge7 = Edge.builder()
                .source(3).destination(4)
                .weight(2).build();

        List<Edge> edges = Arrays.asList(edge1, edge2, edge3, edge4, edge5, edge6, edge7);

        Collections.sort(edges);


        int nodes = 5;
        Graph graph = new Graph(nodes, edges);
        int minimumCost = graph.minimumSpanning();
        System.out.println(minimumCost);

    }
}
