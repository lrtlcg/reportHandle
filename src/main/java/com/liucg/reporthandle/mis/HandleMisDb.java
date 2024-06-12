package com.liucg.reporthandle.mis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * MIS数据库的操作
 */
@Component
@Slf4j
public class HandleMisDb {
    @Autowired
    @Qualifier("jdbcTemplateOne")
    private JdbcTemplate jdbcTemplate;
    /**
     * 获取新泰生物质数据
     * @return
     */
    public List getDbData_view_TAB_XT_TOTAL() {
        String sql = "select  * from view_TAB_XT_TOTAL where 年月='2021-01'";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println("over");
        for (Map<String, Object> map : list) {
            for (String key : map.keySet()) {
                System.out.println(key + "---" + map.get(key));
            }
        }
        return list;
    }

    /**
     * 插入到MIS中
     */
//    @Scheduled(cron = "0/1 * * * * *")
    public void addDbToMis() {
        String sql = "INSERT INTO zskj.NC2MIS( MISID, NCMAINID) VALUES ( 'C', ?)"; //字符串不带分号
        jdbcTemplate.update(sql,"定时任务测试");
        log.info("=====================测试日志");
    }

    /**
     * NC 返回结果，保存到MIS表中
     * @param list
     * MISID 条形码, NCSTATUS 同步状态,NCDESC 同步结果描述,NCWRITETIME 同步时间,BAK3 公司组织,bak4 净重,bak5 采购订单号
     * @return
     */
    public Integer batchAddDbToMis(List<Object[]> list){
        String sql ="INSERT INTO zskj.NC2MIS( MISID, NCSTATUS,NCDESC,NCWRITETIME,BAK1,BAK3,BAK4,BAK5) VALUES ( ?,?,?,?,?,?,?,?)";
        try {
            jdbcTemplate.batchUpdate(sql,list);
        }catch (Exception e){
            log.error("保存到MIS表NC2MIS错误："+e);
        }
        return 0;
    }

    /**
     * NC发票数据回写到MIS中
     * @param list
     * @return
     * @throws Exception
     */
    public Integer addFpMsg(List<Object[]> list) throws Exception{
        String sql="INSERT INTO zskj.NC2MIS_FP(ID, ORGNUM,  BDH, WSDJ, HSDJ, SL, WSJE, HSJE, FKSJ, FKHUM,STATUS) VALUES ( ?,?,?,?,?,?,?,?,?,?,?)";
        int flag=0;
           int[] flags=jdbcTemplate.batchUpdate(sql,list);
           flag=flags.length;
        return flag;
    }

    /**
     * 更新发票的状态
     * @param list
     * @return
     * @throws Exception
     */
    public Integer updateFpMsg(List<Object[]> list) throws Exception{
        String sql="UPDATE  zskj.NC2MIS_FP set STATUS=?,NCID=? where BDH=? AND ORGNUM=?";
        int flag=0;
        int[] flags=jdbcTemplate.batchUpdate(sql,list);
        flag=flags.length;
        return flag;
    }

}
