package com.liucg.reporthandle.sys.service;

import com.alibaba.fastjson.JSONObject;
import com.liucg.reporthandle.sys.entity.WeChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * 企业微信内容发送
 */
@Service
@Slf4j
public class WeChatService {

    private final RestTemplate restTemplate;
    private final String weChatApiUrl = "https://qyapi.weixin.qq.com/cgi-bin/"; // 企业微信API地址
    private final String corpId = "wwf78bd53a1cd595f2"; // 替换为您的企业ID
    private final String agentId = "1000005"; // 替换为您的代理ID
    private final String secret = "1UQgFAOGuPUQTqy9XrEXVLY2fsDT2dpEnYzY5Kjrlok"; // 替换为您的接口密钥

    //    @Autowired
    public WeChatService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendWeChatMessage(WeChatMessage message) {
        // 构建请求URL
        String url = weChatApiUrl + "message/send?access_token=" + getAccessToken();

        // 构建请求体
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("touser", message.getToUser());
        requestBody.put("msgtype", "text");
        requestBody.put("agentid", agentId);
        requestBody.put("text", new HashMap<String, String>() {{
            put("content", message.getContent());
        }});

        // 发送请求
        ResponseEntity<String> response = restTemplate.postForEntity(url, requestBody, String.class);

        // 处理响应
        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("消息发送成功！");
        } else {
            System.out.println("消息发送失败：" + response.getBody());
        }
    }

    /**
     * 获取token的地址  https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=wwf78bd53a1cd595f2&corpsecret=1UQgFAOGuPUQTqy9XrEXVLY2fsDT2dpEnYzY5Kjrlok
     * 此处是固定的
     * corpid：我的企业，企业ID
     * wwf78bd53a1cd595f2
     * Secret：应用的Secret
     * 1UQgFAOGuPUQTqy9XrEXVLY2fsDT2dpEnYzY5Kjrlok
     * agentId：应用id
     *
     * @return  token
     */
    private String getAccessToken() {
        // 此处应有一个获取access_token的逻辑，因涉及敏感信息，不再展开
        String url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + corpId + "&corpsecret=" + secret;
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            Map<String, Object> responseMap = JSONObject.parseObject(response.getBody(), Map.class);
            if (responseMap.get("errcode").equals(0)) {
                String token = (String) responseMap.get("access_token");
                return token;
            } else {
                // 处理错误情况
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取企业微信token异常。");
            return null;
        }
    }
}
