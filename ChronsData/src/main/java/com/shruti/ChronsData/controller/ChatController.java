package com.shruti.ChronsData.controller;


import com.shruti.ChronsData.service.AIService;
import com.shruti.ChronsData.service.MetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ChatController {


    @Autowired
    private AIService aiService;

    @PostMapping("/chat")
    public String chat(@RequestBody String query) {

        String aiResponse = aiService.extractTableName(query);

        return "AI says: " + aiResponse;
    }
}