package com.liucg.reporthandle.nc;


import com.liucg.reporthandle.nc.other.NCContent;
import com.liucg.reporthandle.nc.server.NCServer;

import java.net.HttpURLConnection;

public class NCTestMain {
    public static void main(String[] args) {
//        System.out.println(NCServer.createConn());
        HttpURLConnection connection= NCServer.createConn();
        NCServer ncServer=new NCServer();
        NCContent ncContent=new NCContent();
//        System.out.println(ncContent.formatXml3());
//        String [] result= ncServer.sendXmlToNC(connection, ncContent.formatXml5());
//        System.out.println(result[0]+"=========="+result[1]);
//        ncServer.writeNc(ncContent.formatXml3());
//        ncServer.sendXmlToNC(connection, ncContent.fromatXml(null));
    }
}
