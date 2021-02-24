package com.example.Assignment2.Elastic.Repo;

import com.example.Assignment2.Elastic.Model.TransElastic;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElasticSearchRepo extends ElasticsearchRepository<TransElastic,Integer> {

    TransElastic findAllBypayer(long payer);
    Iterable<TransElastic> findAllBypayee(long payee);

}
