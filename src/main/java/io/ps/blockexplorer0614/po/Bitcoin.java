package io.ps.blockexplorer0614.po;

public class Bitcoin {
    private Integer bitcoinId;

    private String name;

    private String shortname;

    private String type;

    public Integer getBitcoinId() {
        return bitcoinId;
    }

    public void setBitcoinId(Integer bitcoinId) {
        this.bitcoinId = bitcoinId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname == null ? null : shortname.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}