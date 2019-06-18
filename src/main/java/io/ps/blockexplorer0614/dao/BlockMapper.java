package io.ps.blockexplorer0614.dao;

import io.ps.blockexplorer0614.po.Block;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlockMapper {
    int deleteByPrimaryKey(Integer blockId);

    int insert(Block record);

    int insertSelective(Block record);

    Block selectByPrimaryKey(Integer blockId);

    int updateByPrimaryKeySelective(Block record);

    int updateByPrimaryKey(Block record);

    List<Block> selectRecentBlocks();
}