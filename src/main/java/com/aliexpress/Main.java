package com.aliexpress;

import com.aliexpress.model.Product;
import com.aliexpress.writer.ProductsWriter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    public static final Logger log = Logger.getLogger(Main.class.getName());
    /* Ход решения
        Получить товары можно по адресу: https://gpsfront.aliexpress.com/getRecommendingResults.do
        В параметрах можно выставить лимит до 50 товаров, но больше 40 получить не вышло.
        Нам нужно будет 3 запроса делать: 20 товаров и 2 запроса по 40 товаров. Зачем делать 3 - нам нужен параметр postback
        для запросов в цикле, без него дальше 50 товара я ловила ошибку
        Сам параметр придет вместе с 1 запросом
        */

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        int offset = 20;
        String url = "https://gpsfront.aliexpress.com/getRecommendingResults.do?widget_id=5547572&platform=pc";
        HttpClient client = new HttpClient();

        List<Product> productList = client.readProducts(url + "&limit=20");
        List<Product> res = new ArrayList<>(productList);

        String postback = client.getPostback();

        for (int i = 0; i < 2; i++) {
            offset += 40;
            List<Product> products = client.readProducts(url + "&limit=40&offset=" + offset + "&postback=" + postback);
            res.addAll(products);
        }

        //запись продуктов в файл
        ProductsWriter writer = new ProductsWriter();
        writer.writeToCSV(res);

        long totalTime = System.currentTimeMillis() - startTime;     // берем время после метода.
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(totalTime);
        SimpleDateFormat format = new SimpleDateFormat("mm:ss");
        log.info("Время, потраченное на выгрузку товаров: " + format.format(cal.getTime()));
    }
}
