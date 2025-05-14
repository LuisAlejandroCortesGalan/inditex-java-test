package com.backendtest.inditex_backend.service;


import com.backendtest.inditex_backend.model.product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@Service
public class productService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "http://localhost:3001/product/";

    public List<product> getSimilarProducts(String productId) {
        List<product> similarProducts = new ArrayList<>();
        try {
            String[] similarIds = restTemplate.getForObject(BASE_URL + productId + "/similarids", String[].class);

            for (String id : similarIds) {
                try {
                    product product = restTemplate.getForObject(BASE_URL + id, product.class);
                    if (product != null) similarProducts.add(product);
                } catch (HttpClientErrorException e) {
                    // Ignoramos productos no encontrados
                }
            }
        } catch (HttpClientErrorException e) {
            // Puedes lanzar una excepción personalizada o devolver vacío
        }
        return similarProducts;
    }
}
