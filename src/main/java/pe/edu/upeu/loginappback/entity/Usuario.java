package pe.edu.upeu.loginappback.entity;

import lombok.Data;

@Data
public class Usuario {
	private int idusuario;
	private String username;
	private String password;
	private int estado;
	private int idpersona;

}
