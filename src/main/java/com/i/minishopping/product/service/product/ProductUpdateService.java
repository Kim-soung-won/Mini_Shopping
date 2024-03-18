package com.i.minishopping.product.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.i.minishopping.product.bean.product.ProductDTO;
import com.i.minishopping.product.dao.product.ProductDAO;

import java.util.List;
import java.util.Scanner;

@Service
public class ProductUpdateService implements ProductService {
    @Autowired
    private ProductDAO productDAO;
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println();

        List<ProductDTO> list = productDAO.getProductList();

        System.out.print("수정할 일련번호 입력 : ");
        Long product_id = sc.nextLong();

        int sw = 0;
        for(ProductDTO productDTO : list) {

            if(productDTO.getProductId() == product_id) {

                System.out.println(productDTO);
                System.out.println();

                System.out.println("수정할 제품명 입력 : ");
                String pd_name = sc.next();
                System.out.println("수정할 가격 입력 : ");
                int pd_price = sc.nextInt();
                System.out.println("수정할 카테고리 입력 : ");
                String pd_category = sc.next();


                productDTO.setPdName(pd_name);
                productDTO.setPdPrice(pd_price);
                productDTO.setPdCategory(pd_category);

                productDAO.updateProduct(productDTO);
                sw = 1;
                System.out.println("수정을 완료했습니다.");

                break;

            } // if

        } // enhanced for

        if(sw == 0) {
            System.out.println("아이디가 존재하지 않습니다.");
        } // if

    } // execute
}
