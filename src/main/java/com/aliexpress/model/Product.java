package com.aliexpress.model;

public class Product {
    private Long productId;
    private Long sellerId;
    private String oriMinPrice;
    private String oriMaxPrice;
    private Long promotionId;
    private Long startTime;
    private Long endTime;
    private Long phase;
    private String productTitle;
    private String minPrice;
    private String maxPrice;
    private Long discount;
    private String totalStock;
    private String stock;
    private String orders;
    private Boolean soldout;
    private String productImage;
    private String totalTranpro3;
    private String productPositiveRate;
    private String productAverageStar;
    private Long itemEvalTotalNum;
    private Long gmtCreate;

    public Product(Long productId, Long sellerId, String oriMinPrice, String oriMaxPrice, Long promotionId, Long startTime, Long endTime, Long phase, String productTitle, String minPrice, String maxPrice, Long discount, String totalStock, String stock, String orders, Boolean soldout, String productImage, String totalTranpro3, String productPositiveRate, String productAverageStar, Long itemEvalTotalNum, Long gmtCreate) {
        this.productId = productId;
        this.sellerId = sellerId;
        this.oriMinPrice = oriMinPrice;
        this.oriMaxPrice = oriMaxPrice;
        this.promotionId = promotionId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.phase = phase;
        this.productTitle = productTitle;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.discount = discount;
        this.totalStock = totalStock;
        this.stock = stock;
        this.orders = orders;
        this.soldout = soldout;
        this.productImage = productImage;
        this.totalTranpro3 = totalTranpro3;
        this.productPositiveRate = productPositiveRate;
        this.productAverageStar = productAverageStar;
        this.itemEvalTotalNum = itemEvalTotalNum;
        this.gmtCreate = gmtCreate;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public String getOriMinPrice() {
        return oriMinPrice;
    }

    public String getOriMaxPrice() {
        return oriMaxPrice;
    }

    public Long getPromotionId() {
        return promotionId;
    }

    public Long getStartTime() {
        return startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public Long getPhase() {
        return phase;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public Long getDiscount() {
        return discount;
    }

    public String getTotalStock() {
        return totalStock;
    }

    public String getStock() {
        return stock;
    }

    public String getOrders() {
        return orders;
    }

    public Boolean getSoldout() {
        return soldout;
    }

    public String getProductImage() {
        return productImage;
    }

    public String getTotalTranpro3() {
        return totalTranpro3;
    }

    public String getProductPositiveRate() {
        return productPositiveRate;
    }

    public String getProductAverageStar() {
        return productAverageStar;
    }

    public Long getItemEvalTotalNum() {
        return itemEvalTotalNum;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }
}
