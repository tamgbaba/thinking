package com.tang.app.message_push.service.impl;

import com.tang.app.message_push.service.PhoneMessagePush;

public class HuaWePhoneMessagePush implements PhoneMessagePush {

    private final String phoneType = "HUAWEI";

    @Override
    public void push(String[] tokens) {

    }

    @Override
    public boolean phoneType(String type) {
        return this.phoneType.equals(type);
    }


    private String getAuthorization() {

        return "";
    }
}
