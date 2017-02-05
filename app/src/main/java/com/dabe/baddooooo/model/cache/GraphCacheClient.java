package com.dabe.baddooooo.model.cache;

import com.dabe.baddooooo.model.data.algh.Edge;
import com.dabe.baddooooo.model.data.algh.Graph;
import com.dabe.baddooooo.model.data.algh.Vertex;
import com.dabe.baddooooo.model.data.remote.dto.RateDTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public class GraphCacheClient implements IGraphCache {

    private Graph graph;

    @Override
    public void buildGraph(List<RateDTO> rates) {
        List<Vertex> nodes = buildUniqNodes(rates);
        List<Edge> edges = buildEdges(rates, nodes);
        graph = new Graph(nodes, edges);
    }

    private List<Vertex> buildUniqNodes(List<RateDTO> rates) {
        List<Vertex> result = new ArrayList<>();
        Set<Vertex> combiner = new HashSet<>();
        for (int i = 0; i < rates.size(); i++) {
            Vertex newVertex = new Vertex(rates.get(i).getFrom(), rates.get(i).getFrom());
            combiner.add(newVertex);
        }
        result.addAll(combiner);
        return result;
    }

    private List<Edge> buildEdges(List<RateDTO> rates, List<Vertex> nodes) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < rates.size(); i++) {
            RateDTO rate = rates.get(i);
            String id = String.format(Locale.getDefault(), "%s->%s", rate.getFrom(), rate.getTo());
            Edge newEdge = new Edge(id, getVertexById(rate.getFrom(), nodes), getVertexById(rate.getTo(), nodes), rate.getRate());
            edges.add(newEdge);
        }
        return edges;
    }

    private Vertex getVertexById(String id, List<Vertex> nodes) {
        for (int i = 0; i < nodes.size(); i++) {
            if (id.equals(nodes.get(i).getId())) {
                return nodes.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean isGraphBuilt() {
        return graph != null;
    }

    @Override
    public Graph getGraph() {
        return graph;
    }

}
