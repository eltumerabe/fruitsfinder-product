package com.fruitsfinder.product.controller;

import com.fruitsfinder.product.model.dto.ProductDTO;
import com.fruitsfinder.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody final ProductDTO productDTO) {
        return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.CREATED);
    }

    @GetMapping("{publicId}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable(value = "publicId") final String publicId) {
        return ResponseEntity.ok(productService.getByPublicId(publicId));
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProduct(@RequestParam(name = "page", defaultValue = "0") final int page, @RequestParam(name = "size", defaultValue = "5") final int size) {
        return ResponseEntity.ok(productService.getAll(page, size));
    }
}
