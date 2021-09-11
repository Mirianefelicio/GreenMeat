package modelo.entitidades.usuarios;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;

import modelo.entitidades.usuarios.information.Contato;
import modelo.entitidades.usuarios.information.Localidade;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	// um usuario possui diversas localidades, rela��o de N pra N

	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
	@JoinTable(name = "usuario_localidade", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_localidade"))
	private List<Localidade> localidades = new ArrayList<Localidade>();

	@Column(name = "login_usuario")
	private String login;

	@Column(name = "senha_usuario")
	private String senha;

	// Dizendo que um usuario pode ter varios contatos e que um contato pode
	// pertencer apenas a um usuario
	// mappedBy deve ser usado em usuario, em contato deve ser usado o JoinColumn


	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Contato>contatos = new ArrayList<Contato>();

	
	@Column(name = "datacastro_usuario")
	private LocalDate dataCadastro;

	// Cada vez que um usu�rio for criado seu tipo de acesso deve ser especificado
	// de acordo com o usuario(cliente, funcionario, fornecedor).

	public Usuario() {

	}

	public Usuario(/* Localidade endereco, */ String login, String senha /* Contato contato */) {
//		setEndereco(endereco);
		setLogin(login);
		setSenha(senha);
//		setContato(contato);
		setDataCadastro(LocalDate.now());
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public List<Localidade> getLocalidades() {
		return localidades;
	}

	public void setLocalidades(List<Localidade> localidades) {
		this.localidades = localidades;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {

		this.login = login;

	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

//	public LocalDate getDataCadastro() {
//		return dataCadastro;
//	}

//	public void setDataCadastro(LocalDate dataCadastro) {
//		this.dataCadastro = dataCadastro;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public void adicionarContato(Contato contato) {
		getContatos().add(contato);
		contato.setUsuario(this);
	}

}
