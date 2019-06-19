package io.ps.blockexplorer0614.service;

import io.ps.blockexplorer0614.dto.BlockListDTO;

import java.util.List;

public interface BlockService {

    List<BlockListDTO> getRecentBlocks();
}
