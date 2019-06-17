package io.ps.blockexplorer0614.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.ps.blockexplorer0614.api.BitcoinJsonRpcClientAPI;
import io.ps.blockexplorer0614.api.BitcoinRestAPI;
import io.ps.blockexplorer0614.dto.BlockGetDTO;
import io.ps.blockexplorer0614.dto.BlockListDTO;
import io.ps.blockexplorer0614.dto.TxListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/block")
@CrossOrigin
@EnableAutoConfiguration
public class BlockController {
    @Autowired
    private BitcoinRestAPI bitcoinRestAPI;
    @Autowired
    private BitcoinJsonRpcClientAPI bitcoinJsonRpcClientAPI;

    @GetMapping("/getRecentBlocks")
    public List<BlockListDTO> getRecentBlocks() throws Throwable {
        ArrayList<BlockListDTO> blockListDTOS = new ArrayList<>();

        JSONObject blockChainInfo = bitcoinRestAPI.getChainInfo();
        Integer blockHeight = blockChainInfo.getInteger("blocks");
        Integer blockFromHeight = blockHeight - 5;

        String blockhash = bitcoinJsonRpcClientAPI.getBlockHashByHeight(blockFromHeight);
        List<JSONObject> blockHeaders = bitcoinRestAPI.getBlockHeaders(5,blockhash);

        for(Object blockHeader : blockHeaders){
            JSONObject jsonObject = (JSONObject) blockHeader;
            BlockListDTO blockListDTO = new BlockListDTO();
            blockListDTO.setHeight(jsonObject.getInteger("height"));
            Long time = jsonObject.getLong("time");
            blockListDTO.setTime(new Date(1000*time));
            blockListDTO.setConfirmations(jsonObject.getInteger("confirmations"));
            blockListDTO.setBlockhash(jsonObject.getString("hash"));
            blockListDTO.setTxsize(jsonObject.getShort("nTx"));
            blockListDTO.setSize(null);
            blockListDTOS.add(blockListDTO);
        }
        return blockListDTOS;
    }
//    @GetMapping("/getRecentTransaction")
//    public List<TxListDTO> getRecentTransaction() throws Throwable {
//
//
//        return blockListDTOS;
//    }
    @GetMapping("/getBlock")
    public JSONObject getBlock(){
        return bitcoinRestAPI.getBlock("0000000024224c12fd9cc28e17b7eb5cd08645324e209ef48b95625d7aa260d9");
    }

    @GetMapping("/getTransaction")
    public JSONObject getTransaction(){
        return bitcoinRestAPI.getTransaction("576eaa78b49a1c961086abb51e7cfd316703ed4ca05a7296a9ce2cb75106b7c5");
    }
    @GetMapping("/getBlockByBlockheight")
    public BlockGetDTO getBlockByBlockheight(@RequestParam Integer Blockheight) throws Throwable {
        BlockGetDTO blockGetDTO = new BlockGetDTO();
        String blockhash = bitcoinJsonRpcClientAPI.getBlockHashByHeight(Blockheight);
        JSONObject block = bitcoinRestAPI.getBlock(blockhash);
        blockGetDTO.setBlockhash(blockhash);
        blockGetDTO.setNumber_of_transactions(block.getInteger("confirmations"));
        blockGetDTO.setSize(block.getInteger("size"));
        blockGetDTO.setTime(block.getLong("time"));
        blockGetDTO.setTxSize(block.getShort("nTx"));
        blockGetDTO.setNextBlock(block.getString("nextblockhash"));
        blockGetDTO.setPrevBlcok(block.getString("previousblockhash"));
        return blockGetDTO;
    }
    @GetMapping("/getBlockByBlockhash")
    public BlockGetDTO getBlockByBlockhash(@RequestParam String blockhash){
        BlockGetDTO blockGetDTO = new BlockGetDTO();
        JSONObject block = bitcoinRestAPI.getBlock(blockhash);
        blockGetDTO.setBlockhash(blockhash);
        blockGetDTO.setNumber_of_transactions(block.getInteger("confirmations"));
        blockGetDTO.setSize(block.getInteger("size"));
        blockGetDTO.setTime(block.getLong("time"));
        blockGetDTO.setTxSize(block.getShort("nTx"));
        blockGetDTO.setNextBlock(block.getString("nextblockhash"));
        blockGetDTO.setPrevBlcok(block.getString("previousblockhash"));
        return blockGetDTO;
    }

    //----------------------------------------------------------------------------------------
    @GetMapping("/getBestblockHash")
    public String getBestblockHash() throws Throwable {
        return bitcoinJsonRpcClientAPI.getBestblockHash();
    }

    @GetMapping("/getBlockHashByHeight")
    public String getBlockHashByHeight(Integer blockHeight) throws Throwable {
        return bitcoinJsonRpcClientAPI.getBlockHashByHeight(blockHeight);
    }

    @GetMapping("/getAddressInfo")
    public JSONObject getAddressInfo(String address) throws Throwable {
        return bitcoinJsonRpcClientAPI.getAddressInfo(address);
    }
    @GetMapping("/getBalance")
    public Double getBalance(String address) throws Throwable {
        return bitcoinJsonRpcClientAPI.getBalance(address);
    }

    @GetMapping("/getRawTransaxtion")
    public JSONObject getRawTransaxtion(String txid) throws Throwable {
        return bitcoinJsonRpcClientAPI.getRawTransaxtion(txid);
    }
    //--------------------------------------------------------------------------------------------
    @GetMapping("/getChainInfo")
    public JSONObject getChainInfo(){
        return bitcoinRestAPI.getChainInfo();
    }

    @GetMapping("/getNoTxBlock")
    public JSONObject getNoTxBlock(){
        return bitcoinRestAPI.getNoTxBlock("0000000024224c12fd9cc28e17b7eb5cd08645324e209ef48b95625d7aa260d9");
    }

    @GetMapping("/getBlockHeaders")
    public List<JSONObject> getBlockHeaders(){
        return bitcoinRestAPI.getBlockHeaders(5,"000000000a22be225c6e914b4b4f3b74fa421e8471bf2613500cde19e1c6d4fb");
    }

    @GetMapping("/getMempoolContents")
    public JSONObject getMempoolContents(){
        return bitcoinRestAPI.getMempoolContents();
    }

    @GetMapping("/getMempoolInfo")
    public JSONObject getMempoolInfo(){
        return bitcoinRestAPI.getMempoolInfo();
    }

    @GetMapping("/getUTXO")
    public JSONObject getUTXO(){
        return bitcoinRestAPI.getUTXO("c8ef72695507f4d946bb4193fa364f364dce98c8087443fe532516af92e0070a",5);
    }




//    @GetMapping("/getByHeight")
//    public BlockGetDTO getByHeight(@RequestParam Integer height){
//        BlockGetDTO blockGetDTO = new BlockGetDTO();
//        return blockGetDTO;
//    }

}
