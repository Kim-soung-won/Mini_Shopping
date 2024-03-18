package com.i.minishopping.product.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.i.minishopping.product.bean.product.ProductDTO;
import com.i.minishopping.product.dao.product.ProductDAO;

import java.util.List;
import java.util.Scanner;

@Service
public class ProductDeleteService implements ProductService {
    @Autowired
    private ProductDAO productDAO;
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);

        System.out.print("삭제할 일련번호 입력 : ");
        Long product_id = sc.nextLong();

        List<ProductDTO> list = productDAO.getProductList();
        int sw = 0;
        for(ProductDTO productDTO : list) {

            if(productDTO.getProductId() == product_id) {

                sw = 1;
                productDAO.deleteProduct(productDTO);
                list.remove(productDTO);

                System.out.println("삭제를 완료했습니다.");
                break;

            } // if

        } // enhanced for

        if(sw == 0) {
            System.out.println("아이디가 존재하지 않습니다.");
        } // if

    }
}
