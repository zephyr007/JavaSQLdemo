package com.example.Assignment2.Service;

import com.example.Assignment2.Models.Trans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface TransInterface extends CrudRepository<Trans, Integer> {
//    <SELF> org.assertj.core.api.AbstractOptionalAssert<SELF, Object> findById(Integer txnId);
}
