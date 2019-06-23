package io.ps.blockexplorer0614.dto;

public class TxListDTO {
    private String transaction_hash;
    private Integer age;
    private Double amount_eth;
    private Double amount_usd;

    public String getTransaction_hash() {
        return transaction_hash;
    }

    public void setTransaction_hash(String transaction_hash) {
        this.transaction_hash = transaction_hash;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getAmount_eth() {
        return amount_eth;
    }

    public void setAmount_eth(Double amount_eth) {
        this.amount_eth = amount_eth;
    }

    public Double getAmount_usd() {
        return amount_usd;
    }

    public void setAmount_usd(Double amount_usd) {
        this.amount_usd = amount_usd;
    }

    @Override
    public String toString() {
        return "TxListDTO{" +
                "transaction_hash='" + transaction_hash + '\'' +
                ", age=" + age +
                ", amount_eth=" + amount_eth +
                ", amount_usd=" + amount_usd +
                '}';
    }
}
