package com.decagon.decablogjavabe.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "notification")

public class NotificationEntity extends AbstractEntity {

    @Column(
            name = "message",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String message;



    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private AdminEntity adminEntity;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "decadevs_entity_id")
    private DecadevsEntity decadevsEntity;

}

