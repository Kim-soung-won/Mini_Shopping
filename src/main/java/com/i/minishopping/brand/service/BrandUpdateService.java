package com.i.minishopping.brand.service;

import com.i.minishopping.brand.bean.BrandDTO;
import com.i.minishopping.brand.dao.BrandDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class BrandUpdateService implements BrandService {
    private final BrandDAO brandDAO;

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println();

        List<BrandDTO> list = brandDAO.getBrandList();

        System.out.print("수정할 브랜드I 입력 : ");
        Long brandId = sc.nextLong();

        int sw = 0;
        for(BrandDTO brandDTO : list) {
            if(brandDTO.getBrandId() == brandId) {
                System.out.println(brandDTO);
                System.out.println();

                System.out.print("수정할 브랜드N 입력 : ");
                String brandName = sc.next();

                brandDTO.setBrandId(brandId);
                brandDTO.setBrandName(brandName);

                brandDAO.updateBrand(brandDTO);
                sw = 1;
                System.out.println("수정 완료했습니다.");

                break;
            }
        }

        if(sw == 0) {
            System.out.println("존재 하지 않습니다.");
        }

    }
}
