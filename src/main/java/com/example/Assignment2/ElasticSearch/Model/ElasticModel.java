package com.example.Assignment2.ElasticSearch.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Document(indexName = "my-application",indexStoreType = "ElasticModel",shards=2)
public class ElasticModel {
    public String EventName;
    @Id
    public Integer id;
    public String type;
    public String message;

}
