package com.dabe.baddooooo.model.data.local;

import java.math.BigDecimal;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public class Edge {

    private String id;
    private Vertex source;
    private Vertex destination;
    private BigDecimal weight;

    public Edge(String id, Vertex source, Vertex destination, BigDecimal weight) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public Vertex getSource() {
        return source;
    }

    public Vertex getDestination() {
        return destination;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "id='" + id + '\'' +
                ", source=" + source +
                ", destination=" + destination +
                ", weight=" + weight +
                '}';
    }
}
