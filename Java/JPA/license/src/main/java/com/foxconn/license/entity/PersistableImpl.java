package com.foxconn.license.entity;

import org.springframework.data.domain.Persistable;

import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

public class PersistableImpl implements Persistable {
    @Transient
    private boolean isNew = true;
    @Override
    public Object getId() {
        return null;
    }
    @Override
    public boolean isNew() {
        return isNew;
    }
    @PrePersist
    @PostLoad
    void markNotNew() {
        this.isNew = false;
    }
}
