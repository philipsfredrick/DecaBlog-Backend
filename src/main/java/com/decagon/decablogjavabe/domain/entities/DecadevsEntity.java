package com.decagon.decablogjavabe.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "decadevs")
public class DecadevsEntity extends AbstractEntity{

    @Column(nullable = false,columnDefinition = "VARCHAR(250)")
    private String name;

    @Column( columnDefinition = "VARCHAR(250)")
    private String phoneNumber;

    @Column( columnDefinition = "VARCHAR(250)")
    private String about;
    @Column( columnDefinition = "VARCHAR(250)")
    private String displayPicture;

    @Column(name = "_current_role", columnDefinition = "VARCHAR(250)")
    private String currentRole;

    @Column( columnDefinition = "VARCHAR(250)")
    private String companyName;

    @Column( columnDefinition = "VARCHAR(250)")
    private String residence;

    @JsonBackReference
    @ManyToOne
    private AppUserEntity appUserEntity;

    @JsonManagedReference
    @OneToMany(mappedBy = "decadevsEntity")
    private List<ArticleEntity> articleEntityList = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "decadevsEntity")
    private List<CommentEntity> commentEntities = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "decadevsEntity")
    private List<LikeEntity> likeEntityList = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "decadevsEntity")
    private List<SpaceEntity> spaceEntityList = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "decadevsEntity")
    private List<AskQuestionEntity> askQuestionEntityList= new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "decadevsEntity")
    private List<NotificationEntity> notificationEntityList = new ArrayList<>();

}
