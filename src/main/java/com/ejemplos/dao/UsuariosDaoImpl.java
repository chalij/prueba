package com.ejemplos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.ejemplos.exception.DAOException;
import com.ejemplos.obj.UsuarioObj;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Airy
 */
public class UsuariosDaoImpl implements UsuariosDao {

   private DataSource dataSource;
   private JdbcTemplate jdbcTemplate;

   public void crearUsuario(UsuarioObj usuarioObj) throws DAOException {
       Object[] args = new Object[]{
           usuarioObj.getNombre(),
           usuarioObj.getUsername(),
           usuarioObj.getPassword()
       };

       String idUsuario = "";
       String sql = "INSERT INTO USUARIOS("
               + "NOMBRE,"
               + "USERNAME,"
               + "PASSWORD "
               + ") VALUES(?, ?, ?)";

       try {
           this.jdbcTemplate.update(sql, args);
       } catch (Exception e) {
           e.printStackTrace();
           throw new DAOException("Error de acceso a datos: " + e.getMessage());
       }
   }

   public UsuarioObj buscaUsuario(String username) throws DAOException {
       UsuarioObj usuario = null;
       Object[] args = new Object[]{
           username
       };
       try {
           String sql = "SELECT "
                   + "ID,"
                   + "NOMBRE,"
                   + "USERNAME,"
                   + "PASSWORD "
                   + "FROM USUARIOS WHERE USERNAME=?";
           usuario = (UsuarioObj) this.jdbcTemplate.queryForObject(sql, args,
                   new RowMapper() {

                       public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                           UsuarioObj usuarioObj = new UsuarioObj();
                           usuarioObj.setId(rs.getInt("ID"));
                           usuarioObj.setNombre(rs.getString("NOMBRE"));
                           usuarioObj.setUsername(rs.getString("USERNAME"));
                           usuarioObj.setPassword(rs.getString("PASSWORD"));
                           return usuarioObj;
                       }
                   });
       } catch (EmptyResultDataAccessException ee) {
           return null;
       } catch (DataAccessException ex) {
           throw new DAOException("Error de acceso a datos: " + ex.getMessage());
       }
       return usuario;
   }

   public List<UsuarioObj> listaUsuarios() throws DAOException {
       List<UsuarioObj> usuarios = null;
       try {
           String sql = "SELECT "
                   + "ID,"
                   + "NOMBRE,"
                   + "USERNAME,"
                   + "PASSWORD "
                   + "FROM USUARIOS";
           usuarios = this.jdbcTemplate.query(sql,
                   new RowMapper() {

                       public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                           UsuarioObj usuarioObj = new UsuarioObj();
                           usuarioObj.setId(rs.getInt("ID"));
                           usuarioObj.setNombre(rs.getString("NOMBRE"));
                           usuarioObj.setUsername(rs.getString("USERNAME"));
                           usuarioObj.setPassword(rs.getString("PASSWORD"));
                           return usuarioObj;
                       }
                   });
       } catch (EmptyResultDataAccessException ee) {
           return null;
       } catch (DataAccessException ex) {
           throw new DAOException("Error de acceso a datos: " + ex.getMessage());
       }
       return usuarios;
   }

   public void modificarUsuario(UsuarioObj usuarioObj) throws DAOException {
       Object[] args = new Object[]{
           usuarioObj.getUsername(),
           usuarioObj.getNombre(),
           usuarioObj.getPassword(),
           usuarioObj.getId()
       };
       String sql = "UPDATE usuarios SET "
               + "USERNAME=?,"
               + "NOMBRE=?,"
               + "PASSWORD=? "
               + "WHERE ID=?";
       try {
           this.jdbcTemplate.update(sql, args);
       } catch (Exception e) {
           e.printStackTrace();
           throw new DAOException("Error de acceso a datos: " + e.getMessage());
       }
   }

   public void borrarUsuario(UsuarioObj usuario) throws DAOException {
       Object[] args = new Object[]{
           usuario.getId()
       };
       String sql = "DELETE FROM usuarios WHERE ID=?";
       try {
           this.jdbcTemplate.update(sql, args);
       } catch (Exception e) {
           e.printStackTrace();
           throw new DAOException("Error de acceso a datos: " + e.getMessage());
       }
   }

   public DataSource getDataSource() {
       return dataSource;
   }

   public void setDataSource(DataSource dataSource) {
       this.dataSource = dataSource;
       this.setJdbcTemplate(new JdbcTemplate(dataSource));
   }

   public JdbcTemplate getJdbcTemplate() {
       return jdbcTemplate;
   }

   public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
       this.jdbcTemplate = jdbcTemplate;
   }
}