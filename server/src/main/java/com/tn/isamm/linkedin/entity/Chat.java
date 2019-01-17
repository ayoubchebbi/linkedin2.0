package com.tn.isamm.linkedin.entity;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="chat" ,catalog="linkedin2")

public class Chat implements java.io.Serializable {

    private Integer chatId;
    private Integer user_from_id;
    private Integer user_to_id;
    private String message;
    private Date send_on;

    public Chat() {
    }

    public Chat(Integer chatId, Integer user_from_id, Integer user_to_id, String message, Date date) {
        this.chatId = chatId;
        this.user_from_id = user_from_id;
        this.user_to_id = user_to_id;
        this.message = message;
        this.send_on = date;
    }

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="chatId", unique=true, nullable=false)
    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public Integer getUser_from_id() {
        return user_from_id;
    }

    public void setUser_from_id(Integer user_from_id) {
        this.user_from_id = user_from_id;
    }

    public Integer getUser_to_id() {
        return user_to_id;
    }

    public void setUser_to_id(Integer user_to_id) {
        this.user_to_id = user_to_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return send_on;
    }

    public void setDate(Date date) {
        this.send_on = date;
    }
}
