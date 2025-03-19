package com.app.iaconnect.service;

import com.app.iaconnect.model.LlmResponse;
import com.app.iaconnect.model.N8nRequest;
import com.app.iaconnect.model.N8nResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LlmService {

    private final RestTemplate restTemplate;

    @Value("${n8n.workflow.url}")
    private String n8nWorkflowUrl;

    @Autowired
    public LlmService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public LlmResponse processLlmQuery(String query) {
        // Prepare headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Prepare request body for n8n
        N8nRequest n8nRequest = new N8nRequest(query);
        HttpEntity<N8nRequest> requestEntity = new HttpEntity<>(n8nRequest, headers);

        // Call n8n workflow
        N8nResponse n8nResponse = restTemplate.postForObject(
                n8nWorkflowUrl,
                requestEntity,
                N8nResponse.class
        );

        // Process response
        if (n8nResponse != null) {
            return new LlmResponse(n8nResponse.getResult());
        } else {
            return new LlmResponse("No response received from LLM workflow");
        }
    }
}

