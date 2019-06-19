package io.ps.blockexplorer0614.service;

import io.ps.blockexplorer0614.dto.TxListDTO;

import java.util.List;


public interface TxService {
    List<TxListDTO> getRecentTxs();
}
