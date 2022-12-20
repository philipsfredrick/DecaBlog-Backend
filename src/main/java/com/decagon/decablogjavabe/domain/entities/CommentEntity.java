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
@Entity(name = "comment")
public class CommentEntity extends AbstractEntity{

    private String comment;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private ArticleEntity postEntity;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "decadev_id", referencedColumnName = "id")
    private DecadevsEntity decadevsEntity;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private AdminEntity adminEntity;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private AskQuestionEntity askQuestionEntity;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "space_id", referencedColumnName = "id")
    private SpaceEntity spaceEntity;

    @JsonManagedReference
    @OneToMany(mappedBy = "commentEntity")
    private List<LikeEntity> likeEntityList = new ArrayList<>();


}
