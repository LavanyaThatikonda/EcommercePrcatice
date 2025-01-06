package com.example.EcommercePractice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategory {

    @Id
    private int id;
    private String name;
    private String description;
    private String createdBy;
    private String modifiedBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationTime;


    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationTime;

    @PrePersist
    protected void onCreate() {
        creationTime = new Date();
        modificationTime = creationTime;
    }

    @PreUpdate
    protected void onUpdate() {
        modificationTime = new Date();
    }

}
