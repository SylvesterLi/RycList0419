package com.wru.listtest.valueobject;

/**
 * Created by SANG-ASUS on 2018/4/19.
 */

public class MessageVO {
    public String name;
    public String message;
    public Boolean sended;

    public MessageVO(String name, String message, Boolean sended) {
        this.name = name;
        this.message = message;
        this.sended = sended;
    }
}
