package com.nf.lc.dto;


public class Result {
    //状态码  1203：错误编码  1224：正确编码，有数据返回 1028：正确编码，没有数据返回
    private int code;
    //消息提示
    private String message;
    //数据
    private Object data;


    //正常返回，携带信息
    public static Result successMessage(String message){
        return new Result(1028,message,null);
    }

    //正常返回，携带数据
    public static Result success(Object data) {
        return new Result(1224, "success", data);
    }

    //正常返回,携带信息和数据
    public static Result success(String message, Object data) {
        return new Result(1224, message, data);
    }

    //错误返回，携带信息
    public static Result error(String message) {
        return new Result(1203, message, null);
    }

    private Result() {

    }

    private Result(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    private Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
