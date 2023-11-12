package com.parakramaba.springbootsecurity.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, length = 254, unique = true)
    private String userName;

    @Column(nullable = false, length = 254)
    private String password;

    // TODO: find a way to solve issue of null-insert or override with event
//    @Generated(event = EventType.INSERT)
    @Column(columnDefinition = "boolean not null default true")
    private Boolean isActive =  Boolean.TRUE;

    @Column(length = 254, nullable = false)
    // FIXME: Will be needed in future iterations
//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable(
//            name = "user_role",
//            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
//    )
//    @JsonIgnoreProperties("users")
//    private List<Role> roles;
    @Enumerated(value = EnumType.STRING)
    private Role role;

}
