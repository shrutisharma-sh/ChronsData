package com.shruti.ChronsData.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.*;

@Service
public class AIService {

    @Value("${openai.api.key:dummy}")
    private String apiKey;

    public String extractTableName(String userQuery) {

        try {
            String url = "https://api.openai.com/v1/chat/completions";

            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(apiKey);

            String prompt = "Extract only the table name from this query: "
                    + userQuery +
                    ". Respond with only the table name.";

            Map<String, Object> body = new HashMap<>();
            body.put("model", "gpt-4o-mini");

            List<Map<String, String>> messages = new ArrayList<>();

            Map<String, String> msg = new HashMap<>();
            msg.put("role", "user");
            msg.put("content", prompt);

            messages.add(msg);
            body.put("messages", messages);

            HttpEntity<Map<String, Object>> request =
                    new HttpEntity<>(body, headers);

            ResponseEntity<Map> response =
                    restTemplate.postForEntity(url, request, Map.class);

            Map<String, Object> responseBody = response.getBody();


            List<?> choices = (List<?>) responseBody.get("choices");

            Map<?, ?> firstChoice = (Map<?, ?>) choices.get(0);

            Map<?, ?> messageMap = (Map<?, ?>) firstChoice.get("message");

            String content = (String) messageMap.get("content");

            System.out.println("API KEY: " + apiKey);
            return content.trim();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error processing request";
        }
    }
}