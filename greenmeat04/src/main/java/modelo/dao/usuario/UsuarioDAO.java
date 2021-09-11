package modelo.dao.usuario;

import java.util.List;

import modelo.entitidades.usuarios.Usuario;

public interface UsuarioDAO {

	void inserirUsuario(Usuario usuario);
	
	void deletarUsuario(Usuario usuario);
	
	void atualizarUsuario(Usuario usuario);
	
	List<Usuario> recuperarUsuarios();	
	
}
