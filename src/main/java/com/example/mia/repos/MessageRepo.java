package com.example.mia.repos;

import com.example.mia.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<Message, Long> {
    Message findByTag(String tag);
}
