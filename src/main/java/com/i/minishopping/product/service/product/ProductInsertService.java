package com.i.minishopping.product.service.product;

import com.i.minishopping.brand.bean.BrandDTO;
import com.i.minishopping.brand.dao.BrandDAO;
import com.i.minishopping.user.bean.UserDTO;
import com.i.minishopping.user.dao.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.i.minishopping.product.bean.product.ProductDTO;
import com.i.minishopping.product.dao.product.ProductDAO;

import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class ProductInsertService implements ProductService {
    private final BrandDAO brandDAO;
    private final ProductDTO productDTO;
    private final ProductDAO productDAO;
    private final UserDAO userDAO;
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("제품명 입력 : ");
        String pdName = sc.next();
        System.out.print("가격 입력 : ");
        int pdPrice = sc.nextInt();
        System.out.print("브랜드 입력 : ");
        Long brandId = sc.nextLong();
        BrandDTO brandDTO = brandDAO.checkBrandId(brandId);

        System.out.println();
        if(brandDTO == null) {
            System.out.println("찾고자 하는 브랜드가 없습니다.");
            return;
        }


        System.out.print("카테고리 입력 : ");
        String pdCategory = sc.next();
        System.out.print("등록자 : 입력");
        Long createdWho = sc.nextLong();
        UserDTO userDTO = userDAO.checkCreatedWho(createdWho);

        System.out.println();
        if(userDTO == null) {
            System.out.println("찾고자 하는 등록자가 없습니다.");
            return;
        }


        productDTO.setPdName(pdName);
        productDTO.setPdPrice(pdPrice);
        productDTO.setBrandId(brandId);
        productDTO.setPdCategory(pdCategory);
        productDTO.setCreatedWho(createdWho);

        productDAO.write(productDTO);

        System.out.println("데이터가 저장됐습니다.");
    }
}
