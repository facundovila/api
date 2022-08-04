package com.example.demo.service;

import com.example.demo.repository.EstacionesRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EstacionesService {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Autowired
    private EstacionesRepository estacionesRepository;


    private Logger logger =  LoggerFactory.getLogger(EstacionesService.class);



}
