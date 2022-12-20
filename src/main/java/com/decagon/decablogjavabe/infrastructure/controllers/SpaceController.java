package com.decagon.decablogjavabe.infrastructure.controllers;

import com.decagon.decablogjavabe.domain.entities.SpaceEntity;
import com.decagon.decablogjavabe.usercase.payload.request.SpaceRequest;
import com.decagon.decablogjavabe.usercase.payload.response.SpaceResponse;
import com.decagon.decablogjavabe.usercase.services.SpaceService;
import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Controller
@RequestMapping("/api/v1/space")
public class SpaceController {
    private SpaceService spaceService;

    public SpaceController(SpaceService spaceService) {
        this.spaceService = spaceService;
    }

    @PostMapping("/create-space")
    public ResponseEntity<SpaceResponse> createSpace(@RequestParam("spaceRequest") String spaceRequestString, @RequestParam("file") MultipartFile image) throws IOException {
        SpaceRequest spaceRequest = new Gson().fromJson(spaceRequestString, SpaceRequest.class);
        SpaceResponse spaceRespond = spaceService.createSpace(spaceRequest, image);
        return new ResponseEntity<>(spaceRespond, CREATED);

    }
    @PatchMapping("/join/{id}")
    public ResponseEntity<SpaceEntity> joinSpace(@PathVariable ("id")Long id){
     SpaceEntity joinRespond = spaceService.joinSpace(id);
     return  new ResponseEntity<>(joinRespond,OK);
    }

}
