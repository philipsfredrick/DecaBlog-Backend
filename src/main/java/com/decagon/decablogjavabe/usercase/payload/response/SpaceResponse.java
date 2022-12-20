package com.decagon.decablogjavabe.usercase.payload.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpaceResponse<T> {

        private String message;
        private  Boolean success;
        @JsonFormat(pattern = "yyyy-MM--dd HH-mm")
        private LocalDateTime createdAt;
        private T payload;


}
