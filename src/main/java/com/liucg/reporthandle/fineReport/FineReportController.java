package com.liucg.reporthandle.fineReport;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/report")
public class FineReportController {
    /**
     * 获取最新版版本编号
     */
    @Autowired
    private HandleFineReportsDB handleFineReportsDB;
    @RequestMapping("/getVersion")
    @CrossOrigin(origins = {"https://report.sunpowergroup.com.cn:8001/"})
    public String MisDbData(String reportData){
//        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        JSONObject json= JSON.parseObject(reportData);
//        List list= (List) json.get("pieNC");
        System.out.println(json.get("sysName"));
        SimpleDateFormat dft = new SimpleDateFormat("yyMMdd");
        return json.get("sysName")+dft.format(System.currentTimeMillis()).toString();
    }

    /**
     *
     * @param reportData 报表中参数，包括版本、uuids、所属系统
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateEditStatus")
    @CrossOrigin(origins = {"https://report.sunpowergroup.com.cn:8001/"})
    public String updateData(String reportData) throws Exception {

        JSONObject json= JSON.parseObject(reportData);
        System.out.println(json.get("sysName"));
        SimpleDateFormat dft = new SimpleDateFormat("yyMMdd");

        Object[] objects=new  Object[3];
        objects[2]=json.get("editVersion");
        objects[1]=json.get("uuids");
        objects[0]="历史版本";
        List<Object[]> list=new ArrayList<>();
        list.add(objects);

        return handleFineReportsDB.update_doc_table(list).toString();
    }
}
