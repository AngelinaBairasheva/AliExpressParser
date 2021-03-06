package com.aliexpress.parser;

import com.aliexpress.model.CustomResponse;
import com.aliexpress.model.Product;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonParser {
    //parameter from the response body
    public static String postbackJson;

    public List<Product> getProducts(String response) throws JSONException {
        List<Product> productsResult = new ArrayList<>();

        //create an object from JSON received from the HTTP response
        CustomResponse customResponseJson = getCustomResponse(response);
        //get a list of products for parsing
        JSONArray jsonArray = new JSONArray(customResponseJson.getResults());
        //parsing of goods
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject productJson = jsonArray.getJSONObject(i);
            long id = productJson.getLong("productId");
            long sellerId = productJson.getLong("sellerId");
            String oriMinPrice = productJson.getString("oriMinPrice");
            String oriMaxPrice = productJson.getString("oriMaxPrice");
            long promotionId = productJson.getLong("promotionId");
            long startTime = productJson.getLong("startTime");
            long endTime = productJson.getLong("endTime");
            long phase = productJson.getLong("phase");
            String productTitle = productJson.getString("productTitle");
            String minPrice = productJson.getString("minPrice");
            String maxPrice = productJson.getString("maxPrice");
            long discount = productJson.getLong("discount");
            String totalStock = productJson.getString("totalStock");
            String stock = productJson.getString("stock");
            String orders = productJson.getString("orders");
            Boolean soldout = productJson.getBoolean("soldout");
            String productImage = productJson.getString("productImage");
            String totalTranpro3 = productJson.getString("totalTranpro3");
            String productPositiveRate = productJson.getString("productPositiveRate");
            String productAverageStar = productJson.getString("productAverageStar");
            Long itemEvalTotalNum = productJson.getLong("itemEvalTotalNum");
            Long gmtCreate = productJson.getLong("gmtCreate");

            Product product = new Product(id, sellerId, oriMinPrice, oriMaxPrice, promotionId, startTime, endTime,
                    phase, productTitle, minPrice, maxPrice, discount, totalStock, stock, orders, soldout,
                    productImage, totalTranpro3, productPositiveRate, productAverageStar, itemEvalTotalNum, gmtCreate);

            productsResult.add(product);
        }
        return productsResult;
    }

    /**
     * ???????????? JSON ?????????????? ???? ????????????
     *
     * @param "???????????? ??????????????"
     * @return ????????????, ?????????????????? ?? ????????????
     * @throws JSONException
     */
    public CustomResponse getCustomResponse(String response) throws JSONException {
        JSONObject responseJson = new JSONObject(response);
        String postback = responseJson.getString("postback");
        postbackJson = postback;

        JSONArray result = responseJson.getJSONArray("results");

        return new CustomResponse(result);
    }
}