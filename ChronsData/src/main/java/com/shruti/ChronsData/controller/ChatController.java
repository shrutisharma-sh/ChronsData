package com.shruti.ChronsData.controller;


import com.shruti.ChronsData.model.MetadataRequest;
import com.shruti.ChronsData.service.AIService;
import com.shruti.ChronsData.service.MetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ChatController {


    @Autowired
    private AIService aiService;

    @Autowired
    private MetadataService metadataService;

    @PostMapping("/chat")
    public String chat(@RequestBody String query) {


        String tableName = aiService.extractTableName(query);

        System.out.println("Extracted table: " + tableName);


        String owner = metadataService.getOwner(tableName);


        if(owner.equals("Unknown")) {
            return "I couldn’t find that table.";
        }

        return tableName + " table is owned by " + owner;
    }

    @PostMapping("/validate-metadata")
    public String validateMetadata(@RequestBody MetadataRequest request) {

        if(request.getTable() == null || request.getTable().isEmpty()) {

            String explanation = aiService.explainIssue("Missing table name");

            return "Deployment Blocked: Table name missing\n " + explanation;
        }

        if(request.getOwner() == null || request.getOwner().isEmpty()) {

            String explanation = aiService.explainIssue("Missing owner");

            return "Deployment Blocked: Missing owner\n " + explanation;
        }

        return "Deployment Allowed";
    }
}