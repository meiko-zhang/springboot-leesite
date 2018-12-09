package com.meiko.leesite.demo.exception;

import com.baomidou.mybatisplus.extension.api.IErrorCode;

/**
 * <p>
 * 错误编码 枚举类
 * 参考:com.baomidou.mybatisplus.extension.enums.ApiErrorCode
 * </p>
 *
 * @author meiko-zahng
 * @since 2018-12-08
 */
public enum ErrorCode implements IErrorCode {
    TEST(1000, "测试错误编码");

    private long code;
    private String msg;

    ErrorCode(final long code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
