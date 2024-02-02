package com.liucg.reporthandle.utils;

import org.apache.commons.lang.StringUtils;

public class Stringutil {
    public boolean strUtil(String str){
        boolean flag=false;
        if(StringUtils.isEmpty(str)||StringUtils.equals(str,"")){
            flag=true;
        }
        return flag;
    }
}
