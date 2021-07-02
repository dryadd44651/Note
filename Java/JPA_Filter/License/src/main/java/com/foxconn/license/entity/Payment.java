package com.foxconn.license.entity;

import javax.persistence.*;

@Entity
@Table(name = "payments")
public class Payment  extends PersistableImpl{
    @Id
    private Long id;
    private Long price;
    private String username;
    private String token;
    private Long exp;
    private String uuid;
    private boolean paid;



    protected Payment() {

    }
}
