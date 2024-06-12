package com.liucg.reporthandle.test.fineReport;

import com.liucg.reporthandle.fineReport.HandleFineReportsDB;
import com.liucg.reporthandle.mis.HandleMisDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class FineReportTest {
    @Autowired
    private HandleFineReportsDB handleMisDb;
    @RequestMapping("/freport")
    @CrossOrigin(origins = {"https://report.sunpowergroup.com.cn:8001/"})
    public String MisDbData(){
        List list=handleMisDb.getDbData_doc_table("");
        return "cheng";
    }

    @RequestMapping("/upfreport")
    @CrossOrigin(origins = {"https://report.sunpowergroup.com.cn:8001/"})
    public String updateData() throws Exception {
        Object[] objects=new  Object[2];
        objects[1]="f6c52acf-e927-443c-8025-f43d659c2c69";
        objects[0]="历史版本";
        List<Object[]> list=new ArrayList<>();
        list.add(objects);

        return handleMisDb.update_doc_table(list).toString();
    }
}
