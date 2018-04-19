package com.wru.ryclist0419.ValueObject;

/**
 * Created by SANG-ASUS on 2018/4/19.
 */

public class MessageValueObject {
    //定义三个值
    public String Name;
    public String Message;
    public boolean IsSent;

    //构造函数 重写
    public MessageValueObject(String name,String message,boolean isSent)
    {
        //简化传值
        this.Name=name;
        this.Message=message;
        this.IsSent=isSent;
    }

}
