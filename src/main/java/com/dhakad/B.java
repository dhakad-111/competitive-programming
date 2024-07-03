package com.dhakad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B extends CPTemplate{

    @AllArgsConstructor
    @Getter
    @Setter
    public static class Graph{
        private List<Edges> adjList;
        private int nodes;

        public Graph(int nodes){
            this.nodes = nodes;
            this.adjList = new ArrayList<>();
        }

        public void addEdges(int x, int y, int weight){
            this.adjList.add(new Edges(x, y, weight));
        }

        public void print(FastWriter out) {
            adjList.forEach(x -> {
                try {
                    out.printLn(x.getX() + " " + x.getY() + " " + x.getWeight());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        public void bellManFord(int source){
            int[] dist = new int[nodes];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[source] = 0;
            for (int i = 1; i < nodes; i++){
                for (Edges edge : adjList){
                    int u = edge.getX();
                    int v = edge.getY();
                    int weight = edge.getWeight();
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]){
                        dist[v] = dist[u] + weight;
                    }
                }
            }
            System.out.println(dist);
        }

        @AllArgsConstructor
        @Setter
        @Getter
        @Builder(toBuilder = true)
        public static class Edges implements Serializable {
            private int x;
            private int y;
            private int weight;
        }
    }

    public static void main(String[] args) {
        try {
            String input = "src/main/resources/input.txt";
            String output = "src/main/resources/output.txt";
            FastReader in = new FastReader(input);
            FastWriter out = new FastWriter(output);
            int tt = in.nextInt();
            while (tt-- > 0){
                int nodes = in.nextInt();
                int edges = in.nextInt();
                Graph graph = new Graph(nodes);
                for (int i = 0; i < edges; i++){
                    int x = in.nextInt();
                    int y = in.nextInt();
                    int weight = in.nextInt();
                    graph.addEdges(x, y, weight);
                }
                graph.bellManFord(0);
                graph.print(out);
            }
            in.close();
            out.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
