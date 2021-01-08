package com.dk.domain;

public class Phone {

    private Integer pid;
    private String pname;
    private Integer ptype;
    private Double pprice;
    private Integer pcolor;
    private String pdate;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getPtype() {
        return ptype;
    }

    public void setPtype(Integer ptype) {
        this.ptype = ptype;
    }

    public Double getPprice() {
        return pprice;
    }

    public void setPprice(Double pprice) {
        this.pprice = pprice;
    }

    public Integer getPcolor() {
        return pcolor;
    }

    public void setPcolor(Integer pcolor) {
        this.pcolor = pcolor;
    }

    public String getPdate() {
        return pdate;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }

    public Phone() {
    }

    public Phone(Integer pid, String pname, Integer ptype, Double pprice, Integer pcolor, String pdate) {
        this.pid = pid;
        this.pname = pname;
        this.ptype = ptype;
        this.pprice = pprice;
        this.pcolor = pcolor;
        this.pdate = pdate;
    }
}
