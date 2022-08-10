package com.sakanfinder.product.controller;

import com.sakanfinder.product.dto.ProductDTO;
import com.sakanfinder.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody final ProductDTO productDTO) {
        return ResponseEntity.ok(productService.createProduct(productDTO));
    }

    @GetMapping("{publicId}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable(value = "publicId") final String publicId) {
        return ResponseEntity.ok(productService.getByPublicId(publicId));
    }
}
