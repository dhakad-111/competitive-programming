package com.dhakad.graph;

import java.io.*;
import java.util.*;

public class BfsGraph {

    public static class Graph{
        private List<List<Integer>> grid;
        private int nodes;
        private boolean[] visited;

        public Graph(int nodes){
            this.nodes = nodes;
            this.visited = new boolean[nodes];
            grid = new ArrayList<>(nodes);
            for (int i = 0; i < nodes; i++){
                this.grid.add(new ArrayList<>());
            }
        }

        public void addEdge(int source, int destination){
            grid.get(source).add(destination);
        }

        public void printGraph(){
            for (int i = 0; i < nodes; i++){
                for (int x : grid.get(i)){
                    System.out.print(x + " ");
                }
                System.out.println();
            }
        }

        public List<Integer> bfs(int source){
            List<Integer> result = new ArrayList<>();
            visited[source] = true;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(source);
            while (!queue.isEmpty()){
                int p = queue.poll();
                result.add(p);
                for (int x : grid.get(p)){
                    if (visited[x] == false){
                        queue.offer(x);
                        visited[x] = true;
                    }
                }
            }
            return result;
        }

        public void dfs(int source){
            this.visited[source] = true;
            System.out.print(source + " ");
            for(int x : grid.get(source)){
                if (visited[x] == false){
                    dfs(x);
                }
            }
        }
    }



    public static class FastReader{
        BufferedReader bufferedReader;
        StringTokenizer stringTokenizer;

        public FastReader(String location) throws FileNotFoundException {
            this.bufferedReader = new BufferedReader(new FileReader(location));
        }

        String next() throws IOException {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()){
                this.stringTokenizer = new StringTokenizer(this.bufferedReader.readLine());
            }
            return stringTokenizer.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        String nextLine(){
            return stringTokenizer.nextToken().trim();
        }
        void close() throws IOException {
            bufferedReader.close();
        }
    }

    public static class FastWriter{
        private final BufferedWriter bufferedWriter;

        public FastWriter(String location) throws IOException {
            this.bufferedWriter = new BufferedWriter(new FileWriter(location));
        }

        public void print(Object object) throws IOException {
            this.bufferedWriter.append(String.valueOf(object));
        }

        public void println(Object object) throws IOException {
            print(object);
            this.bufferedWriter.append("\n");
        }

        public void close() throws IOException {
            this.bufferedWriter.close();
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
                    int source = in.nextInt();
                    int destination = in.nextInt();
                    graph.addEdge(source, destination);
                }
//                List<Integer> bfs = graph.bfs(2);
                graph.dfs(2);
//                out.print(bfs);
//                graph.printGraph();
                in.close();
                out.close();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
