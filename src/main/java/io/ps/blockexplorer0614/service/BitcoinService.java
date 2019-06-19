package io.ps.blockexplorer0614.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.ps.blockexplorer0614.dto.BlockListDTO;

import java.util.Date;
import java.util.List;

public interface BitcoinService {

    void syncBlock(String blockhash) throws Throwable;

    void syncTx(JSONObject txJson, String blockhash, Date time, Integer confirmations) throws Throwable;

    void syncTxDetail(JSONObject txJson) throws Throwable;

    void syncTxDetailVout(JSONArray vouts,String txhash);

    void syncTxDetailVin(JSONArray vins,String txhash) throws Throwable;
}
