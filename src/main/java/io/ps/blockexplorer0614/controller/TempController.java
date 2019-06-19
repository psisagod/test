package io.ps.blockexplorer0614.controller;

import io.ps.blockexplorer0614.api.BitcoinJsonRpcClientAPI;
import io.ps.blockexplorer0614.api.BitcoinRestAPI;
import io.ps.blockexplorer0614.dao.BlockMapper;
import io.ps.blockexplorer0614.service.BitcoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temp")
@EnableAutoConfiguration
public class TempController {

    @Autowired
    private BitcoinRestAPI bitcoinRestApi;

    @Autowired
    private BitcoinJsonRpcClientAPI bitcoinJsonRpcApi;

    @Autowired
    private BlockMapper blockMapper;

    @Autowired
    private BitcoinService bitcoinService;


    @GetMapping("/test")
    public String test() throws Throwable {
        String tempBlockhash = "000000000933ea01ad0ee984209779baaec3ced90fa3f408719526f8d77f4943";
        bitcoinService.syncBlock(tempBlockhash);
        return null;
    }
}