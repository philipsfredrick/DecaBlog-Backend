package com.decagon.decablogjavabe.infrastructure.persistence.daoImpl;

import com.decagon.decablogjavabe.domain.dao.LikeDao;
import com.decagon.decablogjavabe.domain.entities.LikeEntity;
import com.decagon.decablogjavabe.infrastructure.persistence.repository.LikeRepository;
import org.springframework.stereotype.Service;

@Service
public class LikeDaoImpl extends CrudDaoImpl<LikeEntity, Long> implements LikeDao {

    private final LikeRepository likeRepository;

    public LikeDaoImpl(LikeRepository likeRepository) {
        super(likeRepository);
        this.likeRepository = likeRepository;
    }

}
