package com.htc.model;
/*
 * 授权实体层
 */
public class GrantedTb {
    private Integer id;

    private String oUserId;

    private String aUserId;

    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getoUserId() {
        return oUserId;
    }

    public void setoUserId(String oUserId) {
        this.oUserId = oUserId == null ? null : oUserId.trim();
    }

    public String getaUserId() {
        return aUserId;
    }

    public void setaUserId(String aUserId) {
        this.aUserId = aUserId == null ? null : aUserId.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}