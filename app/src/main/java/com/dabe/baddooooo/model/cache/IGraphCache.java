package com.dabe.baddooooo.model.cache;

import com.dabe.baddooooo.model.data.algh.Graph;
import com.dabe.baddooooo.model.data.remote.dto.RateDTO;

import java.util.List;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public interface IGraphCache {
    Graph getGraph();

    void buildGraph(List<RateDTO> rates);

    boolean isGraphBuilt();
}
