package com.dhakad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class A extends CPTemplate{

    @AllArgsConstructor
    @Getter
    @Setter
    public static class Edges implements Serializable {
        private int destination;
        private int weight;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static class Graph implements Serializable{
        private List<List<Edges>> grid;
        private int nodes;

        public Graph(int nodes){
            this.nodes = nodes;
            grid = new ArrayList<>(nodes);
            for (int i = 0; i < nodes; i++){
                grid.add(new ArrayList<>());
            }
        }

        public void addEdge(int x, int y, int weight){
            Edges edges = new Edges(y, weight);
            this.grid.get(x).add(edges);
        }

        public void print(FastWriter out) throws IOException {
            for (List<Edges> edges : grid){
                for (Edges edge : edges){
                    out.printLn(edge.getDestination() + " " + edge.getWeight());
                }
            }
        }

        public int[] dijkstra(int source){
            int[] distance = new int[this.nodes];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[source] = 0;
            PriorityQueue<Edges> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.getWeight()));
            pq.add(new Edges(source,0));
            while (!pq.isEmpty()){
                Edges edges = pq.poll();
                int u = edges.getDestination();
                for (Edges edges1 : this.grid.get(u)) {
                    int v = edges1.getDestination();
                    int weight = edges1.getWeight();
                    if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]){
                        distance[v] = distance[u] + weight;
                        pq.add(new Edges(v, distance[v]));
                    }
                }

            }
            return distance;
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
                    int y = in .nextInt();
                    int weight = in.nextInt();
                    graph.addEdge(x, y, weight);
                }
                int[] distance = graph.dijkstra(0);
                for (int i = 0; i < distance.length; i++){
                    out.printLn(i + " " + distance[i]);
                }
            }
            in.close();
            out.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
