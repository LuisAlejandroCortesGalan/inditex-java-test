package com.backendtest.inditex_backend.service;


import com.backendtest.inditex_backend.model.product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;



@Service
public class productService {

    private static final Logger logger = LoggerFactory.getLogger(productService.class);
    private static final String BASE_URL = "http://localhost:3001/product/";

    private final RestTemplate restTemplate = new RestTemplate();

    public List<product> getSimilarProducts(String productId) {
        List<product> similarProducts = new ArrayList<>();

        try {
            logger.info("Fetching similar product IDs for product {}", productId);
            ResponseEntity<String[]> response = restTemplate.getForEntity(BASE_URL + productId + "/similarids", String[].class);
            String[] similarIds = response.getBody();

            if (similarIds == null || similarIds.length == 0) {
                logger.warn("No similar products found for product {}", productId);
                return similarProducts;
            }

            for (String id : similarIds) {
                try {
                    product product = restTemplate.getForObject(BASE_URL + id, product.class);
                    if (product != null) {
                        similarProducts.add(product);
                        logger.debug("Added similar product: {}", product.getId());
                    }
                } catch (HttpClientErrorException ex) {
                    logger.warn("Could not fetch product {}. Status: {}", id, ex.getStatusCode());
                }
            }

        } catch (HttpClientErrorException ex) {
            logger.error("Failed to fetch similar IDs for product {}. Status: {}", productId, ex.getStatusCode());
            throw ex; 
        }

        return similarProducts;
    }
}
