package com.liucg.reporthandle.sys.entity;

import lombok.Data;

/**
 * 企业微信发送消息的信息主体
 */
//@Entity
//@Table(name = "wechat_messages")
@Data
public class WeChatMessage {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

//    @Column(name = "to_user")
    private String toUser; // 接收信息的用户工号

//    @Column(name = "content")
    private String content; // 消息内容

    // 省略构造函数、getter和setter方法
}
