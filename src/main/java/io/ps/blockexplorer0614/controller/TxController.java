package io.ps.blockexplorer0614.controller;

import io.ps.blockexplorer0614.dto.TxGetDTO;
import io.ps.blockexplorer0614.dto.TxListDTO;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tx")
@CrossOrigin
@EnableAutoConfiguration
public class TxController {

    @GetMapping("getRecentTx")
    public List<TxListDTO> getRecentTx(){
        ArrayList<TxListDTO> txListDTOS = new ArrayList<>(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         );
        return txListDTOS;
    }
    @GetMapping("/getByTxhash")
    public TxGetDTO getByTxhash(@RequestParam String txhash){
        TxGetDTO txGetDTO = new TxGetDTO();
        return txGetDTO;
    }

}
