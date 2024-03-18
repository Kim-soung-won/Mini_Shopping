package com.i.minishopping.brand.service;

import com.i.minishopping.brand.bean.BrandDTO;
import com.i.minishopping.brand.dao.BrandDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class BrandInsertService implements BrandService {
    private final BrandDTO brandDTO;
    private final BrandDAO brandDAO;
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("브랜드I 입력 : ");
        Long brandId = sc.nextLong();
        System.out.print("브랜드N 입력 : ");
        String brandName = sc.next();

        brandDTO.setBrandId(brandId);
        brandDTO.setBrandName(brandName);

        brandDAO.writeBrand(brandDTO);

        System.out.println("데이터 저장되었습니다.");
    }
}
