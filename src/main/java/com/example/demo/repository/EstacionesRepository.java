package com.example.demo.repository;

import com.example.demo.model.Estaciones;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstacionesRepository extends MongoRepository<Estaciones, Integer> {
}
