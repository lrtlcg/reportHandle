package com.liucg.reporthandle.nc.entity;

import java.io.Serializable;
import java.util.List;

public class ResultInfo implements Serializable {
    private String orgNum;
    private List<ResultInfoDetail> resultInfoDetails;

    public List<ResultInfoDetail> getResultInfoDetails() {
        return resultInfoDetails;
    }

    public void setResultInfoDetails(List<ResultInfoDetail> resultInfoDetails) {
        this.resultInfoDetails = resultInfoDetails;
    }

    public String getOrgNum() {
        return orgNum;
    }

    public void setOrgNum(String orgNum) {
        this.orgNum = orgNum;
    }


}
