package com.example.Assignment2.ElasticSearch.Controller;

import com.example.Assignment2.ElasticSearch.Model.ElasticModel;
import com.example.Assignment2.ElasticSearch.Repository.ElasticRepo;
import com.example.Assignment2.ElasticSearch.Service.ElasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.Optional;

@RestController
@RequestMapping("elasti")
public class ElasticController {

    @Autowired
    ElasticService elasticService;

    @PostMapping("/add")
    public String addElastic(@RequestBody ElasticModel elasticModel)
    {
        elasticService.save(elasticModel);
        return "Data added on Elastic";
    }

    @GetMapping("/getall")
    public Iterable<ElasticModel> getAll(){
        return elasticService.findAll();
    }

    @GetMapping("/getByType")
    public Iterable<ElasticModel> getByName(@RequestParam String type){
        return elasticService.findAllBytype(type);
    }


}
