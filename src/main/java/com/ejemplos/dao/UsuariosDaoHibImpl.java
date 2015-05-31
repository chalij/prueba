package com.ejemplos.dao;

import com.ejemplos.exception.DAOException;
import com.ejemplos.obj.UsuarioObj;
import java.util.List;

/**
 *
 * @author Airy
 */
public class UsuariosDaoHibImpl extends CustomHibernateDaoSupport implements UsuariosDao {

    
    public void crearUsuario(UsuarioObj usuarioObj) throws DAOException {
        getHibernateTemplate().saveOrUpdate(usuarioObj);
    }

    public UsuarioObj buscaUsuario(String username) throws DAOException {
        List list = getHibernateTemplate().find(" from UsuarioObj WHERE USERNAME=?",username);
        return (UsuarioObj) list.get(0);
    }

    public List<UsuarioObj> listaUsuarios() throws DAOException {
        List<UsuarioObj> lista = getHibernateTemplate().find("from UsuarioObj");
        return lista;
    }

    public void modificarUsuario(UsuarioObj usuarioObj) throws DAOException {
        getHibernateTemplate().update(usuarioObj);
    }

    public void borrarUsuario(UsuarioObj usuario) throws DAOException {
        getHibernateTemplate().delete(usuario);
    }

}