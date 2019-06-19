package io.ps.blockexplorer0614.controller;

import io.ps.blockexplorer0614.dto.TxGetDTO;
import io.ps.blockexplorer0614.dto.TxListDTO;
import io.ps.blockexplorer0614.service.TxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tx")
@CrossOrigin
@EnableAutoConfiguration
public class TxController {
    @Autowired
    private TxService txService;

    @GetMapping("/getRecentTxs")
    public List<TxListDTO> getRecentTxs(){
        List<TxListDTO> txListDTOS = txService.getRecentTxs();
        return txListDTOS;
    }
    @GetMapping("/getByTxhash")
    public TxGetDTO getByTxhash(@RequestParam String txhash){
        TxGetDTO txGetDTO = new TxGetDTO();
        return txGetDTO;
    }

}
