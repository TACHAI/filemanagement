package com.chaoxing.filemanagement.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * @ClassName ResponseCode
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2019-06-05 16:06
 **/
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> implements Serializable {
    private int status;
    private String msg;
    private T data;
    private String link;

    private ServerResponse(int status){
        this.status=status;
    }
    private ServerResponse(String link){
        this.link=link;
    }

    private ServerResponse(int status,T data){
        this.status=status;
        this.data=data;
    }
    private ServerResponse(int status,T data,String msg){
        this.status=status;
        this.data=data;
        this.msg=msg;
    }

    private ServerResponse(int status,String msg){
        this.status=status;
        this.msg=msg;
    }

    private ServerResponse(int status,T data,String msg,String link){
        this.status=status;
        this.data=data;
        this.msg=msg;
        this.link=link;
    }
    public int getStatus(){
        return status;
    }

    public String getLink() {
        return link;
    }

    public String getMsg(){
        return msg;
    }
    public T getData(){
        return data;
    }

    @JsonIgnore
    public boolean isSuccess(){return this.status== ResponseCode.SUCCESS.getCode();}

    public static <T>ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T>ServerResponse<T> createBySuccessMessage(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }

    public static <T>ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }

    public static <T>ServerResponse<T>createBySuccess(T data,String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data,msg);
    }

    public static <T> ServerResponse<T> createByError() {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
    }

    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage) {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), errorMessage);
    }

    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode, String errorMessage) {
        return new ServerResponse<T>(errorCode, errorMessage);
    }

    public static <T>ServerResponse<T>uploadBySuccess(T data,String msg,String link){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data,msg,link);
    }

    public static <T>ServerResponse<T>uploadBySuccess(String link){
        return new ServerResponse<T>(link);
    }
}
