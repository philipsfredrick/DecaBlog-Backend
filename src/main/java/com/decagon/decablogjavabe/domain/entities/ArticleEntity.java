package com.decagon.decablogjavabe.domain.entities;

import com.decagon.decablogjavabe.domain.entities.enums.Category;
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
@Entity(name = "post")
public class ArticleEntity extends AbstractEntity{

    private String title;
    private String picture;
    private String author;
    private String postContent;

    @Enumerated(EnumType.STRING)
    private Category category;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "decadev_id", referencedColumnName = "id")
    private DecadevsEntity decadevsEntity;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private AdminEntity adminEntity;

    @JsonManagedReference
    @OneToMany(mappedBy = "postEntity")
    private List<CommentEntity> commentEntities = new ArrayList<>();

    @JsonBackReference
    @OneToMany(mappedBy = "postEntity")
    private List<LikeEntity> likeEntityList = new ArrayList<>();

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private CategoryEntity categoryEntity;

}
