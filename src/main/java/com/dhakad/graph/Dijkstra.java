package com.dhakad.graph;

import com.dhakad.CPTemplate;

import java.util.Arrays;

public class Dijkstra extends CPTemplate {

    public static int minimumNode(int[] distance, boolean[] spt, int nodes){
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for (int v = 0; v < nodes; v++){
            if (!spt[v] && distance[v] < min){
                min = distance[v];
                min_index = v;
            }
        }
        return min_index;
    }

    public static int[] shortestPath(int[][] grid, int source, int nodes){
        int[] distance = new int[nodes];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        boolean[] spt = new boolean[nodes];

        for (int i = 0; i < nodes-1; i++){
            int u = minimumNode(distance, spt, nodes);
            spt[u] = true;

            for (int v = 0; v < nodes; v++){
                if (!spt[v] && distance[u] != Integer.MAX_VALUE  && grid[u][v] != 0 && distance[u] + grid[u][v] < distance[v]){
                    distance[v] = distance[u] + grid[u][v];
                }
            }
        }
        return distance;
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
                int source = in.nextInt();
                int[][] grid = new int[nodes][nodes];
                for (int i = 0; i < nodes; i++){
                    for (int j = 0; j < edges; j++){
                        int weight = in.nextInt();
                        grid[i][j] = weight;
                    }
                }
                int[] distance = shortestPath(grid, source, nodes);
                System.out.println(distance);
                out.printLn(distance);
            }
            in.close();
            out.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
