##1.1 查看最新区块的基本信息

调用该API，可以获取新区块的基本信息

- **获取新区块的基本信息**

```json
url:/block/getRecentBlocks
method：GET
successResponse：
[
    {
        "height": 1404,
        "age": 3726322,
        "transactions": 1382043,
        "miner": "ps",
        "size": 207
    },
    {
        "height": 1403,
        "age": 3726322,
        "transactions": 1382047,
        "miner": "ps",
        "size": 207
    },
    ...
]

```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    height|   Double |  区块高度 |
|    age|   Integer |  区块时间 |
|    transactions|   Integer |  区块交易数量 |
|    miner|   String |  区块矿工 |
|    size|   String |  区块长度 |
  
  



##m.2 查看最新交易的基本信息

调用该API，可以查看最新交易的基本信息

- **查看最新交易的基本信息**

```json
url:/tx/getRecentTxs
method：GET

successResponse：
[
    {
        "transaction_hash": "9aa3a5a6d9b7d1ac9555be8e42596d06686cc5f76d259b06c560a207d310d5f5",
        "age": 3726335,
        "amount_eth": 50.0145,
        "amount_usd": 555711.1095
    },
    {
        "transaction_hash": "39ba7440b7103557560cc8ce258009936796485aaf8b478e66ab4cb97c66e31b",
        "age": 3726377,
        "amount_eth": 50.014,
        "amount_usd": 555705.554
    },
    ...
]

```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    transaction_hash|   String |  交易哈希 |
|    age|   Integer |  交易时间 |
|    amount_eth|   Double |  交易总额（比特币）|
|    amount_usd|   Double |  交易总额（美元）|

##m.3 根据区块高度查询区块的详细信息

调用该API，可以根据区块高度查询区块的详细信息

- **查询区块的详细信息**

```json
url:/block/searchBlockByBlockHeight=={blockheight}
method：GET
successResponse：
{
	"number_of_transactions": 1382659,
    "output_total": 8569.05120796,
    "estimated_transaction_volume": 843.55736314,
    "transaction_fees": 1.11142259,
    "height": 136,
    "timestamp": 2019-06-26 10:44:58,
    "received_time": 2019-06-26 10:44:58,
    "relayed_by": "AntPool",
    "difficulty": 1,
    "bits": "1d00ffff",
    "size": 190,
    "weight": 760,
    "version": "00000001",
    "nonce": 63771653,
    "block_reward": 12.5,
    "hash": "000000001888bb2530e2764011c77df3208f1030aa8312d8d60c92188475167d",
    "previous_block": "00000000b23e86dc9781b46e60204ec0b71f1300038953131fad081df536a929",
    "merkle_root": "e0734fbdfbc73940151f38389d4b16a4da35bb88b3d1cc39578ae678526db4c6"
}

```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    number_of_transactions|   Integer |  交易数量 |
|    output_total|   Double |  输出总计 |
|    estimated_transaction_volume|   Double |  预计交易量 |
|    transaction_fees|   Double |  交易费用 |
|    height|   Integer |  高度 |
|    timestamp|   Date |  时间戳 |
|    received_time|   Date |  收到时间 |
|    relayed_by|   String |  继续 |
|    difficulty|   Double |  难度系数 |
|    bits|   String |  位 |
|    size|   Double |  长度 |
|    weight|   Double |  负重 |
|    version|   String |  版本 |
|    nonce|   Long |  交易时间 |
|    block_reward|   Double |  出块奖励 |
|    hash|   String |  区块哈希 |
|    previous_block|   String |  下一块哈希 |
|    merkle_root|   String |  上一块哈希 |

##m.4 根据区块哈希查询区块的详细信息

调用该API，可以根据区块哈希查询区块的详细信息

- **查询区块的详细信息**

```json
url:/block/searchBlockByBlockHash=={blockhash}
method：GET
successResponse：
{
    "number_of_transactions": 1382659,
    "output_total": 8569.05120796,
    "estimated_transaction_volume": 843.55736314,
    "transaction_fees": 1.11142259,
    "height": 136,
    "timestamp": 2019-06-26 10:44:58,
    "received_time": 2019-06-26 10:44:58,
    "relayed_by": "AntPool",
    "difficulty": 1,
    "bits": "1d00ffff",
    "size": 190,
    "weight": 760,
    "version": "00000001",
    "nonce": 63771653,
    "block_reward": 12.5,
    "hash": "000000001888bb2530e2764011c77df3208f1030aa8312d8d60c92188475167d",
    "previous_block": "00000000b23e86dc9781b46e60204ec0b71f1300038953131fad081df536a929",
    "merkle_root": "e0734fbdfbc73940151f38389d4b16a4da35bb88b3d1cc39578ae678526db4c6"
}
```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    number_of_transactions|   Integer |  交易数量 |
|    output_total|   Double |  输出总计 |
|    estimated_transaction_volume|   Double |  预计交易量 |
|    transaction_fees|   Double |  交易费用 |
|    height|   Integer |  高度 |
|    timestamp|   Date |  时间戳 |
|    received_time|   Date |  收到时间 |
|    relayed_by|   String |  继续 |
|    difficulty|   Double |  难度系数 |
|    bits|   String |  位 |
|    size|   Double |  长度 |
|    weight|   Double |  负重 |
|    version|   String |  版本 |
|    nonce|   Long |  交易时间 |
|    block_reward|   Double |  出块奖励 |
|    hash|   String |  区块哈希 |
|    previous_block|   String |  下一块哈希 |
|    merkle_root|   String |  上一块哈希 |

