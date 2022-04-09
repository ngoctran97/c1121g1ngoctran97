package com.codedym.model;

import javax.persistence.*;
@Entity
public class Saving {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer savingId;
    private String timeToStart;
    private String term;
    private Integer deposits;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private Customer customer;

    public Integer getSavingId() {
        return savingId;
    }

    public void setSavingId(Integer savingId) {
        this.savingId = savingId;
    }

    public String getTimeToStart() {
        return timeToStart;
    }

    public void setTimeToStart(String timeToStart) {
        this.timeToStart = timeToStart;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Integer getDeposits() {
        return deposits;
    }

    public void setDeposits(Integer deposits) {
        this.deposits = deposits;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

//    public Integer getCustomerName() {
//        if(customer != NULL)
//        return customer.getCustomerId();
//    }
}
