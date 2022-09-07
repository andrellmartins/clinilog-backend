package com.pucpr.backend.model.response;

import com.pucpr.backend.model.tables.Batch;

import java.util.List;

public class ResponseBatchSuccess implements ResponseBatch{
    public List<Batch> batches;
}
