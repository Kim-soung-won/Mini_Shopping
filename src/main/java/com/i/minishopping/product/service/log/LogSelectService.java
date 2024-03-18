package com.i.minishopping.product.service.log;

import com.i.minishopping.product.bean.log.LogDTO;
import com.i.minishopping.product.dao.log.LogDAO;
import com.i.minishopping.product.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LogSelectService implements LogService {
    private final LogDAO logDAO;
    private ProductService productService;
    @Override
    public void execute() {
        System.out.println();

        List<LogDTO> list = logDAO.getLogList();
        System.out.println("일련번호\t사이즈\t수량\t\t등록자\t등록시간");
        for(LogDTO logDTO : list){
            System.out.println(" " + logDTO.getProductId() + "\t\t"
                    + logDTO.getSize() + "\t\t"
                    + logDTO.getCount() + "\t\t"
                    + logDTO.getCreatedWho() + "\t\t"
                    + logDTO.getCreatedAt());
        } // for
    }
}
