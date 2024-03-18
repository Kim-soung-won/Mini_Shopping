package com.i.minishopping.product.dao.product;

import com.i.minishopping.product.bean.product.ProductDTO;

import java.util.List;

public interface ProductDAO {
    void write(ProductDTO productDTO);

    List<ProductDTO> getProductList();
    ProductDTO getFindProduct(Long id);
    void updateProduct(ProductDTO productDTO);

    void deleteProduct(ProductDTO productDTO);

    ProductDTO checkProdutId(Long productId);

    ProductDTO checkProductId(Long productId);
}
