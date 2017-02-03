package com.dabe.baddooooo.model.data.local;

import java.util.List;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public class Graph {
    private List<Vertex> vertexes;
    private List<Edge> edges;

    public Graph(List<Vertex> vertixes, List<Edge> edges) {
        this.vertexes = vertixes;
        this.edges = edges;
    }

    public List<Vertex> getVertexes() {
        return vertexes;
    }

    public List<Edge> getEdges() {
        return edges;
    }
}
