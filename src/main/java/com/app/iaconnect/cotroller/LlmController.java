package com.app.iaconnect.cotroller;

import com.app.iaconnect.model.LlmRequest;
import com.app.iaconnect.model.LlmResponse;
import com.app.iaconnect.service.LlmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/llm")
public class LlmController {

    private final LlmService llmService;

    @Autowired
    public LlmController(LlmService llmService) {
        this.llmService = llmService;
    }

    @PostMapping("/query")
    public ResponseEntity<LlmResponse> processQuery(@RequestBody LlmRequest request) {
        LlmResponse response = llmService.processLlmQuery(request.getQuery());
        return ResponseEntity.ok(response);
    }
}

