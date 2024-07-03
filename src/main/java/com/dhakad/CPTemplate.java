package com.dhakad;

import java.io.*;
import java.util.StringTokenizer;

public class CPTemplate {

    public static class FastReader {
        private BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        public FastReader() {
            this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String fileLocation) throws FileNotFoundException {
            this.bufferedReader = new BufferedReader(new FileReader(fileLocation));
        }

        private String next() throws IOException {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                this.stringTokenizer = new StringTokenizer(this.bufferedReader.readLine());
            }
            return stringTokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public String nextLine() throws IOException {
            return this.bufferedReader.readLine().trim();
        }

        public void close() throws IOException {
            this.bufferedReader.close();
        }
    }

    public static class FastWriter {
        private final BufferedWriter bufferedWriter;


        public FastWriter() {
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public FastWriter(String fileLocation) throws IOException {
            this.bufferedWriter = new BufferedWriter(new FileWriter(fileLocation));
        }

        public void print(Object obj) throws IOException {
            this.bufferedWriter.append(String.valueOf(obj));
        }

        public void printLn(Object obj) throws IOException {
            print(obj);
            this.bufferedWriter.append("\n");
        }

        public void close() throws IOException {
            this.bufferedWriter.close();
        }
    }
}
