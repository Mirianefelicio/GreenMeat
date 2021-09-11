package modelo.entitidades.usuarios;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import modelo.entitidades.usuarios.information.Contato;

@Entity
@Table(name = "pessoafisica")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PessoaFisica extends Usuario {
	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "id_pessoa_fisica")
//	private Long id;

	@Column(name = "primeironome_pessoafisica", length = 15)
	private String nome;

	@Column(name = "sobrenome_pessoafisica", length = 20)
	private String sobrenome;

	@Column(name = "CPF_pessoafisica")
	private String CPF;

	@Column(name = "dataNascimento_pessoaFisica")
	private LocalDate dataDeNascimento;

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(/*Localidade endereco,*/ String login, String senha, Contato contato, String nome, String sobrenome,
			String CPF, LocalDate dataDeNascimento) {
		super(login, senha);
		setNome(nome);
		setSobrenome(sobrenome);
		setCPF(CPF);
		setDataDeNascimento(dataDeNascimento);
		// TODO Auto-generated constructor stub
	}

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

	public PessoaFisica(String login, String senha, String nome, String sobrenome, String CPF) {
		super(login, senha );
		setNome(nome);
		setSobrenome(sobrenome);
		setCPF(CPF);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

}
