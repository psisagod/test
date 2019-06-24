package io.ps.blockexplorer0614.service.impl;

import io.ps.blockexplorer0614.dao.BlockMapper;
import io.ps.blockexplorer0614.dao.TransacationMapper;
import io.ps.blockexplorer0614.dto.BlockGetDTO;
import io.ps.blockexplorer0614.dto.BlockListDTO;
import io.ps.blockexplorer0614.po.Block;
import io.ps.blockexplorer0614.po.Transacation;
import io.ps.blockexplorer0614.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {
    @Autowired
    private BlockMapper blockMapper;
    @Autowired
    private TransacationMapper transacationMapper;
    @Override
    public List<BlockListDTO> getRecentBlocks() {
        int i = 0;
        ArrayList<BlockListDTO> blockListDTOS = new ArrayList<>();
        List<Transacation> txs = transacationMapper.selectRecentTxs();
        List<Block> blocks = blockMapper.selectRecentBlocks();
        String transactionsAll = "";
        for (Transacation tx : txs) {
            transactionsAll += tx.getConfirmations()+",";
        }
        transactionsAll=transactionsAll.substring(0,transactionsAll.length()-1);
        String transaction[]=transactionsAll.split(",");
        for(Block block : blocks){
            BlockListDTO blockListDTO = new BlockListDTO();
            blockListDTO.setHeight(block.getHeight());
            Long time = block.getTime().getTime();
            Long leadtime = new Date().getTime()-time;
            Integer minutes = Math.toIntExact(leadtime / 1000 / 60);
            blockListDTO.setAge(minutes);
            blockListDTO.setMiner("ps");
            blockListDTO.setSize( block.getSize());
            blockListDTO.setTransactions(Integer.parseInt(transaction[i]));
            blockListDTOS.add(blockListDTO);
            i++;
        }
        return blockListDTOS;
    }


    @Override
    public List<BlockListDTO> getMoreBlocks() {
        int i = 0;
        ArrayList<BlockListDTO> blockListDTOS = new ArrayList<>();
        List<Transacation> txs = transacationMapper.getMoreTxs();
        List<Block> blocks = blockMapper.getMoreBlocks();
        String transactionsAll = "";
        for (Transacation tx : txs) {
            transactionsAll += tx.getConfirmations()+",";
        }
        transactionsAll=transactionsAll.substring(0,transactionsAll.length()-1);
        String transaction[]=transactionsAll.split(",");
        for(Block block : blocks){
            BlockListDTO blockListDTO = new BlockListDTO();
            blockListDTO.setHeight(block.getHeight());
            Long time = block.getTime().getTime();
            Long leadtime = new Date().getTime()-time;
            Integer minutes = Math.toIntExact(leadtime / 1000 / 60);
            blockListDTO.setAge(minutes);
            blockListDTO.setMiner("ps");
            blockListDTO.setSize( block.getSize());
            blockListDTO.setTransactions(Integer.parseInt(transaction[i]));
            blockListDTOS.add(blockListDTO);
            i++;
        }
        return blockListDTOS;
    }
}
