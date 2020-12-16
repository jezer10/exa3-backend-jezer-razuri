package pe.edu.upeu.loginappback.dao;

import java.util.Map;

import pe.edu.upeu.loginappback.entity.Persona;

public interface PersonaDao {
	int create(Persona r);
	int update(Persona r);
	int update(int id);
	int delete(int id);
	Persona read(int id);
	Map<String, Object> readAll();
}
