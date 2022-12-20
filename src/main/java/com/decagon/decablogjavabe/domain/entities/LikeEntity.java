package com.decagon.decablogjavabe.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "likes")
public class LikeEntity extends AbstractEntity{

    private boolean liked;

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
    @JoinColumn(name = "spaceid", referencedColumnName = "id")
    private SpaceEntity spaceEntity;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "commment_id", referencedColumnName = "id")
    private CommentEntity commentEntity;

}
