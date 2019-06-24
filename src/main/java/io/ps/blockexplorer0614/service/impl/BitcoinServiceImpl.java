package io.ps.blockexplorer0614.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.ps.blockexplorer0614.api.BitcoinJsonRpcClientAPI;
import io.ps.blockexplorer0614.api.BitcoinRestAPI;
import io.ps.blockexplorer0614.dao.BlockMapper;

import io.ps.blockexplorer0614.dao.TransacationMapper;
import io.ps.blockexplorer0614.dao.Tx_detallMapper;
import io.ps.blockexplorer0614.enumeration.TxDerailType;
import io.ps.blockexplorer0614.po.Block;
import io.ps.blockexplorer0614.po.Transacation;
import io.ps.blockexplorer0614.po.Tx_detall;
import io.ps.blockexplorer0614.service.BitcoinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class BitcoinServiceImpl implements BitcoinService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BitcoinRestAPI bitcoinRestApi;

    @Autowired
    private BlockMapper blockMapper;

    @Autowired
    private TransacationMapper transacationMapper;

    @Autowired
    private Tx_detallMapper tx_detallMapper;

    @Autowired
    private BitcoinJsonRpcClientAPI bitcoinJsonRpcClientAPI;
    private Double voutAmount = 0.0;
    private Double vinAmount = 0.0;

    @Async
    @Override
    public void syncBlock(String blockhash) throws Throwable {
        logger.info("begin to sync block from {}", blockhash);
        String tempBlockhash = blockhash;
        while (tempBlockhash != null && !tempBlockhash.isEmpty()){
            JSONObject blockJson = bitcoinRestApi.getBlock(tempBlockhash);
            Block block = new Block();
            block.setBlockhash(blockJson.getString("hash"));
            block.setHeight(blockJson.getInteger("height"));
            if(blockJson.getInteger("height")>1404){
                break;
            }
            Long time = blockJson.getLong("time");
            block.setTime(new Date(time * 1000));
            block.setTxsize(blockJson.getShort("nTx"));
            block.setSize(blockJson.getInteger("size"));
            block.setWeight(blockJson.getFloat("weight"));
            block.setDifficulty(blockJson.getDouble("difficulty"));
            block.setPrevBlock(blockJson.getString("previousblockhash"));
            block.setNextBlock(blockJson.getString("nextblockhash"));
            Integer confirmations = blockJson.getInteger("confirmations");
            blockMapper.insert(block);
            JSONArray txesArray = blockJson.getJSONArray("tx");

            for (Object txObj : txesArray) {
                JSONObject jsonObject = new JSONObject((LinkedHashMap) txObj);
                syncTx(jsonObject, tempBlockhash, new Date(time * 1000), confirmations);
            }
            tempBlockhash = block.getNextBlock();
        }
        logger.info("end sync block");
    }
    @Async
    @Override
    public void syncTx(JSONObject txJson, String blockhash, Date time, Integer confirmations) throws Throwable {
        Transacation tx = new Transacation();
        tx.setTxhash(txJson.getString("txid"));
        tx.setBlockhash(blockhash);
        tx.setTime(time);
        tx.setSize(txJson.getInteger("size"));
        tx.setWeight(txJson.getFloat("weight"));
        tx.setConfirmations(confirmations);
        Double amout = voutAmount + vinAmount;
        tx.setAmout(amout);
        transacationMapper.insert(tx);
        syncTxDetail(txJson);

        //todo set tx amount
    }
    @Async
    @Override
    public void syncTxDetail(JSONObject txJson) throws Throwable {
        String txhash = txJson.getString("hash");
        JSONArray vouts = txJson.getJSONArray("vout");
        syncTxDetailVout(vouts,txhash);
        JSONArray vins = txJson.getJSONArray("vin");
        syncTxDetailVin(vins,txhash);
        //todo set tx amount
    }
    @Async
    @Override
    public void syncTxDetailVout(JSONArray vouts,String txhash) {
        Tx_detall tx_detall = new Tx_detall();
        tx_detall.setTxhash(txhash);
        for (Object vout : vouts) {
            JSONObject jsonObject = new JSONObject((LinkedHashMap) vout);
            JSONObject scriptPubKey =jsonObject.getJSONObject("scriptPubKey");
            Double amount = jsonObject.getDouble("value");
            voutAmount = amount;
            tx_detall.setAmount(amount);
            String addresses = scriptPubKey.getString("addresses");
            tx_detall.setAdress(addresses);
            tx_detall.setType((byte) TxDerailType.Receive.ordinal());
        }
        tx_detallMapper.insert(tx_detall);
    }
    @Async
    @Override
    public void syncTxDetailVin(JSONArray vins,String txhashOrigin) throws Throwable {
//        Tx_detall tx_detall = new Tx_detall();
//        for (Object vin : vins) {
//            JSONObject jsonObject = new JSONObject((LinkedHashMap) vin);
//             Integer vout = jsonObject.getInteger("vout");
//            JSONObject rawTransaxtion = bitcoinJsonRpcClientAPI.getRawTransaxtion(txhashOrigin);
//            JSONArray vouts = rawTransaxtion.getJSONArray("vout");
//            JSONObject jsonVout = vouts.getJSONObject(vout);
//            tx_detall.setTxhash(txhashOrigin);
//            tx_detall.setType((byte) TxDerailType.Send.ordinal());
//            Double amount = jsonObject.getDouble("value");
//            vinAmount = amount;
//        }
//        tx_detallMapper.insert(tx_detall);
    }


}
