package com.dabe.baddooooo;

import com.dabe.baddooooo.model.cache.GraphCacheClient;
import com.dabe.baddooooo.model.data.algh.DijkstraAlgorithm;
import com.dabe.baddooooo.model.data.algh.Vertex;
import com.dabe.baddooooo.model.data.remote.dto.RateDTO;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public class DijkstraAlghTest {
    @Test
    public void testBuildGraph() {
        List<RateDTO> rates = new ArrayList<>();
        rates.add(new RateDTO("USD", new BigDecimal(0.5), "GBP"));
        rates.add(new RateDTO("USD", new BigDecimal(0.9), "EUR"));
        rates.add(new RateDTO("EUR", new BigDecimal(1.2), "AUD"));
        rates.add(new RateDTO("AUD", new BigDecimal(47), "RUB"));
        GraphCacheClient client = new GraphCacheClient();
        client.buildGraph(rates);

        assertTrue(client.isGraphBuilt());
        assertNotNull(client.getGraph());
        assertEquals("Vertex count is incorrect!!", 5, client.getGraph().getVertexes().size());
        assertEquals("Edge count is incorrect!!", 4, client.getGraph().getEdges().size());
        System.out.println("TestBuildGraph passed");
    }

    @Test
    public void testAlghCalculation() {
        List<RateDTO> rates = new ArrayList<>();
        rates.add(new RateDTO("USD", new BigDecimal(0.5), "GBP"));
        rates.add(new RateDTO("USD", new BigDecimal(0.9), "EUR"));
        rates.add(new RateDTO("EUR", new BigDecimal(1.2), "AUD"));
        rates.add(new RateDTO("AUD", new BigDecimal(47), "RUB"));
        GraphCacheClient client = new GraphCacheClient();
        client.buildGraph(rates);

        DijkstraAlgorithm algorithm = new DijkstraAlgorithm(client.getGraph());
        BigDecimal actual = algorithm.convertCurrency("USD", "RUB", new BigDecimal(100)).setScale(0, BigDecimal.ROUND_HALF_EVEN);
        BigDecimal expected = new BigDecimal(5076).setScale(0, BigDecimal.ROUND_HALF_EVEN);
        assertNotNull("PATH USD->RUB IS UNDEFINED", algorithm.getPath(new Vertex("RUB", "RUB")));
        assertEquals("PATH USD->RUB IS INCORRECT", 4, algorithm.getPath(new Vertex("RUB", "RUB")).size());
        assertEquals("CURRENCY CONVERT USD->RUB IS INCORRECT", expected, actual);

        System.out.println("TestAlghCalculation passed");
    }
}
