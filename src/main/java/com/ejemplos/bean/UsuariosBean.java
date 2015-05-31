package com.ejemplos.bean;

import com.ejemplos.dao.UsuariosDao;
import com.ejemplos.obj.UsuarioObj;
import java.util.List;

/**
 *
 * @author Airy
 */
public class UsuariosBean {
    private List<UsuarioObj> miLista;
    private UsuariosDao usuariosDao;
    
    public UsuariosBean(){
    }

    public List<UsuarioObj> getMiLista() {
        try {
            miLista = usuariosDao.listaUsuarios();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return miLista;
    }

    public void setMiLista(List<UsuarioObj> miLista) {
        this.miLista = miLista;
    }

    public UsuariosDao getUsuariosDao() {
        return usuariosDao;
    }

    public void setUsuariosDao(UsuariosDao usuariosDao) {
        this.usuariosDao = usuariosDao;
    }
}