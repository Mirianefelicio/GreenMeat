package modelo.entitidades.usuarios;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import modelo.entitidades.usuarios.information.Contato;
import modelo.entitidades.usuarios.information.Localidade;


@Entity
@Table(name = "funcionario")
public class Funcionario extends PessoaFisica {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "funcao_funcionario")
	private String funcao;

	@Column(name = "cargo_funcionario")
	private String cargo;

//	Ao criar funcionario criar tambem seu login e senha

	public Funcionario(){}
	
	public Funcionario(Localidade endereco, String login, String senha, Contato contato, String nome, String sobrenome,
			String CPF, LocalDate dataDeNascimento) {
		super(login, senha, contato, nome, sobrenome, CPF, dataDeNascimento);
		setFuncao(funcao);
		setCargo(cargo);
	}

	public Funcionario( String login, String senha, String nome, String sobrenome,
			String CPF, String cargo, String funcao) {
		super(login, senha, nome, sobrenome, CPF);
		setFuncao(funcao);
		setCargo(cargo);
	}

	
	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}