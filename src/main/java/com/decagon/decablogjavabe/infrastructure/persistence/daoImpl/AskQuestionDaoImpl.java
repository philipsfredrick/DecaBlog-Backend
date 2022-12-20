package com.decagon.decablogjavabe.infrastructure.persistence.daoImpl;
import com.decagon.decablogjavabe.domain.dao.AskQuestionDao;
import com.decagon.decablogjavabe.domain.entities.AskQuestionEntity;
import com.decagon.decablogjavabe.infrastructure.persistence.repository.AskQuestionRepository;
import org.springframework.stereotype.Service;

@Service
public class AskQuestionDaoImpl extends CrudDaoImpl<AskQuestionEntity, Long> implements AskQuestionDao {
private final AskQuestionRepository askQuestionRepository;

    public AskQuestionDaoImpl(AskQuestionRepository askQuestionRepository) {
        super(askQuestionRepository);
        this.askQuestionRepository = askQuestionRepository;
    }
}
