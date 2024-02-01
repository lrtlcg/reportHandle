package com.liucg.reporthandle.nc.entity;

import java.io.Serializable;

public class ResultInfoDetail implements Serializable {
    private String bdh; // 磅单号
    private float wsdj; // 未税单价
    private float hsdj; //含税单价
    private float sl; //税率
    private float wsje; // 未税金额
    private float hsje;// 含税金额

    private String fksj; //写入时间
    private String fkhum; //写入人员

    public String getFksj() {
        return fksj;
    }

    public void setFksj(String fksj) {
        this.fksj = fksj;
    }

    public String getFkhum() {
        return fkhum;
    }

    public void setFkhum(String fkhum) {
        this.fkhum = fkhum;
    }

    public String getBdh() {
        return bdh;
    }

    public void setBdh(String bdh) {
        this.bdh = bdh;
    }

    public float getWsdj() {
        return wsdj;
    }

    public void setWsdj(float wsdj) {
        this.wsdj = wsdj;
    }

    public float getHsdj() {
        return hsdj;
    }

    public void setHsdj(float hsdj) {
        this.hsdj = hsdj;
    }

    public float getSl() {
        return sl;
    }

    public void setSl(float sl) {
        this.sl = sl;
    }

    public float getWsje() {
        return wsje;
    }

    public void setWsje(float wsje) {
        this.wsje = wsje;
    }

    public float getHsje() {
        return hsje;
    }

    public void setHsje(float hsje) {
        this.hsje = hsje;
    }

    @Override
    public String toString() {
        return "ResultInfoDetail{" +
                "bdh='" + bdh + '\'' +
                ", wsdj=" + wsdj +
                ", hsdj=" + hsdj +
                ", sl=" + sl +
                ", wsje=" + wsje +
                ", hsje=" + hsje +
                '}';
    }
}
