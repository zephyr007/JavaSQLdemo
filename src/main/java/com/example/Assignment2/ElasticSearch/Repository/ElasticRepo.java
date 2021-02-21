package com.example.Assignment2.ElasticSearch.Repository;

import com.example.Assignment2.ElasticSearch.Model.ElasticModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ElasticRepo extends ElasticsearchRepository<ElasticModel, Integer> {

    Iterable<ElasticModel> findAllBytype(String type);
}
