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
        if(orgnum.trim().isEmpty()){
            jsonObject.put("result", "error");
            jsonObject.put("status", "201");
            jsonObject.put("desc", "组织代码不可以为空");
            return jsonObject.toString();
        }
        for (ResultInfoDetail resultInfoDetail : resultInfoDetails) {
            if(resultInfoDetail.getBdh().trim().isEmpty()){
                jsonObject.put("result", "error");
                jsonObject.put("status", "201");
                jsonObject.put("desc", "磅单号不可以为空");
                return jsonObject.toString();
            }
            UUID uuid = UUID.randomUUID();
            Object[] objects=new  Object[11];
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
            objects[10]=resultInfoDetail.getStatus();
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
            throw new RuntimeException(e);
        }
        return jsonObject.toString();
    }

    /**
     * 发票数据更新
     * @param resultInfo
     * @return 返回更新结果
     */
    @PostMapping(value = "/token/ncUpdateResult", produces = "application/json;charset=UTF-8")
    public String ncUpdateResult(@RequestBody ResultInfo resultInfo){
        JSONObject jsonObject = new JSONObject();
        List<ResultInfoDetail> resultInfoDetails = resultInfo.getResultInfoDetails();
        String orgnum=resultInfo.getOrgNum();
        if(orgnum.trim().isEmpty()){
            jsonObject.put("result", "error");
            jsonObject.put("status", "201");
            jsonObject.put("desc", "组织代码不可以为空");
            return jsonObject.toString();
        }
        List<Object[]> list=new ArrayList<>();
        for (ResultInfoDetail resultInfoDetail : resultInfoDetails) {
            if(resultInfoDetail.getBdh().trim().isEmpty()){
                jsonObject.put("result", "error");
                jsonObject.put("status", "201");
                jsonObject.put("desc", "磅单号不可以为空");
                return jsonObject.toString();
            }
            Object[] objects=new  Object[4];
            objects[3]=orgnum;
            objects[2]=resultInfoDetail.getBdh();
            objects[0]=resultInfoDetail.getStatus();
            objects[1]=resultInfoDetail.getNcid();
            list.add(objects);
        }
        try {
            int flag= handleMisDb.updateFpMsg(list);
            if(flag>0){
                jsonObject.put("result", "success");
                jsonObject.put("status", "100");
            }else{
                jsonObject.put("result", "error");
                jsonObject.put("status", "201");
                jsonObject.put("desc", "更新数据失败");
            }

        } catch (Exception e) {
            jsonObject.put("result", "error");
            jsonObject.put("status", "200");
            jsonObject.put("desc", "同步数据失败");
            log.error("NC发票数据写入数据库错误"+e);
            throw new RuntimeException(e);
        }
        return jsonObject.toString();
    }
}
