package io.ps.blockexplorer0614.dto;

public class TxGetDTO {

    private Short size;
    private Integer weight;
    private Long received_time;
    private Long lock_time;
    private String visualize;
    private Double total_input;
    private Double total_output;
    private Double fees;
    private Double fee_per_byte;
    private Double fee_per_weight_unit;
    private Double estimated_btc_transacted;


    public Short getSize() {
        return size;
    }

    public void setSize(Short size) {
        this.size = size;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Long getReceived_time() {
        return received_time;
    }

    public void setReceived_time(Long received_time) {
        this.received_time = received_time;
    }

    public Long getLock_time() {
        return lock_time;
    }

    public void setLock_time(Long lock_time) {
        this.lock_time = lock_time;
    }

    public String getVisualize() {
        return visualize;
    }

    public void setVisualize(String visualize) {
        this.visualize = visualize;
    }

    public Double getTotal_input() {
        return total_input;
    }

    public void setTotal_input(Double total_input) {
        this.total_input = total_input;
    }

    public Double getTotal_output() {
        return total_output;
    }

    public void setTotal_output(Double total_output) {
        this.total_output = total_output;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    public Double getFee_per_byte() {
        return fee_per_byte;
    }

    public void setFee_per_byte(Double fee_per_byte) {
        this.fee_per_byte = fee_per_byte;
    }

    public Double getFee_per_weight_unit() {
        return fee_per_weight_unit;
    }

    public void setFee_per_weight_unit(Double fee_per_weight_unit) {
        this.fee_per_weight_unit = fee_per_weight_unit;
    }

    public Double getEstimated_btc_transacted() {
        return estimated_btc_transacted;
    }

    public void setEstimated_btc_transacted(Double estimated_btc_transacted) {
        this.estimated_btc_transacted = estimated_btc_transacted;
    }


}
