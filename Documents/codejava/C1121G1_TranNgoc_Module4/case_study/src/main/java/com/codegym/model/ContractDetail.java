package com.codegym.model;

public class ContractDetail {
    private Integer contractDetailId;
    private Integer contractId;
    private Integer contractServiceId;
    private Integer quatity;

    public ContractDetail() {
    }

    public Integer getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Integer contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Integer getContractServiceId() {
        return contractServiceId;
    }

    public void setContractServiceId(Integer contractServiceId) {
        this.contractServiceId = contractServiceId;
    }

    public Integer getQuatity() {
        return quatity;
    }

    public void setQuatity(Integer quatity) {
        this.quatity = quatity;
    }
}
