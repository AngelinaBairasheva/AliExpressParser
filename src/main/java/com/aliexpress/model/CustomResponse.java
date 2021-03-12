package com.aliexpress.model;

import org.json.JSONArray;

/**
 * Ответ в формате JSON на запрос товаров
 */
public class CustomResponse {
    //список продуктов
    private JSONArray results;

    public CustomResponse(JSONArray results) {
        this.results = results;
    }

    public JSONArray getResults() {
        return results;
    }
}
