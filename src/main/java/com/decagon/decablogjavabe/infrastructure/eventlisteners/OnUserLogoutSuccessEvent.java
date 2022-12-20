package com.decagon.decablogjavabe.infrastructure.eventlisteners;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.io.Serial;
import java.time.Instant;
import java.util.Date;

@Getter
@Setter
public class OnUserLogoutSuccessEvent extends ApplicationEvent {


    private static final long serialVersionUID = 1L;
    private final String userEmail;
    private final String token;
    private final Date eventTime;


    public OnUserLogoutSuccessEvent(String userEmail, String token) {
        super(userEmail);
        this.userEmail = userEmail;
        this.token = token;
        this.eventTime = Date.from(Instant.now());
    }
}
