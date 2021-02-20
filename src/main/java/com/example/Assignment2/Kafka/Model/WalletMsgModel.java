package com.example.Assignment2.Kafka.Model;

public class WalletMsgModel {
    public Integer PhoneNo;
    public String eventType;
    public String message;

    public WalletMsgModel(Integer phoneNo, String eventType, String message) {
        PhoneNo = phoneNo;
        this.eventType = eventType;
        this.message = message;
    }

    public WalletMsgModel(Integer phoneNo, String eventType) {
        PhoneNo = phoneNo;
        this.eventType = eventType;
    }

    public String getMessage() {
        return message;
    }

    public Integer getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(Integer phoneNo) {
        PhoneNo = phoneNo;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}
