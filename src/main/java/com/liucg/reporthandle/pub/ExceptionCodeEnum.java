package com.liucg.reporthandle.pub;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @ClassName ExceptionCodeEnum 常用的异常类型定义
 * @Author liucg
 * @Description 通用错误枚举（不同类型的错误也可以拆成不同的Enum细分）
 */
@Getter
public enum ExceptionCodeEnum {
    ERROR(-1, "网络错误"),//通用错误

    SUCCESS(100, "成功"),// 成功
    INVALID_TOKEN(200, "非法token"), // 非法的token
    ERROR_PARAM(20000, "参数错误"), // 参数校验错误
    EMPTY_PARAM(20001, "参数为空"), //参数为空错误
    ERROR_PARAM_LENGTH(20002, "参数长度错误"); // 参数长度错误

    private static final Map<Integer, ExceptionCodeEnum> ENUM_CACHE = new HashMap<>();

    static {
        for (ExceptionCodeEnum exceptionCodeEnum : ExceptionCodeEnum.values()) {
            ENUM_CACHE.put(exceptionCodeEnum.status, exceptionCodeEnum);
        }
    }

    private final Integer status; //异常代码
    private final String result; //异常结果描述
    ExceptionCodeEnum(Integer status, String result) {
        this.status = status;
        this.result = result;
    }
    public static String getResult(Integer code) {
        return Optional.ofNullable(ENUM_CACHE.get(code))
                .map(ExceptionCodeEnum::getResult)
                .orElseThrow(() -> new IllegalArgumentException("invalid exception code!"));
    }
}