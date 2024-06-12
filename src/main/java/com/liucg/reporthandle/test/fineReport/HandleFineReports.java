package com.liucg.reporthandle.test.fineReport;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class HandleFineReports {
    @Autowired
    @Qualifier("jdbcTemplateTwo")
    private JdbcTemplate jdbcTemplate;
    public List getDbData_doc_table() {
        String sql = "select  * from  doc_table";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println("over");
        for (Map<String, Object> map : list) {
            for (String key : map.keySet()) {
                System.out.println(key + "---" + map.get(key));
            }
        }
        return list;
//        return null;
    }
}
