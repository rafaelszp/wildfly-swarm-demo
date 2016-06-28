package com.example.dao;

import java.util.List;

/**
 * Created by rafael on 6/27/16.
 */
public abstract class DAO<E> {

    public abstract List<E> findAll();
}
