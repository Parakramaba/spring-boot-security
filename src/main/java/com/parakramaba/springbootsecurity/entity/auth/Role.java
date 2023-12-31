package com.parakramaba.springbootsecurity.entity.auth;

import com.parakramaba.springbootsecurity.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "role")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false, length = 254)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;


}
