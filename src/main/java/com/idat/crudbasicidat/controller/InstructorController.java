package com.idat.crudbasicidat.controller;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.idat.crudbasicidat.model.Instructor;
import com.idat.crudbasicidat.service.InstructorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;    

    @GetMapping("/list")
    public ResponseEntity<?> list(){
       Collection<Instructor> listInstructor = instructorService.findAll();
       return new ResponseEntity<>( listInstructor, HttpStatus.OK); 
    }  // ? => cualquier objeto
    @GetMapping("/list/{id}")
    public ResponseEntity<?> listId(@PathVariable(name = "id") Integer id){

        Instructor instructor = instructorService.findById(id);
        if( instructor == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontro instructor con ese id");
        }
        return new ResponseEntity<>(instructor,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addInstructor (@RequestBody Instructor instructor){
        instructorService.insert((instructor));
        return new ResponseEntity<>(instructor,HttpStatus.CREATED);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<?> editPatchInstructor(@PathVariable(name = "id") Integer id, @RequestBody Instructor newInstructor){

        Instructor instructor = instructorService.findById(id);
        if( instructor == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontro instructor con ese id");
        
        instructor.setNombre(newInstructor.getNombre());
        instructor.setApellido(newInstructor.getNombre());

        instructorService.update(instructor);
        return new ResponseEntity<>(instructor,HttpStatus.ACCEPTED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editInstructor(@PathVariable(name = "id") Integer id, @RequestBody Instructor newInstructor){

        Instructor instructor = instructorService.findById(id);
        if( instructor == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontro instructor con ese id");
        
        instructorService.update(newInstructor);
        return new ResponseEntity<>(instructor,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
   public ResponseEntity<?> delete(@PathVariable(name = "id") Integer id){

        Instructor instructor = instructorService.findById(id);
        if( instructor == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontro instructor con ese id");
 
        instructorService.delete(id);
        //DEFINIER OBJETO RESPUESTA
        Map<String, String> requestMap = new HashMap<>();
    
        requestMap.put("codRes","00");
        requestMap.put("msjRes","Instructor eliminado correctamente"+ id);
        requestMap.put("dateRes", new Date().toString());
       return new ResponseEntity<>(requestMap,HttpStatus.ACCEPTED);
   }


}
