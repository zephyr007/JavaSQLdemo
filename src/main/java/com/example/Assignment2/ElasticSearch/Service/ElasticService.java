package com.example.Assignment2.ElasticSearch.Service;

import com.example.Assignment2.ElasticSearch.Model.ElasticModel;
import com.example.Assignment2.ElasticSearch.Repository.ElasticRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElasticService {

    @Autowired
    ElasticRepo elasticRepo;


    public Iterable<ElasticModel> findAll() {
        return elasticRepo.findAll();
    }

    public Iterable<ElasticModel> findAllBytype(String type) {
        return elasticRepo.findAllBytype(type);
    }

    public void save(ElasticModel elasticModel) {
        elasticRepo.save(elasticModel);
    }
}
