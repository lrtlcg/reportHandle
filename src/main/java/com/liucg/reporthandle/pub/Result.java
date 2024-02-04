package com.liucg.reporthandle.pub;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Result 异常结果集返回结果封装成自定义json格式
 *  格式包括三部分：status 结果状态，result 结果消息描述，data 存放返回对象的
 * @Author liucg
 * @Description 一般返回实体
 */
@Data
@NoArgsConstructor
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -687690141206758604L;
    private Integer status; //状态代码
    private String result; //结果消息
    private T data; //返回的数据对象

    private Result(Integer status, String result, T data) {
        this.status = status;
        this.result = result;
        this.data = data;
    }

    private Result(Integer status, String result) {
        this.status = status;
        this.result = result;
        this.data = null;
    }

    /**
     * 带数据成功返回
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(ExceptionCodeEnum.SUCCESS.getStatus(), ExceptionCodeEnum.SUCCESS.getResult(), data);
    }

    /**
     * 不带数据成功返回
     *
     * @return
     */
    public static <T> Result<T> success() {
        return success(null);
    }

    /**
     * 通用错误返回，传入指定的错误枚举
     *
     * @param exceptionCodeEnum
     * @return
     */
    public static <T> Result<T> error(ExceptionCodeEnum exceptionCodeEnum) {
        return new Result<>(exceptionCodeEnum.getStatus(), exceptionCodeEnum.getResult());
    }

    /**
     * 通用错误返回，传入指定的错误枚举，但支持覆盖message
     *
     * @param exceptionCodeEnum
     * @param msg
     * @return
     */
    public static <T> Result<T> error(ExceptionCodeEnum exceptionCodeEnum, String msg) {
        return new Result<>(exceptionCodeEnum.getStatus(), msg);
    }

    /**
     * 通用错误返回，只传入message
     *
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(String msg) {
        return new Result<>(ExceptionCodeEnum.ERROR.getStatus(), msg);
    }
}