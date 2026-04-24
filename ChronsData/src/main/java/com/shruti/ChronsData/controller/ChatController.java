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


        if (owner.equals("Unknown")) {
            return "I couldn’t find that table.";
        }

        return tableName + " table is owned by " + owner;
    }

    @PostMapping("/validate-metadata")
    public String validateMetadata(@RequestBody MetadataRequest request) {

        int score = 100;

        StringBuilder result = new StringBuilder();

        // Missing table name
        if (request.getTable() == null || request.getTable().isEmpty()) {

            score -= 50;

            result.append(" Missing table name\n\n");
        }

        // Missing owner
        if (request.getOwner() == null || request.getOwner().isEmpty()) {

            score -= 40;

            result.append(" Missing owner\n\n");
        }

        // Sensitive data detection
        if (request.getTable() != null) {

            String table = request.getTable().toLowerCase();

            if (table.contains("payment") ||
                    table.contains("salary") ||
                    table.contains("customer")) {

                score -= 10;

                result.append(" Sensitive data detected\n\n");
            }
        }

        // Final response
        String finalResult =
                " Metadata Health Score: "
                        + score
                        + "/100\n\n"
                        + result.toString();

        if (score == 100) {
            finalResult += " Deployment Allowed";
        } else {
            finalResult += " Deployment Blocked";
        }

        return finalResult;
    }
}