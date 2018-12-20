package com.wu.pojo;

public class PingTai {
    private Integer valueId;
    private String valueName;

    public PingTai() {
    }

    public PingTai(Integer valueId, String valueName) {
        this.valueId = valueId;
        this.valueName = valueName;
    }

    public Integer getValueId() {
        return valueId;
    }

    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    @Override
    public String toString() {
        return "PingTai{" +
                "valueId=" + valueId +
                ", valueName='" + valueName + '\'' +
                '}';
    }
}
