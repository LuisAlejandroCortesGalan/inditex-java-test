package com.backendtest.inditex_backend.service;

import com.backendtest.inditex_backend.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.ArrayList;
import java.util.List;

@Service
public class productService {

    private static final Logger logger = LoggerFactory.getLogger(productService.class);
    private final WebClient webClient;

    public productService() {
        this.webClient = WebClient.builder()
                .baseUrl("http://simulado")
                .build();
    }

    public List<Product> getSimilarProducts(String productId) {
        List<Product> similarProducts = new ArrayList<>();

        try {
            logger.info("Fetching similar product IDs for product {}", productId);
            String[] similarIds = webClient.get()
                    .uri("/product/{id}/similarids", productId)
                    .retrieve()
                    .bodyToMono(String[].class)
                    .block();

            if (similarIds == null || similarIds.length == 0) {
                logger.warn("No similar products found for product {}", productId);
                return similarProducts;
            }

            for (String id : similarIds) {
                try {
                    Product product = webClient.get()
                            .uri("/product/{id}", id)
                            .retrieve()
                            .bodyToMono(Product.class)
                            .block();

                    if (product != null) {
                        similarProducts.add(product);
                        logger.debug("Added similar product: {}", product.getId());
                    }
                } catch (WebClientResponseException ex) {
                    logger.warn("Could not fetch product {}. Status: {}", id, ex.getStatusCode());
                }
            }

        } catch (WebClientResponseException ex) {
            logger.error("Failed to fetch similar IDs for product {}. Status: {}", productId, ex.getStatusCode());
            throw ex;
        }

        return similarProducts;
    }
}
