package com.i.minishopping.brand.dao;

import com.i.minishopping.brand.bean.BrandDTO;

import java.util.List;

public interface BrandDAO {
    void writeBrand(BrandDTO brandDTO);

    List<BrandDTO> getBrandList();

    void updateBrand(BrandDTO brandDTO);

    void deleteBrand(BrandDTO brandDTO);

    BrandDTO checkBrandId(Long brandId);
}
