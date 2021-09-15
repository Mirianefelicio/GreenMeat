package modelo.dao.localidade;

import java.util.List;

import modelo.entitidades.usuarios.Usuario;
import modelo.entitidades.usuarios.informacao.Endereco;
import modelo.entitidades.usuarios.informacao.Localidade;

public interface LocalidadeDAO {
	
	void inserirLocalidade(Localidade localidade);

	void deletarLocalidade(Localidade localidade);

	void atualizarLocalidade(Localidade localidade);

	Localidade recuperarLocalidadeEndereco(Endereco endereco);
	
	List<Localidade> recuperarLocalidades();
	
	List<Localidade> recuperarLocalidadesUsuario(Usuario usuario);
	
	
}
