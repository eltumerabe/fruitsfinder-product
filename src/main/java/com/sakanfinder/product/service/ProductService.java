package com.sakanfinder.product.service;

import com.sakanfinder.product.dto.ProductDTO;
import com.sakanfinder.product.entity.Product;

public interface ProductService {
    ProductDTO createProduct(final ProductDTO productDTO);

    ProductDTO getByPublicId(final String publicId);

}
