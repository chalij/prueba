package com.ejemplos.obj;

import java.io.Serializable;

/*
   ﻿CREATE TABLE TALLERSPRING.USUARIOS(
       ID int(15) NOT NULL AUTO_INCREMENT ,
       NOMBRE varchar(25) ,
       USERNAME varchar(25) ,
       PASSWORD varchar(25) ,
       PRIMARY KEY (ID)
   )


CREATE TABLE USUARIOS(
       ID NUMBER(6) NOT NULL ,
       NOMBRE varchar2(25) ,
       USERNAME varchar2(25) ,
       PASSWORD varchar2(25) ,
       CONSTRAINT id_us PRIMARY KEY (ID)
   );
INSERT INTO usuarios VALUES (1,'chali','chali','123');
commit;
*/

/**
 *
 * @author Airy
 */
public class UsuarioObj implements Serializable {
   private int id;
   private String nombre;
   private String username;
   private String password;

   public int getId() {
       return id;
   }

   public void setId(int id) {
       this.id = id;
   }

   public String getNombre() {
       return nombre;
   }

   public void setNombre(String nombre) {
       this.nombre = nombre;
   }

   public String getUsername() {
       return username;
   }

   public void setUsername(String username) {
       this.username = username;
   }

   public String getPassword() {
       return password;
   }

   public void setPassword(String password) {
       this.password = password;
   }
}