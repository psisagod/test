package io.ps.blockexplorer0614.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.ps.blockexplorer0614.api.BitcoinJsonRpcClientAPI;
import io.ps.blockexplorer0614.api.BitcoinRestAPI;
import io.ps.blockexplorer0614.dao.BlockMapper;
import io.ps.blockexplorer0614.dto.BlockGetDTO;
import io.ps.blockexplorer0614.dto.BlockListDTO;
import io.ps.blockexplorer0614.dto.TxListDTO;
import io.ps.blockexplorer0614.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
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
    @Autowired
    private BlockService blockService;
    @GetMapping("/getRecentBlocks")
    public List<BlockListDTO> getRecentBlocks() throws Throwable {
        List<BlockListDTO> recentBlocks = blockService.getRecentBlocks();
        return recentBlocks;
    }
    @GetMapping("/getblockbyheight")
    public BlockGetDTO getblockbyheight(@RequestParam(required = false)Integer blockheight) throws Throwable {
        String blockhashbyheight = bitcoinJsonRpcClientAPI.getBlockHashByHeight(blockheight);
        JSONObject jsonObject = bitcoinRestAPI.getBlock(blockhashbyheight);
        BlockGetDTO blockGetDTO = new BlockGetDTO();
        blockGetDTO.setNumber_of_transactions(jsonObject.getInteger("confirmations"));
        blockGetDTO.setDifficulty(jsonObject.getDouble("difficulty"));
        blockGetDTO.setBits(jsonObject.getString("bits"));
        blockGetDTO.setHash(blockhashbyheight);
        blockGetDTO.setHeight(blockheight);
        blockGetDTO.setNonce(jsonObject.getLong("nonce"));
        blockGetDTO.setPrevious_block(jsonObject.getString("previousblockhash"));
        blockGetDTO.setSize(jsonObject.getDouble("size"));
        //blockGetDTO.setTransaction_fees();
        blockGetDTO.setVersion(jsonObject.getString("versionHex"));
        blockGetDTO.setWeight(jsonObject.getDouble("weight"));
        //blockGetDTO.setBlock_reward();块奖励
        //blockGetDTO.setEstimated_transaction_volume();估计交易金额
        //blockGetDTO.setMerkle_root();根
        //blockGetDTO.setOutput_total();输出总量
        //blockGetDTO.setReceived_time();
        //blockGetDTO.setTimestamp();
        //blockGetDTO.setRelayed_by();
        return blockGetDTO;
    }
//    @GetMapping("/getblockbyheight")
//    public List<BlockGetDTO> getblockbyheight(@RequestParam(required = false)Integer blockheight,@RequestParam(required = false)String blockhash) throws Throwable {
//        String blockhashbyheight = bitcoinJsonRpcClientAPI.getBlockHashByHeight(blockheight);
//        List<BlockGetDTO> blockGetDTOS = blockService.getblockbyheight(blockheight);
//        return blockGetDTOS;
//    }

//    @GetMapping("/getBlockByBlockheight")
//    public BlockGetDTO getBlockByBlockheight(@RequestParam Integer Blockheight) throws Throwable {
//        BlockGetDTO blockGetDTO = new BlockGetDTO();
//        String blockhash = bitcoinJsonRpcClientAPI.getBlockHashByHeight(Blockheight);
//        JSONObject block = bitcoinRestAPI.getBlock(blockhash);
//        blockGetDTO.setBlockhash(blockhash);
//        blockGetDTO.setNumber_of_transactions(block.getInteger("confirmations"));
//        blockGetDTO.setSize(block.getInteger("size"));
//        blockGetDTO.setTime(block.getLong("time"));
//        blockGetDTO.setTxSize(block.getShort("nTx"));
//        blockGetDTO.setNextBlock(block.getString("nextblockhash"));
//        blockGetDTO.setPrevBlcok(block.getString("previousblockhash"));
//        return blockGetDTO;
//    }
//    @GetMapping("/getBlockByBlockhash")
//    public BlockGetDTO getBlockByBlockhash(@RequestParam String blockhash){
//        BlockGetDTO blockGetDTO = new BlockGetDTO();
//        JSONObject block = bitcoinRestAPI.getBlock(blockhash);
//        blockGetDTO.setBlockhash(blockhash);
//        blockGetDTO.setNumber_of_transactions(block.getInteger("confirmations"));
//        blockGetDTO.setSize(block.getInteger("size"));
//        blockGetDTO.setTime(block.getLong("time"));
//        blockGetDTO.setTxSize(block.getShort("nTx"));
//        blockGetDTO.setNextBlock(block.getString("nextblockhash"));
//        blockGetDTO.setPrevBlcok(block.getString("previousblockhash"));
//        return blockGetDTO;
//    }

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

    @GetMapping("/getBlock")
    public JSONObject getBlock(){
        return bitcoinRestAPI.getBlock("00000000000244b81e44414f7ca4b1961a900a628526a8a8c540ba6ce2738263");
    }
    @GetMapping("/getTransaction")
    public JSONObject getTransaction(){
        return bitcoinRestAPI.getTransaction("576eaa78b49a1c961086abb51e7cfd316703ed4ca05a7296a9ce2cb75106b7c5");
    }

    @GetMapping("/getNoTxBlock")
    public JSONObject getNoTxBlock(){
        return bitcoinRestAPI.getNoTxBlock("00000000000244b81e44414f7ca4b1961a900a628526a8a8c540ba6ce2738263");
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
