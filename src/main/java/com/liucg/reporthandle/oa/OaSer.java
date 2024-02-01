package com.liucg.reporthandle.oa;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OaSer {
    /**
     * 获取OA系统流程token
     * @param secret 通过spk(第一步传回)对secret（第一步传回）进行RSA加密后的密文
     * @return token
     */
    public  String getToken(String secret,String url){
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("appid","yonyou"); //在头部添加 appid
        headers.add("secret",secret); //在头部参数中添加secret
        headers.add("Content-Type", "application/json");

//        String url = "http://192.168.30.75/api/ec/dev/auth/applytoken";// 请求OA测试库
        HttpEntity<String> formEntity = new HttpEntity<String>( headers);
        ResponseEntity<String> response = restTemplate.exchange(
                url,//获取资源的地址
                HttpMethod.POST,
                formEntity,
                String.class//返回类型设为String
        );
        String body = response.getBody();
        JSONObject jsonObject =  JSON.parseObject(body);
        return jsonObject.get("token").toString();
    }

    /**
     * 新建流程
     * @param appid appid
     * @param token
     * @param userid 通过第一步注册许可时返回spk公钥对OAID（用户账号主键）进行RSA加密生成的密文
     * @param url  http://xx.com/api/workflow/paService/doCreateRequest
     * @param conent   请求体内容
     * @return 返回状态
     */
    public String addOAFlower(String appid,String token,String userid,String url,String conent){
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("appid",appid); //在头部添加 appid
        headers.add("token",token); //在头部添加 token
        headers.add("userid",userid); //在头部参数中添加userid
        headers.add("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        HttpEntity<String> formEntity = new HttpEntity<String>( conent,headers);
        ResponseEntity<String> response = restTemplate.exchange(
                url,//获取资源的地址
                HttpMethod.POST,
                formEntity,
                String.class//返回类型设为String
        );
        String body = response.getBody();
        return body;
    }

    /**
     * 用于单点登录
     * @param loginid 登录账号
     * @param appid  appid
     * @param url 网址
     * @return 单点登录的token
     *   打开流程：http://192.168.30.75/workflow/request/ViewRequest.jsp?requestid=927644&ssoToken=50C665B93108AB8FBE28EE23492DA7EFBC6CDE82202E74A87F0F40BCFB11B23B0B5E31789FE7B8C6C11798AE50921380344C566804E7D2D3D7E8C4DEA5F0C197
     *   打开首页：http://192.168.30.75/wui/index.html?ssoToken=88CBC446BCCBA520A54763FDEE011B909506D1A97414A71989DBAA63CAA1B7850B5E31789FE7B8C6C11798AE50921380344C566804E7D2D3D7E8C4DEA5F0C197#/main
     */
    public String getSsoToken(String loginid,String appid,String url){
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
//        headers.add("appid",appid); //在头部添加 appid
//        headers.add("loginid",userID); //在头部添加 token
        headers.add("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        StringBuffer sb=new StringBuffer();
        sb.append("&appid=").append(appid).append("").append("&loginid=").append(loginid);
        HttpEntity<String> formEntity = new HttpEntity<String>( sb.toString(),headers);
        ResponseEntity<String> response = restTemplate.exchange(
                url,//获取资源的地址
                HttpMethod.POST,
                formEntity,
                String.class//返回类型设为String
        );
        String body = response.getBody();
        return body;
    }
}
