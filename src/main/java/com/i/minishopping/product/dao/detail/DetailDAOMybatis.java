package com.i.minishopping.product.dao.detail;

import com.i.minishopping.product.bean.detail.DetailDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class DetailDAOMybatis implements DetailDAO {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public void writeDetail(DetailDTO detailDTO) {
        sqlSession.insert("detailSQL.writeDetail", detailDTO);
    }

    @Override
    public List<DetailDTO> getDetailList() {
        return sqlSession.selectList("detailSQL.getDetailList");
    }

    @Override
    public void updateDetail(DetailDTO detailDTO) {
        sqlSession.update("detailSQL.updateDetail", detailDTO);
    }

    @Override
    public void deleteDetail(DetailDTO detailDTO) {
        sqlSession.delete("detailSQL.deleteDetail", detailDTO);
    }

    @Override
    public DetailDTO checkSize(String size) {
        return sqlSession.selectOne("detailSQL,checkSize", size);
    }
}
