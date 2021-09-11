package modelo.entitidades.usuarios;

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
@Table(name = "pessoajuridica")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PessoaJuridica extends Usuario {

	/**
	 * @Column(name = "logradouro_endereco", )
	 */
	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "id_pessoa_juridica")
//	private Long id;

	@Column(name = "CNPJ")
	private String CNPJ;

	@Column(name = "razaosocial_pessoajuridica")
	private String razaoSocial;

	@Column(name = "nomefantasia_pessoajuridica")
	private String nomeFantasia;

	public PessoaJuridica() {
	}

	public PessoaJuridica(/* Localidade endereco, */ String login, String senha, Contato contato, String CNPJ,
			String razaoSocial, String nomeFantasia) {
		super(login, senha);
		setCNPJ(CNPJ);
		setRazaoSocial(razaoSocial);
		setNomeFantasia(nomeFantasia);
	}
	
	public PessoaJuridica(/* Localidade endereco, */ String login, String senha, String CNPJ,
			String razaoSocial, String nomeFantasia) {
		super(login, senha);
		setCNPJ(CNPJ);
		setRazaoSocial(razaoSocial);
		setNomeFantasia(nomeFantasia);
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String CNPJ) {
		this.CNPJ = CNPJ;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

}
