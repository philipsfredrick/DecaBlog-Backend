package com.decagon.decablogjavabe.usercase.services;


import com.decagon.decablogjavabe.domain.entities.DecadevsEntity;
import com.decagon.decablogjavabe.domain.entities.SpaceEntity;
import com.decagon.decablogjavabe.usercase.payload.request.InviteRequest;
import com.decagon.decablogjavabe.usercase.payload.request.SpaceRequest;
import com.decagon.decablogjavabe.usercase.payload.response.SpaceResponse;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface SpaceService {
   SpaceResponse createSpace(SpaceRequest spaceRequest, MultipartFile image) throws IOException;

   SpaceEntity inviteToSpace(Long id, Long userId);

    SpaceEntity joinSpace(Long spaceId);
}
