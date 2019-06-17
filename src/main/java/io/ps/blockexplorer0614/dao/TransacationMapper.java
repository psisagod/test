package io.ps.blockexplorer0614.dao;

import io.ps.blockexplorer0614.po.Transacation;

public interface TransacationMapper {
    int deleteByPrimaryKey(Integer transacationId);

    int insert(Transacation record);

    int insertSelective(Transacation record);

    Transacation selectByPrimaryKey(Integer transacationId);

    int updateByPrimaryKeySelective(Transacation record);

    int updateByPrimaryKey(Transacation record);
}