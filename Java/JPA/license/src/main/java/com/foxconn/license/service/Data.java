package com.foxconn.license.service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.Entity;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;


@Entity
public class Data {
    private License license = new License();
    private int sDevNum = 0,year = 0,month = 0,day = 0,second = 0;
    public String sMac,user;
    private HashMap hm = new HashMap();
    public UUID uuid;
    private SecretKey key = new SecretKeySpec("fy6RBaOK9sRj7vXiw7aKxCPMhNikbPRO+5LcAsPhwic=".getBytes(), "HmacSHA256");
    public String jwt;
    public Date exp;
    public int price;

    public Data(String user, int sDevNum, String sMac, int year, int month, int day, int second, int price) {
        super();
        this.user=user;
        this.sDevNum = sDevNum;
        this.year = year;
        this.month = month;
        this.day = day;
        this.second = second;
        this.sMac = sMac;
        this.uuid = UUID.randomUUID();
        this.price = price;

        hm.put("sMac", this.sMac);
        hm.put("sDevNum", this.sDevNum);
        hm.put("price", this.price);
        hm.put("user", this.user);
        hm.put("UUID", this.uuid);
        this.exp = license.GetExpDate(this.year,this.month,this.day,this.second);
        jwt = license.GetToken(this.exp,hm,key);

    }

    public void setUser(String user) {
        this.user = user;
        hm.put("User", this.user);
        jwt = license.GetToken(this.exp,hm,key);
    }

}
