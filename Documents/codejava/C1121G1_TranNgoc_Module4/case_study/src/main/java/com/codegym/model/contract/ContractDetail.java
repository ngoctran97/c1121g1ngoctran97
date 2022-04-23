package com.codegym.model.contract;

import com.codegym.model.contract.AttachService;

import javax.persistence.*;
@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer contractDetailId;
    private Integer quatity;

    @ManyToOne
    @JoinColumn(name = "contract_id",referencedColumnName = "contractId")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "attach_service_id" , referencedColumnName = "attachServiceId")
    private AttachService attachService;


    public ContractDetail() {
    }


    public Integer getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Integer contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Integer getQuatity() {
        return quatity;
    }

    public void setQuatity(Integer quatity) {
        this.quatity = quatity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
