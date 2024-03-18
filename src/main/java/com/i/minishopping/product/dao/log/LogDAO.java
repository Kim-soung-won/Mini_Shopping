package com.i.minishopping.product.dao.log;

import com.i.minishopping.product.bean.log.LogDTO;

import java.util.List;

public interface LogDAO {
    void writeLog(LogDTO logDTO);

    List<LogDTO> getLogList();

    void updateLog(LogDTO logDTO);

    void deleteLog(LogDTO logDTO);


}
