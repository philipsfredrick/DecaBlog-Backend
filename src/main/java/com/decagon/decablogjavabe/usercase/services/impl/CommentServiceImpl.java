package com.decagon.decablogjavabe.usercase.services.impl;

import com.decagon.decablogjavabe.domain.dao.*;
import com.decagon.decablogjavabe.domain.entities.*;
import com.decagon.decablogjavabe.infrastructure.configuration.security.UserDetails;
import com.decagon.decablogjavabe.usercase.payload.request.CommentRequest;
import com.decagon.decablogjavabe.usercase.payload.response.MakeCommentResponse;
import com.decagon.decablogjavabe.usercase.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final ArticleDao articleDao;
    private final CommentDao commentDao;

    private final DecadevsDao decadevsDao;
    private final AdminDao adminDao;
    private  final AppUserDao appUserDao;


    @Override
    public List<CommentEntity> getAllComments() {
        return commentDao.getAllRecords();

    }

    @Override
    public MakeCommentResponse makeComment(CommentRequest request){
        String userEmail = UserDetails.getLoggedInUserDetails();
        AppUserEntity appUser = appUserDao.findAppUserEntityByEmail(userEmail);
        ArticleEntity articleEntity = articleDao.getRecordById(request.getArticleId());
        AdminEntity adminEntity;
        CommentEntity commentEntity = CommentEntity.builder()
                .comment(request.getComment())
                .postEntity(articleEntity)
                .build();
        if (adminDao.findById(appUser.getId()).isPresent()){
            adminEntity = adminDao.getByAppUser(appUser);
            commentEntity.setAdminEntity(adminEntity);
            return new MakeCommentResponse(articleEntity.getId(), request.getComment(), adminEntity.getId(), LocalDateTime.now());
        }
        else {
            DecadevsEntity decadevsEntity = decadevsDao.getByAppUser(appUser);
            commentEntity.setDecadevsEntity(decadevsEntity);
            commentDao.saveRecord(commentEntity);
            return new MakeCommentResponse(articleEntity.getId(), request.getComment(), decadevsEntity.getId(), LocalDateTime.now());
        }
    }
}
