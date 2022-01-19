package com.example.springbootelasticsearch.repository;

import com.example.springbootelasticsearch.model.Person;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends ElasticsearchRepository<Person, String> {

//    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
//    List<Person> getByCustomQuery(String search);

    List<Person> findByNameContaining(String name);

    List<Person> findByNameLikeOrLastName(String name, String lastName);
}
