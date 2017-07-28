package com.lxs.mj;

import org.bson.types.ObjectId;

import java.util.Date;

/**
 * @author 刘馨思
 */
public class TestObject {
    private ObjectId _id;
    private String str;
    private Integer inte;
    private Date date;
    private Long lon;
    private Boolean bool;
    private String[] strs;
    private Integer[] intes;
    private byte[] bytes;
    private Byte b;
    private EmbeddedObject embeddedObject;

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Integer getInte() {
        return inte;
    }

    public void setInte(Integer inte) {
        this.inte = inte;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getLon() {
        return lon;
    }

    public void setLon(Long lon) {
        this.lon = lon;
    }

    public Boolean getBool() {
        return bool;
    }

    public void setBool(Boolean bool) {
        this.bool = bool;
    }

    public String[] getStrs() {
        return strs;
    }

    public void setStrs(String[] strs) {
        this.strs = strs;
    }

    public Integer[] getIntes() {
        return intes;
    }

    public void setIntes(Integer[] intes) {
        this.intes = intes;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public Byte getB() {
        return b;
    }

    public void setB(Byte b) {
        this.b = b;
    }

    public EmbeddedObject getEmbeddedObject() {
        return embeddedObject;
    }

    public void setEmbeddedObject(EmbeddedObject embeddedObject) {
        this.embeddedObject = embeddedObject;
    }
}
