package com.shruti.ChronsData.controller;


import com.shruti.ChronsData.service.MetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ChatController {

    @Autowired
    private MetadataService metadataService;

    @PostMapping("/chat")
    public String chat(@RequestBody String query) {

        if(query.toLowerCase().contains("orders")) {
            String owner = metadataService.getOwner("orders");
            return "Orders table is owned by " + owner;
        }

        if(query.toLowerCase().contains("customers")) {
            String owner = metadataService.getOwner("customers");
            return "Customers table is owned by " + owner;
        }

        return "Sorry, I don’t understand the question.";
    }
}