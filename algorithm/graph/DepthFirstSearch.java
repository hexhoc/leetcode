package algorithm.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import util.Graph;

public class DepthFirstSearch {

    public static void main(String[] args) {
        /*
            1
           / \
          2   3
         / \   \
        4   5   6
        */
        Graph graph1 = new Graph(1);
        Graph graph2 = new Graph(2);
        Graph graph3 = new Graph(3);
        Graph graph4 = new Graph(4);
        Graph graph5 = new Graph(5);
        Graph graph6 = new Graph(6);

        graph1.addEdge(graph2);
        graph1.addEdge(graph3);
        graph2.addEdge(graph4);
        graph2.addEdge(graph5);
        graph3.addEdge(graph6);

        DFS(graph1);
        DFSRecursive(graph1, new HashSet<Graph>());
    }

    public static void DFS(Graph root) {
        var stack = new Stack<Graph>();
        Set<Graph> visited = new HashSet<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            Graph graph = stack.pop();
            List<Graph> edges = graph.edges;
            for (Graph edge : edges) {
                if (edge != null && !visited.contains(edge)) {
                    stack.add(edge);
                    visited.add(edge);
                }
            }

            System.out.print(graph.val + " ");
        }
    }

    public static void DFSRecursive(Graph graph, Set<Graph> visited) {
        System.out.print(graph.val + " ");
        visited.add(graph);
        var edges = graph.edges;
        for (Graph edge : edges) {
            DFSRecursive(edge, visited);
        }
    }

}
