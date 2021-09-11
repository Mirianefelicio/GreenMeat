
package modelo.dao.pessoajuridica;

import java.util.List;

import modelo.entitidades.usuarios.PessoaJuridica;

public interface PessoaJuridicaDAO {

	void inserirPessoaJuridica(PessoaJuridica pj);

	void deletarPessoaJuridica(PessoaJuridica pj);

	void atualizarPessoaJuridica(PessoaJuridica pj);
	
	List <PessoaJuridica>recuperarPessoasJuridicas();
}
