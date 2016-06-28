package com.example.dao;

import com.example.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafael on 6/27/16.
 */
public class PersonDAO extends DAO<Person>{
    @Override
    public List<Person> findAll() {
        return new ArrayList<>(10);
    }
}
