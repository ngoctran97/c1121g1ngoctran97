package com.codegym.model;

public class Mailbox {
    private int id;
    private String mailAddress;
    private String langueges;
    private int pageSize;
    private boolean spamrfilter;
    private String singnatune;

    public Mailbox(int id, String mailAddress, String langueges, int pageSize, boolean spamrfilter, String singnatune) {
        this.id = id;
        this.mailAddress = mailAddress;
        this.langueges = langueges;
        this.pageSize = pageSize;
        this.spamrfilter = spamrfilter;
        this.singnatune = singnatune;
    }

    public Mailbox() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getLangueges() {
        return langueges;
    }

    public void setLangueges(String langueges) {
        this.langueges = langueges;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpamrfilter() {
        return spamrfilter;
    }

    public void setSpamrfilter(boolean spamrfilter) {
        this.spamrfilter = spamrfilter;
    }

    public String getSingnatune() {
        return singnatune;
    }

    public void setSingnatune(String singnatune) {
        this.singnatune = singnatune;
    }

}