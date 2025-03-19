package com.app.iaconnect.model;

public class LlmRequest {
    private String query;

    // Default constructor for JSON deserialization
    public LlmRequest() {
    }

    public LlmRequest(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}

