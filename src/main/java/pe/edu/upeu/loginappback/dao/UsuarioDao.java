package pe.edu.upeu.loginappback.dao;

import java.util.Map;

import pe.edu.upeu.loginappback.entity.Usuario;


public interface UsuarioDao {
int create(Usuario u);
int update(Usuario u);
int delete(int id);
Usuario read(int id);
Usuario read(String nomuser);
Usuario validarUsuario(String nomuser);
Map<String, Object> datosUsuario(String username);
}
