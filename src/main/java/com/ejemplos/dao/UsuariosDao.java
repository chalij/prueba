package com.ejemplos.dao;

import com.ejemplos.exception.DAOException;
import com.ejemplos.obj.UsuarioObj;
import java.util.List;

/**
 *
 * @author Airy
 */
public interface UsuariosDao {

   public void crearUsuario(UsuarioObj usuario) throws DAOException;
   public UsuarioObj buscaUsuario(String username) throws DAOException;
   public List<UsuarioObj> listaUsuarios() throws DAOException;
   public void modificarUsuario(UsuarioObj usuario) throws DAOException;
   public void borrarUsuario(UsuarioObj usuario) throws DAOException;
}