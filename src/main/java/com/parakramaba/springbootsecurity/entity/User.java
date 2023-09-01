package com.parakramaba.springbootsecurity.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.io.Serializable;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false, length = 254)
    private String userName;

    @Column(nullable = false, length = 254)
    private String password;

    // TODO: need to find a way to solve issue of null-insert or override with event
//    @Generated(event = EventType.INSERT)
    @Column(columnDefinition = "boolean not null default true")
    private Boolean isActive =  Boolean.TRUE;

    @ColumnDefault("'ROLE_USER'")
    @Column(length = 254, nullable = false)
    private String roles;

}
