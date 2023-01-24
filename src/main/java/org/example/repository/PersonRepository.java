package org.example.repository;

import org.example.model.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonRepository {

    //create table
    void createTable() throws SQLException;
    //save
    void save(Person person) throws SQLException;
    //find all
    List<Person> findAll() throws SQLException;
    //get by id
    Person getById(Long id) throws SQLException;
    //delete by id
    void deleteById(Long id) throws SQLException;
    //delete all
    void deleteAll() throws SQLException;
    //update object by id
    void update(Long id,Person newPerson) throws SQLException;
}
