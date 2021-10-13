package com.idat.crudbasicidat.service;

import java.util.Collection;

import com.idat.crudbasicidat.model.Instructor;
import com.idat.crudbasicidat.repository.InstructorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorServiceImpl implements InstructorService{

    @Autowired // inyección de dependencia aútomatica 
    InstructorRepository repository; //proporcionar el bean de la interfaz

    @Override
    public void insert(Instructor instructor) {
        repository.insert(instructor);
    }

    @Override
    public void update(Instructor instructor) {
       repository.update(instructor);  // passtrough
    }

    @Override
    public void delete(Integer id) {
       repository.delete(id); 
    }

    @Override
    public Instructor findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Collection<Instructor> findAll() {
        return repository.findAll();
    }
    
}
