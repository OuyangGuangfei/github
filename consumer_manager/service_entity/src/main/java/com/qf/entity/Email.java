package com.qf.entity;

import java.util.Date;

public class Email {
  private String  to;
  private String subject;
  private String text;
  private Date time;

    public Email(String to, String subject, String text, Date time) {
        this.to = to;
        this.subject = subject;
        this.text = text;
        this.time = time;
    }

    public Email() {
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
