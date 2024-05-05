package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import util.Graph;

public class BreadthFirstSearch {

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

        BFS(graph1);
    }

    public static void BFS(Graph root) {
        var queue = new LinkedList<Graph>();
        Set<Graph> visited = new HashSet<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Graph graph = queue.remove();
            visited.add(graph);
            List<Graph> edges = graph.edges;
            for (Graph edge : edges) {
                if (!visited.contains(edge)) {
                    queue.add(edge);
                }
            }

            System.out.print(graph.val + " ");
        }
    }

}
