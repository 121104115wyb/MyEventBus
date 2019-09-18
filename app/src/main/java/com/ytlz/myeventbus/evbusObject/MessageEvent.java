package com.ytlz.myeventbus.evbusObject;

/**
 * Created by wyb on 2019-09-17.
 */

public class MessageEvent {

    public String Message;
    //json;string
    public String type;


    public static MessageEvent ceratMesEvent(String message) {
        return new MessageEvent(message);
    }


    public MessageEvent(String message) {
        Message = message;
    }


    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
