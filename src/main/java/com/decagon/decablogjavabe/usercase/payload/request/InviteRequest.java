package com.decagon.decablogjavabe.usercase.payload.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
@Data
@RequiredArgsConstructor
public class InviteRequest {
    List<Long> ids;
}
