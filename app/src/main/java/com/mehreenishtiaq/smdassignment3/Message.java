package com.mehreenishtiaq.smdassignment3;

public class Message {

    private String senderId;
    private String type;
    private String content;
    private long timestamp;

    public Message() {
    }

    public Message(String senderId, String type, String content, long timestamp) {
        this.senderId = senderId;
        this.type = type;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
