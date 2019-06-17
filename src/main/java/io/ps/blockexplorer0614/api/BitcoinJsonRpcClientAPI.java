package io.ps.blockexplorer0614.api;

import com.alibaba.fastjson.JSONObject;

public interface BitcoinJsonRpcClientAPI {

    Double getBalance(String address) throws Throwable;

    JSONObject getAddressInfo(String address) throws Throwable;

    String getBlockHashByHeight(Integer blockHeight) throws Throwable;

    String getBestblockHash() throws Throwable;

    JSONObject getRawTransaxtion(String txid) throws Throwable;
}
