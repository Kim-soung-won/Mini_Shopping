package com.i.minishopping.brand.dao;

import com.i.minishopping.brand.bean.BrandDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class BrandDAOMybatis implements BrandDAO {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public void writeBrand(BrandDTO brandDTO) {
        sqlSession.insert("brandSQL.writeBrand", brandDTO);
    }

    @Override
    public List<BrandDTO> getBrandList() {
        return sqlSession.selectList("brandSQL.getBrandList");
    }

    @Override
    public void updateBrand(BrandDTO brandDTO) {
        sqlSession.update("brandSQL.updateBrand", brandDTO);
    }

    @Override
    public void deleteBrand(BrandDTO brandDTO) {
        sqlSession.delete("brandSQL.deleteBrand", brandDTO);
    }

    @Override
    public BrandDTO checkBrandId(Long brandId) {
        return sqlSession.selectOne("brandSQL.checkBrandId",brandId);
    }
}
