package com.dhakad.graph;

import com.dhakad.CPTemplate;
import lombok.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class GraphList1 extends CPTemplate {


    public static class Graph {
        private List<Edges> grid;
        private int nodes;
        private int[] parent;

        public Graph(int nodes, List<Edges> grid) {
            this.nodes = nodes;
            this.grid = grid;
            this.parent = new int[nodes+1];
        }

        public int find(int v) {
            if (parent[v] == -1) {
                return v;
            }
            return find(parent[v]);
        }

        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            parent[xRoot] = yRoot;
        }

        public int spanningTree() {
            AtomicInteger minimumCost = new AtomicInteger(0);
            Arrays.fill(parent, -1);

            grid.forEach(edges -> {
                int cost = edges.getWeight();
                int x = edges.getSource();
                int y = edges.getDestination();

                if (find(x) != find(y)) {
                    minimumCost.addAndGet(cost);
                    union(x, y);
                }
            });

            return minimumCost.get();
        }

        @AllArgsConstructor
        @Getter
        @Setter
        @Builder(toBuilder = true)
        @ToString
        public static class Edges implements Comparable<Edges> {
            private int weight;
            private int source;
            private int destination;

            @Override
            public int compareTo(Edges o) {
                return this.weight - o.weight;
            }
        }
    }

    public static void main(String[] args) {

        try {
            String input = "src/main/resources/input.txt";
            String output = "src/main/resources/output.txt";
            FastReader in = new FastReader(input);
            FastWriter out = new FastWriter(output);
            int tt = in.nextInt();
            while (tt-- > 0) {
                int nodes = in.nextInt();
                int edges = in.nextInt();
                List<Graph.Edges> arr = new ArrayList<>();
                for (int i = 0; i < edges; i++) {
                    int x = in.nextInt();
                    int y = in.nextInt();
                    int weight = in.nextInt();
                    Graph.Edges build = Graph.Edges.builder()
                            .source(x)
                            .destination(y)
                            .weight(weight).build();
                    arr.add(build);
                }
                Collections.sort(arr);
                Graph graph = new Graph(nodes, arr);
                int minimumCost = graph.spanningTree();
                out.printLn(minimumCost);
            }
            in.close();
            out.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
