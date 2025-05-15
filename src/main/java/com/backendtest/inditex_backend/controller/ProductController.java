package com.backendtest.inditex_backend.controller;


import com.backendtest.inditex_backend.model.Product;
import com.backendtest.inditex_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService ProductService;

    @GetMapping("/{productId}/similar")
    public List<Product> getSimilarProducts(@PathVariable String productId) {
        return ProductService.getSimilarProducts(productId);
    }
}
