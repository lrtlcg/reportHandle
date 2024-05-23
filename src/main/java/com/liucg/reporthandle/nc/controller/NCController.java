package com.liucg.reporthandle.nc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liucg.reporthandle.mis.HandleMisDb;
import com.liucg.reporthandle.nc.other.NCContent;
import com.liucg.reporthandle.nc.server.NCServer;
import com.liucg.reporthandle.nc.server.NCServerTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/nc")
public class NCController {
    @Autowired
    private NCServer ncServer;
    @Autowired
    private NCServerTest ncServerTest;
    @Autowired
    private NCContent ncContent;
    @Autowired
    private HandleMisDb handleMisDb;
    /**
     * 传递数据到nc
     * @param misJosn MIS上传的内容
     * @return 成功或失败
     */
    @RequestMapping("/sendMis2NC")
    @CrossOrigin(origins = {"https://report.sunpowergroup.com.cn:8001/"})
    public Boolean SendXmlMis2Nc(String misJosn){
        Boolean flag=false;
        HttpURLConnection connection=NCServer.createConn();
        /**
         * 1.先传一条试试
         * 2.遍历多条
         * 3.回写数据库
         * 4.关闭HttpURLConnection
         * 5.日志记录，每天一条日志
         */
//        Map<String,String[]> map=new HashMap<String,String[]>();
        List<Object[]> resultList =new ArrayList<Object[]>(); //保存到数据库
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        JSONObject json= JSON.parseObject(misJosn);
        List list= (List) json.get("pieNC");
        if (list!=null){
            for(Object jb:list){
                JSONObject jsons = JSON.parseObject(jb.toString());
                String result[]= ncServer.sendXmlToNC(NCServer.createConn(), ncContent.fromatXml(jsons)); // 写入Nc
//                System.out.println(jsons.getString("ID")+"============="+result[0]+"================="+result[1]);
//                map.put(jsons.getString("ID"),result); // 保存到map中，存储到数据库
                resultList.add(new Object[]{jsons.getString("ID"),result[0],result[1],dft.format(System.currentTimeMillis()).toString(),result[2],jsons.getString("ZZ"),jsons.getString("JZ"),jsons.getString("CGDDH")});
            }
            handleMisDb.batchAddDbToMis(resultList);// 提交到mis
        }

        return flag;
    }
    /**
     * 测试环境
     */
    @RequestMapping("/sendMis2NCTest")
    @CrossOrigin(origins = {"https://report.sunpowergroup.com.cn:8001/"})
    public Boolean SendXmlMis2NcTest(String misJosn){
        Boolean flag=false;
//        HttpURLConnection connection=NCServerTest.createConn();
        /**
         * 1.先传一条试试
         * 2.遍历多条
         * 3.回写数据库
         * 4.关闭HttpURLConnection
         * 5.日志记录，每天一条日志
         */
        List<Object[]> resultList =new ArrayList<Object[]>(); //保存到数据库
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        JSONObject json= JSON.parseObject(misJosn);
        List list= (List) json.get("pieNC");
        if (list!=null){
            for(Object jb:list){
                JSONObject jsons = JSON.parseObject(jb.toString());
                String result[]= ncServerTest.sendXmlToNC(NCServerTest.createConn(), ncContent.fromatXml(jsons)); // 写入Nc
                resultList.add(new Object[]{jsons.getString("ID"),result[0],result[1],dft.format(System.currentTimeMillis()).toString(),result[2],jsons.getString("ZZ"),jsons.getString("JZ"),"_Test_"+jsons.getString("CGDDH")});
            }
            handleMisDb.batchAddDbToMis(resultList);// 提交到mis
        }
        return flag;
    }
}
