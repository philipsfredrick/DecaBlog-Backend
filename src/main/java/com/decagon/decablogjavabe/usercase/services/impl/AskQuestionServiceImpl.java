package com.decagon.decablogjavabe.usercase.services.impl;

import com.decagon.decablogjavabe.domain.entities.AppUserEntity;
import com.decagon.decablogjavabe.domain.entities.AskQuestionEntity;
import com.decagon.decablogjavabe.domain.entities.DecadevsEntity;
import com.decagon.decablogjavabe.infrastructure.configuration.security.UserDetails;
import com.decagon.decablogjavabe.infrastructure.error_handler.AppUserNotFoundException;
import com.decagon.decablogjavabe.infrastructure.persistence.daoImpl.AppUserDaoImpl;
import com.decagon.decablogjavabe.infrastructure.persistence.daoImpl.AskQuestionDaoImpl;
import com.decagon.decablogjavabe.infrastructure.persistence.daoImpl.DecadevDaoImpl;
import com.decagon.decablogjavabe.infrastructure.persistence.repository.AskQuestionRepository;
import com.decagon.decablogjavabe.infrastructure.persistence.repository.DecadevsRepository;
import com.decagon.decablogjavabe.usercase.payload.request.AskQuestionRequest;
import com.decagon.decablogjavabe.usercase.services.AskQuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AskQuestionServiceImpl implements AskQuestionService {
    private final AskQuestionDaoImpl askQuestionDao;
    private final DecadevDaoImpl decadevDao;
    private final AppUserDaoImpl appUserDao;

    public AskQuestionServiceImpl( AskQuestionDaoImpl askQuestionDao, DecadevDaoImpl decadevDao, AppUserDaoImpl appUserDao) {
        this.askQuestionDao = askQuestionDao;
        this.decadevDao = decadevDao;
        this.appUserDao = appUserDao;

    }

    @Override
    public AskQuestionEntity askQuestion(AskQuestionRequest askQuestionRequest) {
        String userEmail = UserDetails.getLoggedInUserDetails();
        AppUserEntity appUser = appUserDao.findAppUserEntityByEmail(userEmail);
        DecadevsEntity decadevsEntity = decadevDao.getByAppUser(appUser);
        ModelMapper modelMapper = new ModelMapper();
        AskQuestionEntity askQuestionEntity = modelMapper.map(askQuestionRequest,AskQuestionEntity.class);
        askQuestionEntity.setDecadevsEntity(decadevsEntity);
        return askQuestionDao.saveRecord(askQuestionEntity);

    }
}
