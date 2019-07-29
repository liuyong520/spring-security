package com.styz.security.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.HashSet;

/**
 * <b>package:com.styz.security.core.entity</b>
 * <b>project(项目):security-extend</b>
 * <b>class(类)${CLASS_NAME}</b>
 * <b>creat date(创建时间):2019-07-09 21:46</b>
 * <b>author(作者):</b>xxydliuyss</br>
 * <b>note(备注)):</b>
 * If you want to change the file header,please modify zhe File and Code Templates.
 */
@Data
public class SimpleResponse {
    public static final String OK="0000";
    public static final String FAIL="1000";
    public static final String OTHERERROR = "9999";
    public static HashMap<String,String> statusMap = new HashMap<String, String>(32);
    static {
        statusMap.put(OK,"success");
        statusMap.put(FAIL,"fail");
        statusMap.put(OTHERERROR,"其他错误");
    }
    private String code;
    private String msg;
    private Object value;
    public SimpleResponse warper(String code){
        this.code = code;
       if(statusMap.containsKey(code)){

           this.msg = statusMap.get(code);
       }else {
           this.msg = "其他错误";
       }
       return this;
    }
    public SimpleResponse warper(String code,String msg){
        this.code = code;
        this.msg = msg;
        return this;
    }


    public ResponseEntity<SimpleResponse> toResponse(){
        ResponseEntity<SimpleResponse> responseEntity = new ResponseEntity<SimpleResponse>(this,HttpStatus.OK);
        return responseEntity;
    }

    public SimpleResponse(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
