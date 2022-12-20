package com.decagon.decablogjavabe.domain.entities;

import com.decagon.decablogjavabe.domain.entities.enums.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "app_user")
public class AppUserEntity extends AbstractEntity{

    @Column(unique = true,nullable = false,columnDefinition = "VARCHAR(100)")
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonManagedReference
    @OneToMany(mappedBy = "appUserEntity")
    private List<DecadevsEntity> decadevsEntityList;

    @JsonManagedReference
    @OneToMany(mappedBy = "appUserEntity")
    private List<AdminEntity> adminEntities;

    @JsonBackReference
    @ManyToOne
    private SpaceEntity spaceEntity;
}
