package com.tang.app.message_push.service;

public interface PhoneMessagePush {

    void push(String[] tokens);

    boolean phoneType(String type);

}
