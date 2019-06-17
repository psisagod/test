package io.ps.blockexplorer0614.dao;

import io.ps.blockexplorer0614.po.Bitcoin;

public interface BitcoinMapper {
    int deleteByPrimaryKey(Integer bitcoinId);

    int insert(Bitcoin record);

    int insertSelective(Bitcoin record);

    Bitcoin selectByPrimaryKey(Integer bitcoinId);

    int updateByPrimaryKeySelective(Bitcoin record);

    int updateByPrimaryKey(Bitcoin record);
}