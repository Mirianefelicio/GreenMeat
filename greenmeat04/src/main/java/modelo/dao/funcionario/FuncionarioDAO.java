package modelo.dao.funcionario;

import java.time.LocalDate;
import java.util.List;

import modelo.entitidades.usuarios.Funcionario;
import modelo.entitidades.usuarios.information.Contato;

public interface FuncionarioDAO {

	void inserirFuncionario(Funcionario funcionario);

	void deletarFuncionario(Funcionario funcionario);

	void atualizarFuncionario(Funcionario funcionario);

	Funcionario recuperarPorId(Long id);
	
	List<Funcionario> recuperarFuncionarios();

}
