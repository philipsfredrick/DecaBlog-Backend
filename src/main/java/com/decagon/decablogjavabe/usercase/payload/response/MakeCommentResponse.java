package com.decagon.decablogjavabe.usercase.payload.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MakeCommentResponse {
    private Long articleId;
    private String comment;
    private Long appUserId;
    @JsonFormat(pattern = "dd-MMM-yyyy HH:mm a")
    private LocalDateTime createdAt;
}
