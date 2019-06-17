package io.ps.blockexplorer0614.dao;

import io.ps.blockexplorer0614.po.Tx_detall;

public interface Tx_detallMapper {
    int deleteByPrimaryKey(Long txDetallId);

    int insert(Tx_detall record);

    int insertSelective(Tx_detall record);

    Tx_detall selectByPrimaryKey(Long txDetallId);

    int updateByPrimaryKeySelective(Tx_detall record);

    int updateByPrimaryKey(Tx_detall record);
}