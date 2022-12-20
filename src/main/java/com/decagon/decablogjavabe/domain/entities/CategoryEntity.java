package com.decagon.decablogjavabe.domain.entities;

import com.decagon.decablogjavabe.domain.entities.ArticleEntity;
import com.decagon.decablogjavabe.domain.entities.enums.Category;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class CategoryEntity extends AbstractEntity{

    @OneToMany
    @JsonManagedReference
    @JoinColumn(name = "article_id", referencedColumnName = "id")
    private List<ArticleEntity> articleEntity;

    @Enumerated(EnumType.STRING)
    private Category category;
}
