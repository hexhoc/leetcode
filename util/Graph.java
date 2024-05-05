package util;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    public int val;
    public List<Graph> edges;

    public Graph(int val) {
        this.val = val;
        this.edges = new ArrayList<>();
    }

    public void addEdge(Graph graph) {
        this.edges.add(graph);
    }

    @Override
    public String toString() {
        return "Graph " + val;
    }

}