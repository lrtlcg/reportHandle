package com.liucg.reporthandle.test.mis;

import com.liucg.reporthandle.mis.HandleMisDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class GetMISDB {
    @Autowired
    private HandleMisDb handleMisDb;
    @RequestMapping("/sendMis2NC")
    @CrossOrigin(origins = {"https://report.sunpowergroup.com.cn:8001/"})
    public String MisDbData(){
        List list=handleMisDb.getDbData_view_TAB_XT_TOTAL();
        return "cheng";
    }
}
