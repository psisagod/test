package io.ps.blockexplorer0614.service.impl;

import io.ps.blockexplorer0614.dao.TransacationMapper;
import io.ps.blockexplorer0614.dto.TxListDTO;
import io.ps.blockexplorer0614.po.Block;
import io.ps.blockexplorer0614.po.Transacation;
import io.ps.blockexplorer0614.service.TxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TxServiceImpl implements TxService {
    @Autowired
    private TransacationMapper transacationMapper;
    @Override
    public List<TxListDTO> getRecentTxs() {
        ArrayList<TxListDTO> txListDTOS = new ArrayList<>();
        List<Transacation> txs = transacationMapper.selectRecentTxs();
        for (Transacation tx : txs) {
            TxListDTO txListDTO = new TxListDTO();
            txListDTO.setTransaction_hash(tx.getTxhash());
            Long time = tx.getTime().getTime();
            Long leadtime = new Date().getTime()-time;
            Integer minutes = Math.toIntExact(leadtime / 1000 / 60);
            txListDTO.setAge(minutes);
            //todo txListDTO.setAmount_eth();
            //todo txListDTO.setAmount_usd();
            txListDTOS.add(txListDTO);
        }
        return txListDTOS;
    }
}
