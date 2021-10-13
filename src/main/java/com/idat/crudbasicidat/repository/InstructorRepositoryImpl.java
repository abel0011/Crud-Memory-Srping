package com.idat.crudbasicidat.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import javax.annotation.PostConstruct;

import com.idat.crudbasicidat.model.Instructor;

import org.springframework.stereotype.Repository;


@Repository // estereotipo (gestiona en tu contexto de inversion de control)
public class InstructorRepositoryImpl implements InstructorRepository{

    public static  Collection<Instructor> itemsInstructor = new ArrayList<>();

    @PostConstruct // ejecuta el emetodo post constuctor
    public void cargaInicial(){

        Instructor instructor1 = new Instructor(1,"new","new", "new",  new Date() );
        Instructor instructor2 = new Instructor(2,"new","new", "new",  new Date() );
        itemsInstructor.add(instructor1);
        itemsInstructor.add(instructor2);
    }


    @Override
    public void insert(Instructor instructor) {
        itemsInstructor.add(instructor);
        
    }

    @Override
    public void update(Instructor instructor) {
        Instructor oldInstructor = this.findById(instructor.getInstructorId());   
        itemsInstructor.remove(oldInstructor);

        Instructor newInstructor = instructor;

        itemsInstructor.add(newInstructor);
    }

    @Override
    public void delete(Integer id) {
        Instructor oldInstructor = this.findById(id);
        if(oldInstructor != null){
            itemsInstructor.remove(oldInstructor);
        }
    }

    @Override
    public Instructor findById(Integer id) {
        //stream flujo de bityes, sobre ella aplicas una funcion de filtrado a partir del predicado
        //finalmente escojo la primera concidencia
        Optional<Instructor> instructorById = 
        itemsInstructor.stream().filter(p  -> p.getInstructorId()  == id).findFirst();
        return instructorById.orElse(null); // en caso no exista envie null;
    }

    @Override
    public Collection<Instructor> findAll() {
        return itemsInstructor;
    }
    
}
