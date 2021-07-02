package com.foxconn.license.entity;



import javax.persistence.*;

@Entity
@Table(name = "license")
public class License extends PersistableImpl{

    @Id
    private String token;
    private int payId;
    private long exp;
    protected License() {

    }

    public License(String token, int payId, long exp) {
        this.token = token;
        this.payId = payId;
        this.exp = exp;
    }
}
