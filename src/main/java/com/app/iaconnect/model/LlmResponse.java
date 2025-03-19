package com.app.iaconnect.model;

public class LlmResponse {
    private String response;

    // Default constructor for JSON serialization
    public LlmResponse() {
    }

    public LlmResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}

