package com.decagon.decablogjavabe.utils;

import com.decagon.decablogjavabe.domain.entities.AdminEntity;
import com.decagon.decablogjavabe.domain.entities.DecadevsEntity;
import com.decagon.decablogjavabe.usercase.payload.response.RegistrationResponse;
import org.springframework.stereotype.Service;

@Service
public class PayLoadMapper {
    public RegistrationResponse decadevEntityMapper(DecadevsEntity decadev) {
        RegistrationResponse decadev1 = new RegistrationResponse();

        if (decadev.getName() != null) {
            decadev1.setName(decadev.getName());
        }
        if (decadev.getAppUserEntity().getEmail() != null) {
            decadev1.setEmail((decadev.getAppUserEntity().getEmail()));
        }
        if (decadev.getId() != null) {
            decadev1.setId(decadev.getId());
        }
        return decadev1;
    }

    public RegistrationResponse adminEntityMapper(AdminEntity admin) {
        RegistrationResponse admin1 = new RegistrationResponse();

        if (admin.getName() != null) {
            admin1.setName(admin.getName());
        }
        if (admin.getAppUserEntity().getEmail() != null) {
            admin1.setEmail((admin.getAppUserEntity().getEmail()));
        }
        if (admin.getId() != null) {
            admin1.setId(admin.getId());
        }
        return admin1;
    }
}