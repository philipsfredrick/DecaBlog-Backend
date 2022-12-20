package com.decagon.decablogjavabe.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "admin" )
public class AdminEntity extends AbstractEntity{

    @Column(nullable = false)
    private String name;

    private String phoneNumber;

    private String about;

    private String displayPicture;

    @ManyToOne
    @JsonBackReference
    private AppUserEntity appUserEntity;

    @JsonManagedReference
    @OneToMany(mappedBy = "adminEntity")
    private List<ArticleEntity> articleEntityList = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "adminEntity")
    private List<CommentEntity> commentEntityList = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "adminEntity")
    private List<LikeEntity> likeEntityList = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "adminEntity")
    private List<SpaceEntity> spaceEntityList = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "adminEntity")
    private List<AskQuestionEntity> askQuestionEntityList= new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "adminEntity")
    private List<NotificationEntity> notificationEntityList = new ArrayList<>();
}
