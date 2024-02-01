package com.liucg.reporthandle.sys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User  implements Serializable {
    private String id;
    private  String uName; //账号
    private String  uPwd; //密码
    private String uOrg; // 公司
    private String uStatus;// 账号状态

    public String getuStatus() {
        return uStatus;
    }

    public void setuStatus(String uStatus) {
        this.uStatus = uStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    public String getuOrg() {
        return uOrg;
    }

    public void setuOrg(String uOrg) {
        this.uOrg = uOrg;
    }
}
