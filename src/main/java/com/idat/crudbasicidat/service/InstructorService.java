package com.idat.crudbasicidat.service;

import java.util.Collection;

import com.idat.crudbasicidat.model.Instructor;


public interface InstructorService {

    public abstract void insert(Instructor instructor);
    public abstract void update(Instructor instructor);
    public abstract void delete(Integer id);
    public abstract Instructor findById(Integer id);
    public abstract Collection<Instructor> findAll(); 
    
}
