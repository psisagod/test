package io.ps.blockexplorer0614.controller;

import com.alibaba.fastjson.JSONObject;
import io.ps.blockexplorer0614.api.BitcoinRestAPI;
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
    @Autowired
    private BitcoinRestAPI bitcoinRestAPI;
    @GetMapping("/getRecentTxs")
    public List<TxListDTO> getRecentTxs(){
        List<TxListDTO> txListDTOS = txService.getRecentTxs();
        return txListDTOS;
    }
    @GetMapping("/searchTx")
    public TxGetDTO searchTx(@RequestParam String txhash){
        TxGetDTO txGetDTO = new TxGetDTO();
        JSONObject jsonObject = bitcoinRestAPI.getTransaction(txhash);
        txGetDTO.setSize(jsonObject.getDouble("size"));
        txGetDTO.setWeight(jsonObject.getDouble("weight"));
        //txGetDTO.setReceived_time();
        txGetDTO.setLock_time(jsonObject.getLong("locktime"));
        //txGetDTO.setVisualize();
//
//
// txGetDTO.setTotal_input();
//        txGetDTO.setTotal_output();
//        txGetDTO.setFees();
//        txGetDTO.setFee_per_byte();
//        txGetDTO.setFee_per_weight_unit();
//        txGetDTO.setEstimated_btc_transacted();
        return txGetDTO;
    }

}
