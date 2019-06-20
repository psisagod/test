package io.ps.blockexplorer0614.controller;

import io.ps.blockexplorer0614.dto.BlockGetDTO;
import io.ps.blockexplorer0614.dto.TxGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bitcoin")
@CrossOrigin
@EnableAutoConfiguration
public class BitcoinController {
    @Autowired
    private TxController txController;
    @Autowired
    private BlockController blockController;
    @GetMapping("/search")
    public Object search(@RequestParam(required = false)String searchBlock) throws Throwable {

        if(searchBlock.length()==34){

        }
        if(searchBlock.length()<7){
            BlockGetDTO blockGetDTOByHeight  = blockController.searchBlockByBlockHeight(Integer.parseInt(searchBlock));
            if(blockGetDTOByHeight != null){
                return blockGetDTOByHeight;
            }
        }
        if(searchBlock.length()==64){
            try {
                BlockGetDTO blockGetDTOByHash  = blockController.searchBlockByBlockHash(searchBlock);
                if(blockGetDTOByHash != null){
                    return blockGetDTOByHash;
                }
            }
            catch (Exception e){
                System.out.println(e.getStackTrace());
            }

            TxGetDTO  txGetDTO = txController.searchTx(searchBlock);
            if(txGetDTO != null){
                return txGetDTO;
            }
        }
        return null;
    }


}
