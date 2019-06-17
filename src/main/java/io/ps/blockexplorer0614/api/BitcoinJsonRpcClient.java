package io.ps.blockexplorer0614.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;

@Service
public class BitcoinJsonRpcClient implements BitcoinJsonRpcClientAPI{
    private JsonRpcHttpClient jsonRpcHttpClient;

    public BitcoinJsonRpcClient() throws MalformedURLException {
        HashMap<String, String> headers = new HashMap<>();
        String authStrOrig = String.format("%s:%s","cjf","123456");
        String authStr = Base64.getEncoder().encodeToString(authStrOrig.getBytes());
        String authStrResult = String.format("Basic %s",authStr);
        headers.put("Authorization",authStrResult);
        jsonRpcHttpClient = new JsonRpcHttpClient(new URL("http://localhost:18332"),headers);
    }


    public String getBestblockHash() throws Throwable {
        String blockhash = jsonRpcHttpClient.invoke("getbestblockhash",null, String.class);
        return blockhash;
    }

    public String getBlockHashByHeight(Integer blockHeight)  throws Throwable {
        String blockhash = jsonRpcHttpClient.invoke("getblockhash", new Integer[]{blockHeight}, String.class);
        return blockhash;
    }

    public JSONObject getAddressInfo(String address) throws Throwable {
        JSONObject blockhash = jsonRpcHttpClient.invoke("getaddressinfo", new String[]{address}, JSONObject.class);
        return blockhash;
    }

    public Double getBalance(String address) throws Throwable {
        JSONArray balances = jsonRpcHttpClient.invoke("listunspent", new Object[]{6, 9999999}, JSONArray.class);
        JSONObject balance = balances.getJSONObject(1);
        Double amount = balance.getDouble("amount");
        return amount;
    }

    public JSONObject getRawTransaxtion(String txid) throws Throwable {
        JSONObject rawTransaction = jsonRpcHttpClient.invoke("getrawtransaction", new Object[]{txid, true}, JSONObject.class);
        return rawTransaction;
    }
}
