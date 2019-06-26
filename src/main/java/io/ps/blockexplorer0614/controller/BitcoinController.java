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
    public String search(@RequestParam(required = false)String searchname) throws Throwable {

        if(searchname.length()==34){

        }else if(searchname.length()<7){
            try {
                int height = Integer.parseInt(searchname);
                BlockGetDTO blockGetDTOByHeight  = blockController.searchBlockByBlockHeight(height);
                if(blockGetDTOByHeight != null){
                    return "BlockDetail.html?searchname="+searchname;
                }else {
                    return "SearchError.html";
                }
            }catch (Exception e){
                return "SearchError.html";
            }

        }else if(searchname.length()==64){
            try {
                BlockGetDTO blockGetDTOByHash  = blockController.searchBlockByBlockHash(searchname);
                if(blockGetDTOByHash != null){
                    return "BlockDetail.html?searchname="+searchname;
                }else {
                    return "SearchError.html";
                }
            }
            catch (Exception e){
                //todo Custom Exception
            }
            TxGetDTO  txGetDTO = txController.searchTxByTxhash(searchname);
            if(txGetDTO != null){
                return "TxDetail.html?searchname="+searchname;
            }
        }else{
            return "SearchError.html";
        }
        return "SearchError.html";
    }


}
