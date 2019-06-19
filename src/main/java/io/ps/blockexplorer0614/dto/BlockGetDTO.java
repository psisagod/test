package io.ps.blockexplorer0614.dto;

import java.util.Date;

public class BlockGetDTO {
    //Summary
    private Integer number_of_transactions;
    private Double output_total;
    private Double estimated_transaction_volume;
    private Double transaction_fees;
    private Integer height;
    private Date timestamp;
    private Date received_time;
    private String relayed_by;
    private Double difficulty;
    private String bits;
    private Double size;
    private Double weight;
    private String version;
    private Long nonce;
    private Double block_reward;
    //Hashes
    private String hash;
    private String previous_block;
    private String merkle_root;

    public Integer getNumber_of_transactions() {
        return number_of_transactions;
    }

    public void setNumber_of_transactions(Integer number_of_transactions) {
        this.number_of_transactions = number_of_transactions;
    }

    public Double getOutput_total() {
        return output_total;
    }

    public void setOutput_total(Double output_total) {
        this.output_total = output_total;
    }

    public Double getEstimated_transaction_volume() {
        return estimated_transaction_volume;
    }

    public void setEstimated_transaction_volume(Double estimated_transaction_volume) {
        this.estimated_transaction_volume = estimated_transaction_volume;
    }

    public Double getTransaction_fees() {
        return transaction_fees;
    }

    public void setTransaction_fees(Double transaction_fees) {
        this.transaction_fees = transaction_fees;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Date getReceived_time() {
        return received_time;
    }

    public void setReceived_time(Date received_time) {
        this.received_time = received_time;
    }

    public String getRelayed_by() {
        return relayed_by;
    }

    public void setRelayed_by(String relayed_by) {
        this.relayed_by = relayed_by;
    }

    public Double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Double difficulty) {
        this.difficulty = difficulty;
    }

    public String getBits() {
        return bits;
    }

    public void setBits(String bits) {
        this.bits = bits;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Long getNonce() {
        return nonce;
    }

    public void setNonce(Long nonce) {
        this.nonce = nonce;
    }

    public Double getBlock_reward() {
        return block_reward;
    }

    public void setBlock_reward(Double block_reward) {
        this.block_reward = block_reward;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPrevious_block() {
        return previous_block;
    }

    public void setPrevious_block(String previous_block) {
        this.previous_block = previous_block;
    }

    public String getMerkle_root() {
        return merkle_root;
    }

    public void setMerkle_root(String merkle_root) {
        this.merkle_root = merkle_root;
    }
}
