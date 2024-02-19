package com.liucg.reporthandle.sys.controller;
import com.liucg.reporthandle.sys.entity.WeChatMessage;
import com.liucg.reporthandle.sys.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 企业微信发送信息
 */
@RestController
@RequestMapping("/sys")
public class WeChatController {

    @Autowired
    private WeChatService weChatService;

    @PostMapping("/sendWeChatMessage")
    public String sendWeChatMessage(WeChatMessage message) {
        weChatService.sendWeChatMessage(message);
        return "消息已发送";
    }
}
