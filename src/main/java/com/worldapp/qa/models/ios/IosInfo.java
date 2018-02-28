package com.worldapp.qa.models.ios;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "resultCount",
        "results"
})
public class IosInfo {

    @JsonProperty("resultCount")
    private long resultCount;
    @JsonProperty("results")
    private List<Result> results = null;

    @JsonProperty("resultCount")
    public long getResultCount() {
        return resultCount;
    }

    @JsonProperty("resultCount")
    public void setResultCount(long resultCount) {
        this.resultCount = resultCount;
    }

    @JsonProperty("results")
    public List<Result> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(List<Result> results) {
        this.results = results;
    }

}