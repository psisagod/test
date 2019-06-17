## 1 获取当前最新交易

method：GET  
url: /tx/getRecentTx

response:
```json
{
    "size": 250,
    "weight": 670,
    "received_time": "2019-06-15 02:05:17",
    "lock_time": "Block: 580778",
    "visualize": "View Tree Chart",
    "total Input": 14.1924839,
    "total Output": 14.1921395,
    "fees": 0.0003444,
    "fee_per_byte": 137.76,
    "fee_per_weight_unit": 51.403,
    "estimated_btc_transacted": 0.60421504
}
```
| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    Size|   Short |  交易长度 |
|    Weight|   Integer |  交易负重 |
|    Received Time|   Date | 交易时间 |
|    Lock Time|   String |  块高度 |
|    Visualize|   String |  梅尔克树 |
|    Total Input|   Double |  头输入 |
|    Total Output|   Double |  头输出 |
|    Fees|   Double |  交易费用 |
|    Fee per byte|   Double |  费每字节 |
|    Fee per weight unit|   Double |  每磅收费 |
|    Estimated BTC Transacted|   Double |  估计BTC交易 |

## 2 根据交易哈希获取交易详情

method：GET  
url: /tx/getByTxhash?txhash={txhash}

response:
```json
{
    "size": 250,
    "weight": 670,
    "received_time": "2019-06-15 02:05:17",
    "lock_time": "Block: 580778",
    "visualize": "View Tree Chart",
    "total Input": 14.1924839,
    "total Output": 14.1921395,
    "fees": 0.0003444,
    "fee_per_byte": 137.76,
    "fee_per_weight_unit": 51.403,
    "estimated_btc_transacted": 0.60421504
}
```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    Size|   Short |  交易长度 |
|    Weight|   Integer |  交易负重 |
|    Received Time|   Date | 交易时间 |
|    Lock Time|   String |  块高度 |
|    Visualize|   String |  梅尔克树 |
|    Total Input|   Double |  头输入 |
|    Total Output|   Double |  头输出 |
|    Fees|   Double |  交易费用 |
|    Fee per byte|   Double |  费每字节 |
|    Fee per weight unit|   Double |  每磅收费 |
|    Estimated BTC Transacted|   Double |  估计BTC交易 |



    



