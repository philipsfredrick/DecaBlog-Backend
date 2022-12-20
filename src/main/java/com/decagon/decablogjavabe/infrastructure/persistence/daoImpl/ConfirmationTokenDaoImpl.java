package com.decagon.decablogjavabe.infrastructure.persistence.daoImpl;

import com.decagon.decablogjavabe.domain.dao.ConfirmationTokenDao;
import com.decagon.decablogjavabe.domain.entities.email.ConfirmationTokenEntity;
import com.decagon.decablogjavabe.infrastructure.persistence.repository.ConfirmationTokenRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ConfirmationTokenDaoImpl extends CrudDaoImpl<ConfirmationTokenEntity, Long> implements ConfirmationTokenDao {
    private final ConfirmationTokenRepository confirmationTokenRepository;

    protected ConfirmationTokenDaoImpl(ConfirmationTokenRepository confirmationTokenRepository) {
        super(confirmationTokenRepository);
        this.confirmationTokenRepository = confirmationTokenRepository;
    }

    @Override
    public int updateConfirmedAt(String token, LocalDateTime now) {
        return confirmationTokenRepository.updateConfirmedAt(token,now);
    }

    @Override
    public ConfirmationTokenEntity findByToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }
}
