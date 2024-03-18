package com.i.minishopping.product.service.detail;

import com.i.minishopping.product.bean.detail.DetailDTO;
import com.i.minishopping.product.dao.detail.DetailDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class DetailSelectService implements DetailService {
    private final DetailDAO detailDAO;
    @Override
    public void execute() {
        System.out.println();

        List<DetailDTO> list = detailDAO.getDetailList();
        System.out.println("일련번호\t사이즈\t입고수량\t판매수량");
        for(DetailDTO detailDTO : list){
            System.out.println(" " + detailDTO.getProductId() + "\t\t"
                    + detailDTO.getSize() + "\t\t"
                    + detailDTO.getPdBeforeCount() + "\t\t"
                    + detailDTO.getPdSellCount());

        } // for

    }
}
