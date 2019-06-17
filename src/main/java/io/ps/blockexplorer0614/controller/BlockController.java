package io.ps.blockexplorer0614.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.ps.blockexplorer0614.api.BlockExplorerAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/block")
@CrossOrigin
@EnableAutoConfiguration
public class BlockController {
    @Autowired
    private BlockExplorerAPI blockExplorerAPI;
    //
    @GetMapping("/getChainInfo")
    public JSONObject getChainInfo(){
        return blockExplorerAPI.getChainInfo();
    }

    @GetMapping("/getTransaction")
    public JSONObject getTransaction(){
        return blockExplorerAPI.getTransaction("576eaa78b49a1c961086abb51e7cfd316703ed4ca05a7296a9ce2cb75106b7c5");
    }

    @GetMapping("/getBlock")
    public JSONObject getBlock(){
        return blockExplorerAPI.getBlock("0000000024224c12fd9cc28e17b7eb5cd08645324e209ef48b95625d7aa260d9");
    }

    @GetMapping("/getNoTxBlock")
    public JSONObject getNoTxBlock(){
        return blockExplorerAPI.getNoTxBlock("0000000024224c12fd9cc28e17b7eb5cd08645324e209ef48b95625d7aa260d9");
    }

    @GetMapping("/getBlockHeaders")
    public JSONArray getBlockHeaders(){
        return blockExplorerAPI.getBlockHeaders(5,"000000000a22be225c6e914b4b4f3b74fa421e8471bf2613500cde19e1c6d4fb");
    }

    @GetMapping("/getMempoolContents")
    public JSONObject getMempoolContents(){
        return blockExplorerAPI.getMempoolContents();
    }

    @GetMapping("/getMempoolInfo")
    public JSONObject getMempoolInfo(){
        return blockExplorerAPI.getMempoolInfo();
    }

    @GetMapping("/getUTXO")
    public JSONObject getUTXO(){
        return blockExplorerAPI.getUTXO("c8ef72695507f4d946bb4193fa364f364dce98c8087443fe532516af92e0070a",5);
    }


//    @GetMapping("/getRecentBlocks")
//    public List<BlockListDTO> getRecentBlocks(){
//        ArrayList<BlockListDTO> blockListDTOS = new ArrayList<>();
//        return blockListDTOS;
//    }
//    @GetMapping("/getByBlockhash")
//    public BlockGetDTO getByBlockhash(@RequestParam String blockhash){
//        BlockGetDTO blockGetDTO = new BlockGetDTO();
//        return blockGetDTO;
//    }
//    @GetMapping("/getByHeight")
//    public BlockGetDTO getByHeight(@RequestParam Integer height){
//        BlockGetDTO blockGetDTO = new BlockGetDTO();
//        return blockGetDTO;
//    }

}
