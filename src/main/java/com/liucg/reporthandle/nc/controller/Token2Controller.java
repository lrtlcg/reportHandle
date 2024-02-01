package com.liucg.reporthandle.nc.controller;

import com.alibaba.fastjson.JSONObject;
import com.liucg.reporthandle.mis.HandleMisDb;
import com.liucg.reporthandle.nc.entity.ResultInfo;
import com.liucg.reporthandle.nc.entity.ResultInfoDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Slf4j
@RestController
public class Token2Controller {
    @Autowired
    private HandleMisDb handleMisDb;

    /**
     * NC返回发票结果数据
     *
     * @param resultInfo
     * @return
     */
    @PostMapping(value = "/token/ncWriteResult", produces = "application/json;charset=UTF-8")
    public String ncWriteResult(@RequestBody ResultInfo resultInfo) {
        JSONObject jsonObject = new JSONObject();
        List<ResultInfoDetail> resultInfoDetails = resultInfo.getResultInfoDetails();
        String orgnum=resultInfo.getOrgNum();
        List<Object[]> list=new ArrayList<>();
        for (ResultInfoDetail resultInfoDetail : resultInfoDetails) {
            //ID, ORGNUM, BDH, WSDJ, HSDJ, SL, WSJE, HSJE, FKSJ, FKHUM
            UUID uuid = UUID.randomUUID();
            Object[] objects=new  Object[10];
            objects[0]=uuid.toString();
            objects[1]=orgnum;
            objects[2]=resultInfoDetail.getBdh();
            objects[3]=resultInfoDetail.getWsdj();
            objects[4]=resultInfoDetail.getHsdj();
            objects[5]=resultInfoDetail.getSl();
            objects[6]=resultInfoDetail.getWsje();
            objects[7]=resultInfoDetail.getHsje();
            objects[8]=resultInfoDetail.getFksj();
            objects[9]=resultInfoDetail.getFkhum();
            list.add(objects);
//            System.out.println(resultInfoDetail.toString());
        }
        try{
            int flag=handleMisDb.addFpMsg(list);
            if(flag>0){
                jsonObject.put("result", "success");
                jsonObject.put("status", "100");
            }else{
                jsonObject.put("result", "error");
                jsonObject.put("status", "201");
                jsonObject.put("desc", "写入数据失败");
            }

        }catch (Exception e){
            jsonObject.put("result", "error");
            jsonObject.put("status", "200");
            jsonObject.put("desc", "同步数据失败");
            log.error("NC发票数据写入数据库错误"+e);
        }
        return jsonObject.toString();
    }
}
