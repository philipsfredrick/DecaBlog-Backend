package com.decagon.decablogjavabe.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "space")
public class SpaceEntity extends AbstractEntity{
    private String title;
    private String description;
    private String image;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "decadev_id", referencedColumnName = "id")
    private DecadevsEntity decadevsEntity;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private AdminEntity adminEntity;

    @JsonManagedReference
    @OneToMany(mappedBy = "spaceEntity")
    private List<CommentEntity> commentEntityList = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "spaceEntity")
    private List<LikeEntity> likeEntityList = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "spaceEntity")
    private List<AppUserEntity> appUsers = new ArrayList<>();

}
