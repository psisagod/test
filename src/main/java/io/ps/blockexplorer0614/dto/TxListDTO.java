package io.ps.blockexplorer0614.dto;

public class TxListDTO {
    private String blockhash;
    private Integer height;
    private String prevBlcok;
    private String nextBlock;
    private String merkleRoot;
    private Short txSize;
    private Double outputTotal;
    private Double fees;
    private Long time;
    private Double difficulty;
    private Integer size;

    public String getBlockhash() {
        return blockhash;
    }

    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getPrevBlcok() {
        return prevBlcok;
    }

    public void setPrevBlcok(String prevBlcok) {
        this.prevBlcok = prevBlcok;
    }

    public String getNextBlock() {
        return nextBlock;
    }

    public void setNextBlock(String nextBlock) {
        this.nextBlock = nextBlock;
    }

    public String getMerkleRoot() {
        return merkleRoot;
    }

    public void setMerkleRoot(String merkleRoot) {
        this.merkleRoot = merkleRoot;
    }

    public Short getTxSize() {
        return txSize;
    }

    public void setTxSize(Short txSize) {
        this.txSize = txSize;
    }

    public Double getOutputTotal() {
        return outputTotal;
    }

    public void setOutputTotal(Double outputTotal) {
        this.outputTotal = outputTotal;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Double difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
