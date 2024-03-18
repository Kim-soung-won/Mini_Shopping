package com.i.minishopping.product.dao.detail;

import com.i.minishopping.product.bean.detail.DetailDTO;

import java.util.List;

public interface DetailDAO {
    void writeDetail(DetailDTO detailDTO);

    List<DetailDTO> getDetailList();

    void updateDetail(DetailDTO detailDTO);

    void deleteDetail(DetailDTO detailDTO);

    DetailDTO checkSize(String size);
}
