package com.decagon.decablogjavabe.usercase.services.impl;

import com.decagon.decablogjavabe.domain.dao.DecadevsDao;
import com.decagon.decablogjavabe.usercase.services.DecadevsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DecadevsServiceImpl implements DecadevsService {

    private final DecadevsDao decadevsDao;


}
