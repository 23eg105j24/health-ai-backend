package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.*;

@Service
public class GroqAIService {

    private final String API_KEY = "PUT_YOUR_GROQ_API_KEY_HERE";

    public Map<String,String> generateExplanation(String disease, String symptoms) {

        Map<String,String> result = new HashMap<>();

        try {

            String url = "https://api.groq.com/openai/v1/chat/completions";

            RestTemplate restTemplate = new RestTemplate();

            Map<String,Object> body = new HashMap<>();
            body.put("model","llama-3.1-8b-instant");

            List<Map<String,String>> messages = new ArrayList<>();

            Map<String,String> msg = new HashMap<>();
            msg.put("role","user");

            msg.put("content",
                    "Give medical explanation for "+disease+
                    " with symptoms "+symptoms+
                    ". Return JSON only in this format:"+
                    "{\"explanation\":\"...\",\"advice\":\"...\"}"
            );

            messages.add(msg);

            body.put("messages",messages);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(API_KEY);

            HttpEntity<Map<String,Object>> request =
                    new HttpEntity<>(body,headers);

            ResponseEntity<Map> response =
                    restTemplate.postForEntity(url,request,Map.class);

            List<Map> choices =
                    (List<Map>) response.getBody().get("choices");

            Map choice = choices.get(0);
            Map message = (Map) choice.get("message");

            String content = message.get("content").toString();

            result.put("explanation",content);
            result.put("advice","Follow medication and rest.");

            return result;

        } catch(Exception e){

            result.put("explanation","This condition usually improves with rest and proper care.");
            result.put("advice","Consult a doctor if symptoms worsen.");

            return result;

        }

    }
}