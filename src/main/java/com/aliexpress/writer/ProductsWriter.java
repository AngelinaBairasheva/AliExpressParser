package com.aliexpress.writer;


import au.com.bytecode.opencsv.CSVWriter;
import com.aliexpress.model.Product;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ProductsWriter {
    private static final String CSV_FILE_PATH = "./src/test/java/resources/";
    private static final String CSV_FILE_NAME = "data.csv";
    private CSVWriter writer;

    public void writeToCSV(List<Product> list) throws IOException {
        writeHeaders();
        for (Product product : list) {
            writer.writeNext(new String[]{String.valueOf(product.getProductId()), String.valueOf(product.getSellerId()), product.getOriMinPrice(),
                    product.getOriMaxPrice(), String.valueOf(product.getPromotionId()), String.valueOf(product.getStartTime()),
                    String.valueOf(product.getEndTime()), String.valueOf(product.getPhase()), product.getProductTitle(), product.getMinPrice(),
                    product.getMaxPrice(), String.valueOf(product.getDiscount()), product.getTotalStock(), product.getStock(), product.getOrders(),
                    String.valueOf(product.getSoldout()), product.getProductImage(), product.getTotalTranpro3(), product.getProductPositiveRate(),
                    product.getProductAverageStar(), String.valueOf(product.getItemEvalTotalNum()), String.valueOf(product.getGmtCreate())});

        }
        writer.close();
    }

    private void writeHeaders() throws IOException {
        String[] header = new String[]{"productId", "sellerId", "oriMinPrice", "oriMaxPrice", "promotionId",
                "startTime", "endTime", "phase", "productTitle", "minPrice", "maxPrice", "discount", "totalStock",
                "stock", "orders", "soldout", "productImage", "totalTranpro3", "productPositiveRate", "productAverageStar",
                "itemEvalTotalNum", "gmtCreate"};
        File file = new File(CSV_FILE_PATH);
        file.mkdirs();
        file = new File(CSV_FILE_PATH + CSV_FILE_NAME);

        writer = new CSVWriter(new FileWriter(file), ' ');
        writer.writeNext(header);
    }
}
