package com.decagon.decablogjavabe.infrastructure.persistence.daoImpl;

import com.decagon.decablogjavabe.domain.dao.CommentDao;
import com.decagon.decablogjavabe.domain.entities.CommentEntity;
import com.decagon.decablogjavabe.infrastructure.persistence.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentDaoImpl extends CrudDaoImpl<CommentEntity, Long> implements CommentDao {

    private final CommentRepository commentRepository;

    public CommentDaoImpl(CommentRepository commentRepository) {
        super(commentRepository);
        this.commentRepository = commentRepository;
    }
}
