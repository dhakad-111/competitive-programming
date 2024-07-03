package com.dhakad;

import java.util.*;

public class D {

    private Map<Integer, List<Integer>> adjList;
    private int nodes;
    private boolean[] visited;

    public D(int nodes){
        this.nodes = nodes;
        this.visited = new boolean[nodes];
        this.adjList = new HashMap<>();
        for (int i = 0; i < nodes; i++){
            adjList.put(i , new ArrayList<>());
        }
    }

    public void addEdge(int a, int b){
        this.adjList.get(a).add(b);
        this.adjList.get(b).add(a);
    }

    public void printGraph(){
        for (Map.Entry<Integer, List<Integer>> entry : this.adjList.entrySet()){
            for (int val : entry.getValue()){
                System.out.print(val + " ");
            }
            System.out.println("");
        }
    }

    public List<Integer> bfs(int source){
        this.visited[source] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(source);
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()){
            int node = queue.poll();
            adjList.get(node);
            ans.add(node);
            for (Integer val : adjList.get(node)){
                if (!visited[val]){
                    visited[val] = true;
                    queue.add(val);
                }
            }
        }
        return ans;
    }

    public void dfs(int source){
        visited[source] =true;
        System.out.print(source +  " ");
        for(Integer val : adjList.get(source)){
            if (!visited[val]){
                dfs(val);
            }
        }
    }

    public static void main(String[] args) {
        D graph = new D(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.printGraph();
        graph.dfs(0);
    }
}
