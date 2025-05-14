package com.backendtest.inditex_backend.controller;


import com.backendtest.inditex_backend.model.product;
import com.backendtest.inditex_backend.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class productController {

    @Autowired
    private productService productService;

    @GetMapping("/{productId}/similar")
    public List<product> getSimilarProducts(@PathVariable String productId) {
        return productService.getSimilarProducts(productId);
    }
}
