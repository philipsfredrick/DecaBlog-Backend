package com.decagon.decablogjavabe.infrastructure.persistence.daoImpl;

import com.decagon.decablogjavabe.domain.dao.DecadevsDao;
import com.decagon.decablogjavabe.domain.entities.AppUserEntity;
import com.decagon.decablogjavabe.domain.entities.DecadevsEntity;
import com.decagon.decablogjavabe.infrastructure.persistence.repository.DecadevsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DecadevDaoImpl extends CrudDaoImpl<DecadevsEntity, Long> implements DecadevsDao {

    private final DecadevsRepository decadevsRepository;

    public DecadevDaoImpl(DecadevsRepository decadevsRepository) {
        super(decadevsRepository);
        this.decadevsRepository = decadevsRepository;
    }


    @Override
    public DecadevsEntity getByAppUser(AppUserEntity appUserEntity) {
        return decadevsRepository.getByAppUserEntity(appUserEntity);
    }

    @Override
    public Optional<DecadevsEntity> findDecadevsEntityByPhoneNumber(String phoneNumber) {
        return decadevsRepository.findDecadevsEntityByPhoneNumber(phoneNumber);
    }
}
