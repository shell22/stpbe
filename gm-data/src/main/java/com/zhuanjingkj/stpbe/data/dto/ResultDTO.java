package com.zhuanjingkj.stpbe.data.dto;

import com.alibaba.fastjson.annotation.JSONField;

public class ResultDTO<T extends BaseDTO> {
    @JSONField(name="code")
    protected int code;
    @JSONField(name="msg")
    protected String msg;
    @JSONField(name="data")
    protected T data;

    public ResultDTO() {
        code = 0;
        msg = "";
    }

    public ResultDTO(T data){
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BaseDTO getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T extends BaseDTO> ResultDTO<T> success(T data){
        return new ResultDTO<>(data);
    }
}
