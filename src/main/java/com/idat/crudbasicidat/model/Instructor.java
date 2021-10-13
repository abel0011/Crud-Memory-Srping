package com.idat.crudbasicidat.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// SERIALIZABLE => le dice a la JVM que persista los datos en el disco(guarde la referencia de los objetos)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instructor implements Serializable{
   private static final long serialVersionUID = 1L; 
   
   private Integer instructorId;
   private String nombre;
   private String apellido;
   private String password;
   private Date fregistro;
}
