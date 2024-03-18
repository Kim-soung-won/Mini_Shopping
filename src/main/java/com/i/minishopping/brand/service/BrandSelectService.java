package com.i.minishopping.brand.service;

import com.i.minishopping.brand.bean.BrandDTO;
import com.i.minishopping.brand.dao.BrandDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandSelectService implements BrandService {
    private final BrandDAO brandDAO;
    @Override
    public void execute() {
        System.out.println();
        List<BrandDTO> list = brandDAO.getBrandList();
        System.out.println("브랜드I\t브랜드N\t등록시간");
        for(BrandDTO brandDTO : list) {
            System.out.println();
            System.out.print(" " + brandDTO.getBrandId() + "\t\t"
                                 + brandDTO.getBrandName() + "\t\t"
                                 + brandDTO.getCreatedAt());
        }

    }
}
