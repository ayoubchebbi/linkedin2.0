package com.tn.isamm.linkedin.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="relationship" ,catalog="linkedin2")
public class Relationship implements java.io.Serializable {
    private Integer id;
    private Integer user_one_id;
    private Integer user_two_id;
    private String status;
    private Integer action_user_id;

    public Relationship() {
    }

    public Relationship(Integer user_one_id, Integer user_two_id, String status, Integer action_user_id) {
        this.user_one_id = user_one_id;
        this.user_two_id = user_two_id;
        this.status = status;
        this.action_user_id = action_user_id;
    }

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_one_id() {
        return user_one_id;
    }

    public void setUser_one_id(Integer user_one_id) {
        this.user_one_id = user_one_id;
    }

    public Integer getUser_two_id() {
        return user_two_id;
    }

    public void setUser_two_id(Integer user_two_id) {
        this.user_two_id = user_two_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAction_user_id() {
        return action_user_id;
    }

    public void setAction_user_id(Integer action_user_id) {
        this.action_user_id = action_user_id;
    }
}