##m.5 根据交易哈希查询交易的详细信息

调用该API，可以根据交易哈希查询交易的详细信息

- **查询交易的详细信息**

```json
url:/tx/searchTxByTxhash=={txhash}
method：GET
successResponse：
{
   "txhash": "6801cb417573220564c3cec34dd39a0879e24ea75a7ca1ba6a3b8c11c1c6c6b3",
    "size": 109,
    "weight": 436,
    "received_time": 2019-06-26 11:16:52,
    "lock_time": 2019-06-26 11:16:52,
    "visualize": "View Tree Chart",
    "total_input": 0.02574346,
    "total_output": 0.02488312,
    "fees": 0.00086034,
    "fee_per_byte": 105.823,
    "fee_per_weight_unit": 26.456,
    "estimated_btc_transacted": 0.01971
}
```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    txhash|   String |  交易哈希 |
|    size|   Double |  长度 |
|    weight|   Double |  负重 |
|    received_time|   Date |  收到时间 |
|    lock_time|   Date |  锁定时间 |
|    visualize|   String |  时间戳 |
|    total_input|   Double |  总收入 |
|    total_output|   Double |  总输出 |
|    fees|   Double |  费用 |
|    fee_per_byte|   Double |  没字节费用 |
|    fee_per_weight_unit|   Double |  每单位费用 |
|    estimated_btc_transacted|   Double |  估计btc交易 |

##m.5 根据地址查询余额的详细信息

调用该API，可以根据地址查询余额的详细信息

- **查询余额的详细信息**

```json
url:/bitcoin/searchBalanceByAddress=={address}
method：GET
successResponse：
{
   "address": "38zLzxKPNcDBNm5CFhwpBDKXqKiLPU6Jp9",
    "hash": "500fe02f3147cea4b2e6a4727d4d0596280825ef",
    "no_transactions": 25,
    "total_received": 0.03468382,
    "final_balance": 0.00188254
}
```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    address|   String |  交易地址 |
|    hash|   String |  哈希 |
|    no_transactions|   Integer |  交易序号 |
|    total_received|   Double |  总收入 |
|    final_balance|   Double |  最总结余 |

##m.6 查看更多区块的基本信息

调用该API，可以查看更多区块的基本信息

- **查看更多区块的基本信息**

```json
url:/block/getMoreBlocks
method：GET
successResponse：
[
    {
        "height": 1404,
        "age": 3726401,
        "transactions": 1382043,
        "miner": "ps",
        "size": 207
    },
    {
        "height": 1403,
        "age": 3726401,
        "transactions": 1382047,
        "miner": "ps",
        "size": 207
    },
    ...
]
```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    height|   Double |  区块高度 |
|    age|   Integer |  区块时间 |
|    transactions|   Integer |  区块交易数量 |
|    miner|   String |  区块矿工 |
|    size|   String |  区块长度 |

##m.7 查看更多交易的基本信息

调用该API，可以查看更多交易的基本信息

- **查看更多交易的基本信息**

```json
url:/tx/getMoreTxs
method：GET

successResponse：
[
    {
        "transaction_hash": "9aa3a5a6d9b7d1ac9555be8e42596d06686cc5f76d259b06c560a207d310d5f5",
        "age": 3726335,
        "amount_eth": 50.0145,
        "amount_usd": 555711.1095
    },
    {
        "transaction_hash": "39ba7440b7103557560cc8ce258009936796485aaf8b478e66ab4cb97c66e31b",
        "age": 3726377,
        "amount_eth": 50.014,
        "amount_usd": 555705.554
    },
    ...
]

```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    transaction_hash|   String |  交易哈希 |
|    age|   Integer |  交易时间 |
|    amount_eth|   Double |  交易总额（比特币）|
|    amount_usd|   Double |  交易总额（美元）|