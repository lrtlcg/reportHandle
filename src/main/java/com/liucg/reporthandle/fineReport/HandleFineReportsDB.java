package com.liucg.reporthandle.fineReport;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class HandleFineReportsDB {
    @Autowired
    @Qualifier("jdbcTemplateTwo")
    private JdbcTemplate jdbcTemplate;

    /**
     *
     * @return 获取版本号
     */
    public List getDbData_doc_table(String uuids) {
        StringBuffer sql = new StringBuffer();
        sql.append("select  editVersion from  doc_table where uuids='").append(uuids).append("'");
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql.toString());
        System.out.println("over");
        for (Map<String, Object> map : list) {
            for (String key : map.keySet()) {
                System.out.println(key + "---" + map.get(key));
            }
        }
        return list;
    }

    /**
     * 更新文档版本和版本状态
     * @param list
     * @return
     * @throws Exception
     */
    public Integer update_doc_table(List<Object[]> list) throws Exception{
        String sql="UPDATE  doc_table set editStatus=? where uuids=? and  editVersion=?";
        int flag=0;
        int[] flags=jdbcTemplate.batchUpdate(sql,list);
        flag=flags.length;
        return flag;
    }
}
