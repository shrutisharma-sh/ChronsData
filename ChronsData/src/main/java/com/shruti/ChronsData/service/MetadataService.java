package com.shruti.ChronsData.service;

import org.springframework.stereotype.Service;

@Service
public class MetadataService {

    public String getOwner(String tableName) {

        if(tableName.equalsIgnoreCase("orders")) {
            return "data_team";
        }

        if(tableName.equalsIgnoreCase("customers")) {
            return "analytics_team";
        }

        return "Unknown table";
    }
}