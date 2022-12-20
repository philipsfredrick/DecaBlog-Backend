package com.decagon.decablogjavabe.infrastructure.persistence.daoImpl;

import com.decagon.decablogjavabe.domain.dao.AdminDao;
import com.decagon.decablogjavabe.domain.entities.AdminEntity;
import com.decagon.decablogjavabe.domain.entities.AppUserEntity;
import com.decagon.decablogjavabe.infrastructure.persistence.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminDaoImpl extends CrudDaoImpl<AdminEntity, Long> implements AdminDao {

    private final AdminRepository adminRepository;


    public AdminDaoImpl(AdminRepository adminRepository) {
        super(adminRepository);
        this.adminRepository = adminRepository;
    }

    @Override
    public AdminEntity getByAppUser(AppUserEntity appUserEntity){
        return adminRepository.getByAppUserEntity(appUserEntity);
    }


}
