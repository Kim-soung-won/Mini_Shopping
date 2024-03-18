package com.i.minishopping.product.dao.log;

import com.i.minishopping.product.bean.log.LogDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class LogDAOMybatis implements LogDAO {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public void writeLog(LogDTO logDTO) {
        sqlSession.insert("logSQL.writeLog", logDTO);
    }

    @Override
    public List<LogDTO> getLogList() {
        return sqlSession.selectList("logSQL.getLogList");
    }

    @Override
    public void updateLog(LogDTO logDTO) {
        sqlSession.update("logSQL.updateLog", logDTO);
    }

    @Override
    public void deleteLog(LogDTO logDTO) {
        sqlSession.delete("logSQL.deleteLog", logDTO);
    }
}
