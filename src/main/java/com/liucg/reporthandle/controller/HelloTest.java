package com.liucg.reporthandle.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.liucg.reporthandle.mis.HandleMisDb;
import com.liucg.reporthandle.nc.entity.ResultInfoDetail;
import com.liucg.reporthandle.oa.OaRsa;
import com.liucg.reporthandle.oa.OaSer;
import com.liucg.reporthandle.pub.BizException;
import com.liucg.reporthandle.pub.ExceptionCodeEnum;
import com.liucg.reporthandle.pub.Result;
import com.liucg.reporthandle.utils.JsonToXml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test/hello")
public class HelloTest {
    /**
     * 测试MIS 数据库查询
     *
     * @return
     */
    @Autowired
    private HandleMisDb handleMisDb; //mis
    @Autowired
    private OaSer oaSer; //oa


    @RequestMapping("/t1")
    @CrossOrigin
    public String t1() {
        return "祝好运";
    }

    /**
     * @return 通过公钥加密的内容
     */
    @RequestMapping("/t2")
    public String t2() {
        String originalText = "93f0c249-0b3c-441a-90fd-91569cb1befc";
        String publicKeyBase64 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCBoZ0EssJw6Xu1LCawzH8aP5HRF1IfcKWV1cham2aM7IePqDrtWBsRtP38Ujb7pMcLeMAczks9/eAN5eRaP3EfhmJ46JnEglivKPp/Kt+JedYH2mInZyrhZPvi49YokPm7iVcionBLF9+/4+pnbeMVhrKkhLVFC+eDPCy0xAE9vQIDAQAB";
        String str = "";
        try {
            str = OaRsa.getSecret(originalText, publicKeyBase64);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return str;
    }

    /**
     * 请求OA测试服务器，获取最终结果
     *
     * @return
     */
    @RequestMapping("/t3")
    @CrossOrigin // 增加注解，解决跨域问题
    public String t3() {
        String originalText = "93f0c249-0b3c-441a-90fd-91569cb1befc";
        String publicKeyBase64 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCBoZ0EssJw6Xu1LCawzH8aP5HRF1IfcKWV1cham2aM7IePqDrtWBsRtP38Ujb7pMcLeMAczks9/eAN5eRaP3EfhmJ46JnEglivKPp/Kt+JedYH2mInZyrhZPvi49YokPm7iVcionBLF9+/4+pnbeMVhrKkhLVFC+eDPCy0xAE9vQIDAQAB";
        String secret = "";
        try {
            secret = OaRsa.getSecret(originalText, publicKeyBase64); //得到公钥加密后的内容
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("appid", "yonyou"); //在头部添加 appid
        headers.add("secret", secret); //在头部参数中添加secret
        headers.add("Content-Type", "application/json");

        String url = "http://192.168.30.75/api/ec/dev/auth/applytoken";// 请求OA测试库
        HttpEntity<String> formEntity = new HttpEntity<String>(headers);
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
     * MIS操作，查询并新增
     *
     * @return
     */
    @RequestMapping("/t4")
    public String t4() {
        handleMisDb.getDbData_view_TAB_XT_TOTAL();
        handleMisDb.addDbToMis();
        return "成功";
    }

    /**
     * 字符串转xml
     *
     * @param a
     * @return
     * @throws JsonProcessingException
     */
//    @RequestMapping("/t5")
//    @CrossOrigin
//    public String t5(String a) throws JsonProcessingException { //这里a和ajax中的data 一致
//        JSONObject jsonObject = JSON.parseObject(a); // 转换成json
//        System.out.println(jsonObject.get("pieTest"));  //获取json中标签
//        String xml = JsonToXml.tranJsonToXml(a);
//        System.out.println("XML结果:\n" + xml);
//        return a;
//    }

    /**
     * 获取OA新建流程 封装token
     *
     * @return
     */
    @RequestMapping("/t6") //对获取token程序进行封装
//    @CrossOrigin // 增加注解，解决跨域问题
    public String t6() {
        String url = "http://192.168.30.75/api/ec/dev/auth/applytoken"; // 请求地址
        //加密
        String originalText = "93f0c249-0b3c-441a-90fd-91569cb1befc";
        String publicKeyBase64 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCBoZ0EssJw6Xu1LCawzH8aP5HRF1IfcKWV1cham2aM7IePqDrtWBsRtP38Ujb7pMcLeMAczks9/eAN5eRaP3EfhmJ46JnEglivKPp/Kt+JedYH2mInZyrhZPvi49YokPm7iVcionBLF9+/4+pnbeMVhrKkhLVFC+eDPCy0xAE9vQIDAQAB";
        String secret = "";
        try {
            secret = OaRsa.getSecret(originalText, publicKeyBase64); //得到公钥加密后的内容
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return oaSer.getToken(secret, url); //获取token
    }

    /**
     * 新建OA流程
     *
     * @return
     */
    @RequestMapping("/t7") //对获取token程序进行封装
    public String t7() {
        String url = "http://192.168.30.75/api/ec/dev/auth/applytoken"; // 请求地址
        String urlReq = "http://192.168.30.75/api/workflow/paService/doCreateRequest";
        //加密
        String originalText = "93f0c249-0b3c-441a-90fd-91569cb1befc";
        String spk = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCBoZ0EssJw6Xu1LCawzH8aP5HRF1IfcKWV1cham2aM7IePqDrtWBsRtP38Ujb7pMcLeMAczks9/eAN5eRaP3EfhmJ46JnEglivKPp/Kt+JedYH2mInZyrhZPvi49YokPm7iVcionBLF9+/4+pnbeMVhrKkhLVFC+eDPCy0xAE9vQIDAQAB";
        String oaUserID = "13287"; //用户主键
        String userid = "";
        String secret = "";
        try {
            secret = OaRsa.getSecret(originalText, spk); //得到公钥加密后的内容
            userid = OaRsa.getSecret(oaUserID, spk);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String token = oaSer.getToken(secret, url); //获取token
        System.out.println("token：" + token);
        System.out.println("userid:" + userid);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("appid", "yonyou"); //在头部添加 appid
        headers.add("token", token); //在头部添加 token
        headers.add("userid", userid); //在头部参数中添加userid
        headers.add("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        // 传递请求体参数
        String workflowId = "217745";
        String requestName = "测试流程1111";
        String otherParams = "{\"isnextflow\": \"0\"}";
        String mainData = "[{\"fieldName\": \"zs\",\"fieldValue\": \"中国\"},\t{\"fieldName\": \"sy\",\t\"fieldValue\": \"21\"}]"; //主表信息

        StringBuffer sb = new StringBuffer();
        sb.append("workflowId=").append(workflowId).append("&");
        sb.append("requestName=").append(requestName).append("&");
        sb.append("otherParams").append(otherParams).append("&");
        sb.append("mainData=").append(mainData);


        HttpEntity<String> formEntity = new HttpEntity<String>(sb.toString(), headers); //
        ResponseEntity<String> response = restTemplate.exchange(

                urlReq,//获取资源的地址
                HttpMethod.POST,
                formEntity,
                String.class//返回类型设为String
        );
        String body = response.getBody();


        return body; //获取token
    }

    /**
     * 新建OA流程，封装
     *
     * @return
     */
    @RequestMapping("/t8") //对获取token程序进行封装
    public String t8() {
        String url = "http://192.168.30.75/api/ec/dev/auth/applytoken"; // 请求地址
        String urlReq = "http://192.168.30.75/api/workflow/paService/doCreateRequest";
        //加密
        String originalText = "93f0c249-0b3c-441a-90fd-91569cb1befc";
        String spk = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCBoZ0EssJw6Xu1LCawzH8aP5HRF1IfcKWV1cham2aM7IePqDrtWBsRtP38Ujb7pMcLeMAczks9/eAN5eRaP3EfhmJ46JnEglivKPp/Kt+JedYH2mInZyrhZPvi49YokPm7iVcionBLF9+/4+pnbeMVhrKkhLVFC+eDPCy0xAE9vQIDAQAB";
        String oaUserID = "13287"; //用户主键
        String appid = "yonyou";
        String userid = "";
        String secret = "";
        try {
            secret = OaRsa.getSecret(originalText, spk); //得到公钥加密后的内容
            userid = OaRsa.getSecret(oaUserID, spk);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String token = oaSer.getToken(secret, url); //获取token


        // 传递请求体参数
        String workflowId = "217745";
        String requestName = "测试流程1111";
        String otherParams = "{\"isnextflow\": \"0\"}";
        String mainData = "[{\"fieldName\": \"zs\",\"fieldValue\": \"中国\"},\t{\"fieldName\": \"sy\",\t\"fieldValue\": \"21\"}]"; //主表信息

        StringBuffer sb = new StringBuffer();
        sb.append("workflowId=").append(workflowId).append("&");
        sb.append("requestName=").append(requestName).append("&");
        sb.append("otherParams").append(otherParams).append("&");
        sb.append("mainData=").append(mainData);

        // 新建订单
        return oaSer.addOAFlower(appid, token, userid, urlReq, sb.toString());
    }

    @RequestMapping("/t9")
    public String t9() {
        String appid = "f1b5dc5a-ae1c-4a7b-a4f2-a11d39c14321";
        String loginid = "02691";
        String url = "http://192.168.30.75/ssologin/getToken";
        return oaSer.getSsoToken(loginid, appid, url);
    }

    /**
     * 通过报表请求，新建一个测试流程，获取流程id
     * 获取SSOtoken
     * 封装地址，给报表，打开新建流程页面
     */
    @RequestMapping("/t10")
    @CrossOrigin
    public String t10() {
        String ssoAppid = "f1b5dc5a-ae1c-4a7b-a4f2-a11d39c14321";
        String loginid = "02691";
        String ssoUrl = "http://192.168.30.75/ssologin/getToken"; // ssotoken，用于单点登录，新建流程完成后，跳转到新建流程画面

        String url = "http://192.168.30.75/api/ec/dev/auth/applytoken"; // 流程token
        String urlReq = "http://192.168.30.75/api/workflow/paService/doCreateRequest"; //新建流程
        //加密
        String originalText = "93f0c249-0b3c-441a-90fd-91569cb1befc";
        String spk = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCBoZ0EssJw6Xu1LCawzH8aP5HRF1IfcKWV1cham2aM7IePqDrtWBsRtP38Ujb7pMcLeMAczks9/eAN5eRaP3EfhmJ46JnEglivKPp/Kt+JedYH2mInZyrhZPvi49YokPm7iVcionBLF9+/4+pnbeMVhrKkhLVFC+eDPCy0xAE9vQIDAQAB";
        String oaUserID = "13287"; //用户主键
        String appid = "yonyou";
        String userid = "";
        String secret = "";
        try {
            secret = OaRsa.getSecret(originalText, spk); //得到公钥加密后的内容
            userid = OaRsa.getSecret(oaUserID, spk);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String token = oaSer.getToken(secret, url); //获取token


        // 传递请求体参数
        String workflowId = "217745";
        String requestName = "测试流程1111";
        String otherParams = "{\"isnextflow\": \"0\"}";
        String mainData = "[{\"fieldName\": \"zs\",\"fieldValue\": \"中国\"},\t{\"fieldName\": \"sy\",\t\"fieldValue\": \"21\"}]"; //主表信息

        StringBuffer sb = new StringBuffer();
        sb.append("workflowId=").append(workflowId).append("&");
        sb.append("requestName=").append(requestName).append("&");
        sb.append("otherParams").append(otherParams).append("&");
        sb.append("mainData=").append(mainData);

        // 新建订单
        String returnStr = oaSer.addOAFlower(appid, token, userid, urlReq, sb.toString());
        JSONObject jsonObject = JSON.parseObject(returnStr);
        String requestid = jsonObject.getJSONObject("data").getString("requestid");

        String ssoToken = oaSer.getSsoToken(loginid, ssoAppid, ssoUrl);

        StringBuffer openUrl = new StringBuffer();
/**
 *   打开流程：http://192.168.30.75/workflow/request/ViewRequest.jsp?requestid=927644&ssoToken=50C665B93108AB8FBE28EE23492DA7EFBC6CDE82202E74A87F0F40BCFB11B23B0B5E31789FE7B8C6C11798AE50921380344C566804E7D2D3D7E8C4DEA5F0C197
 *   打开首页：http://192.168.30.75/wui/index.html?ssoToken=88CBC446BCCBA520A54763FDEE011B909506D1A97414A71989DBAA63CAA1B7850B5E31789FE7B8C6C11798AE50921380344C566804E7D2D3D7E8C4DEA5F0C197#/main
 */
        openUrl.append("http://192.168.30.75/workflow/request/ViewRequest.jsp?requestid=")
                .append(requestid)
                .append("&ssoToken=")
                .append(ssoToken);
        return openUrl.toString();
    }

    /**
     * 断言的使用
     * @return
     */
    @RequestMapping("/t11")
    public ResultInfoDetail t11(String t){
        try{
            Assert.hasText(t,"不包含test");
        }catch (Exception e){
            System.out.println("不包含test:"+e);
        }
        ResultInfoDetail rsd=new ResultInfoDetail();
        rsd.setBdh("Ab123456");
        rsd.setStatus("ss");
        return rsd;
    }

    /**
     * 自定义异常测试
     * @param t
     * @return
     */
    @RequestMapping("/t12")
    public Result<Boolean> t12(String t){
        if(t==null){
            return Result.error(ExceptionCodeEnum.EMPTY_PARAM);
        }
        boolean falg=false;
        Result re=Result.success("sss");
        return  re;
    }

    /**
     * 自定义异常测试
     * @param t
     * @return
     */
    @RequestMapping("/t13")
    public Result<ResultInfoDetail> t13(String t){
        try{
            Assert.hasText(t,"不包含test");
        }catch (Exception e){
            System.out.println("不包含test:"+e);
            return Result.error(ExceptionCodeEnum.EMPTY_PARAM);
        }
        ResultInfoDetail rsd=new ResultInfoDetail();
        rsd.setBdh("Ab123456");
        rsd.setStatus("ss");
        return Result.success(rsd);
    }

    /**
     * 全局异常测试
     * @param t
     * @return
     */
    @RequestMapping("/t14")
    public Result<ResultInfoDetail> t14(String t){
        try{
            Assert.hasText(t,"不包含test");
        }catch (Exception e){
            throw new BizException(ExceptionCodeEnum.EMPTY_PARAM,e);
        }
        ResultInfoDetail rsd=new ResultInfoDetail();
        rsd.setBdh("Ab123456");
        rsd.setStatus("ss");
        return Result.success(rsd);
    }
}
