package com.dhakad;

import com.dhakad.graph.GraphList;
import com.dhakad.graph.GraphMatrix;

import java.io.*;
import java.util.StringTokenizer;

public class Template {

    public static class FastReader {
        private BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        public FastReader(){
            this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String location) throws FileNotFoundException {
            this.bufferedReader = new BufferedReader(new FileReader(location));
        }

        String next() throws IOException {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
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

        String nextLine() throws IOException {
            return bufferedReader.readLine().trim();
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

        void print(Object object) throws IOException {
            this.bufferedWriter.append(String.valueOf(object));
        }

        void println(Object object) throws IOException {
            print(object);
            this.bufferedWriter.append("\n");
        }

        void close() throws IOException {
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
                GraphMatrix graph = new GraphMatrix(nodes);
                GraphList graph1 = new GraphList(nodes);
                for (int i = 0; i < edges; i++){
                    int x = in.nextInt();
                    int y = in.nextInt();
                    graph.addEdge(x, y);
                    graph1.addEdge(x,y);

                }
                graph.printGraph();
                graph1.printGraph();
            }
            in.close();
            out.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
