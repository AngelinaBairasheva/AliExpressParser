package com.aliexpress.model;

import org.json.JSONArray;

/**
 * JSON response from HTTP Response
 */
public class CustomResponse {
    //list of goods
    private JSONArray results;

    public CustomResponse(JSONArray results) {
        this.results = results;
    }

    public JSONArray getResults() {
        return results;
    }
}
