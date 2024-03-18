package com.i.minishopping.brand.service;

import com.i.minishopping.brand.bean.BrandDTO;
import com.i.minishopping.brand.dao.BrandDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class BrandDeleteService implements BrandService {
    private final BrandDAO brandDAO;

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);

        System.out.print("삭제할 브랜드I 입력 : ");
        Long brandId = sc.nextLong();

        List<BrandDTO> list = brandDAO.getBrandList();
        int sw = 0;
        for(BrandDTO brandDTO : list) {

            if(brandDTO.getBrandId() == brandId) {

                sw = 1;
                brandDAO.deleteBrand(brandDTO);
                list.remove(brandDTO);

                System.out.println("삭제를 완료했습니다.");
                break;

            } // if

        } // enhanced for

        if(sw == 0) {
            System.out.println("존재하지 않습니다.");
        }
    }
}
