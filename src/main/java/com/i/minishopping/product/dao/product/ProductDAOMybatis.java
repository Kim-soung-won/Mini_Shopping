package com.i.minishopping.product.dao.product;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.i.minishopping.product.bean.product.ProductDTO;

import java.util.List;

@Transactional
@Repository
public class ProductDAOMybatis implements ProductDAO {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public void write(ProductDTO productDTO) {
        sqlSession.insert("productSQL.write", productDTO);
    }

    @Override
    public List<ProductDTO> getProductList() {
        return sqlSession.selectList("productSQL.getProductList");
    }

    @Override
    public ProductDTO getFindProduct(Long id) {
        return null;
    }

    @Override
    public void updateProduct(ProductDTO productDTO) {
        sqlSession.update("productSQL.updateProduct", productDTO);
    }

    @Override
    public void deleteProduct(ProductDTO productDTO) {
        sqlSession.delete("productSQL.deleteProduct", productDTO);
    }

    @Override
    public ProductDTO checkProdutId(Long productId) {
        return null;
    }

    @Override
    public ProductDTO checkProductId(Long productId) {
        return sqlSession.selectOne("productSQL.checkProductId", productId);
    }
}
