package com.liucg.reporthandle.nc.server;

import com.liucg.reporthandle.nc.other.NCConst;
import lombok.extern.slf4j.Slf4j;
import nc.vo.jcom.xml.XMLUtil;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@Slf4j
@Component
/**
 * 用户读取或者写入NC的操作
 */
public class NCServer {
    /**
     * 创建NC连接
     *
     * @return
     */
    public static HttpURLConnection createConn() {
        HttpURLConnection connection = null;
        String url = NCConst.ws_url;
        URL realURL;
        try {
            realURL = new URL(url);
            connection = (HttpURLConnection) realURL.openConnection();
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-type", "text/xml");
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Charset", "GBK");
        } catch (MalformedURLException e) {
            log.error("获取NC系统HttpURLConnection 异常："+e);
            e.printStackTrace();
        } catch (ProtocolException e) {
            log.error("获取NC系统HttpURLConnection 异常："+e);
            e.printStackTrace();
        } catch (IOException e) {
            log.error("获取NC系统HttpURLConnection 异常："+e);
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * @param connection NC连接
     * @param xml        发送的内容
     */
    public String[] sendXmlToNC(HttpURLConnection connection, String xml) {
//        System.out.println(xml);
        String [] result=null;
        try {
            BufferedOutputStream out = new BufferedOutputStream(connection.getOutputStream());
            ByteArrayInputStream stream = new ByteArrayInputStream(xml.getBytes("utf-8"));
            BufferedInputStream input = new BufferedInputStream(stream);

            int length;
            byte[] buffer = new byte[1000];
            while ((length = input.read(buffer, 0, 1000)) != -1) {
                out.write(buffer, 0, length);
            }
            input.close();
            out.close();
            result=returnMsgFromNC(connection); // 反写
        } catch (IOException e) {
            log.error("MIS生物质数据同步至NC系统中异常:" + e);
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     * NC 返回同步数据状态
     * @param connection 请求
     * @return
     */
    public String[] returnMsgFromNC(HttpURLConnection connection) {
        String[] result = new String[3];
        try {
            InputStream inputStream = connection.getInputStream();
            Document resDoc = XMLUtil.getDocumentBuilder().parse(inputStream);
            Element root = resDoc.getDocumentElement();
            Element sendresult = XMLUtil.getFirstChildElement(root, NCConst.r_sendresult);
            Element resultdescription = XMLUtil.getFirstChildElement(sendresult, NCConst.r_resultdescription);
            Element resultcode = XMLUtil.getFirstChildElement(sendresult, NCConst.r_resultcode);
            String code = XMLUtil.getValueOf(resultcode);
            String err = XMLUtil.getValueOf(resultdescription);
            if (!"1".equals(code)) {
                result[0] = "0";
                result[1] = err;
                result[2] = "同步错误";
                log.info("returnMsgFromNC:同步数据反写失败！"+err);
            } else {
                Element contentElement = XMLUtil.getFirstChildElement(sendresult, NCConst.r_content);
                String content = XMLUtil.getValueOf(contentElement);
                result[0] = "1";
                result[1] = content;
                result[2]= "已同步";
                log.info("returnMsgFromNC:同步数据反写成功！"+content);
            }
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            result[0] = "0";
            result[1] = e.toString();
//            inputStream.close();
            log.error("error:同步MIS生物质数据到NC系统，反写异常！"+result[1]);
        }
        return result;
    }

    public String[] writeNc(String xml) {
        String[] result = new String[2];
//        baseBean.writeLog(NCConst.title[3] + "调用NC的WebService服务所属流程号==" + requestid);
        try {
            HttpURLConnection connection = createConn();
            BufferedOutputStream out = new BufferedOutputStream(connection.getOutputStream());
            ByteArrayInputStream stream = new ByteArrayInputStream(xml.getBytes("utf-8"));
            BufferedInputStream input = new BufferedInputStream(stream);

            int length;
            byte[] buffer = new byte[1000];
            while ((length = input.read(buffer, 0, 1000)) != -1) {
                out.write(buffer, 0, length);
            }
            input.close();
            out.close();
//		 		// 从连接的输入流中取得回执信息
            InputStream inputStream = connection.getInputStream();
            Document resDoc = XMLUtil.getDocumentBuilder().parse(inputStream);
            Element root = resDoc.getDocumentElement();
            Element sendresult = XMLUtil.getFirstChildElement(root, NCConst.r_sendresult);
            Element resultdescription = XMLUtil.getFirstChildElement(sendresult, NCConst.r_resultdescription);
            Element resultcode = XMLUtil.getFirstChildElement(sendresult, NCConst.r_resultcode);
            String code = XMLUtil.getValueOf(resultcode);
            String err = XMLUtil.getValueOf(resultdescription);
            if (!"1".equals(code)) {
                result[0] = "0";
                result[1] = err;
            } else {
                Element contentElement = XMLUtil.getFirstChildElement(sendresult, NCConst.r_content);
                String content = XMLUtil.getValueOf(contentElement);
                result[0] = "1";
                result[1] = content;
            }
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            result[0] = "0";
            result[1] = e.toString();
        }
        return result;
    }
}
