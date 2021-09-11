package modelo.entitidades.usuarios.information;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import modelo.exceptions.InvalidFieldException;

@Entity
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Long id;

	private String tipoDaVia;

	private String nomeDaRua;

	@Column(name = "logradouro_endereco", length = 50, nullable = false)
	private String logradouro;

	@Column(name = "numero_endereco", nullable = false)
	private short numero;

	@Column(name = "CEP", nullable = false)
	private String CEP;

	@Column(name = "complemento", length = 50, nullable = true)
	private String complemento;

	@ManyToOne
	@JoinColumn(name = "id")
	private Localidade localidade;

//	Falta fazer referencia a enderecos em cliente
//	@ManyToMany(mappedBy = "enderecos")        
//	private List<Cliente> clientes = new ArrayList<Cliente>();
//	

	public Endereco(String tipoDaVia, String nomeDaRua, String logradouro, short numero, String CEP, String complemento)
			throws InvalidFieldException {
		setTipoDaVia(tipoDaVia);
		setNomeDaRua(nomeDaRua);
		setLogradouro(logradouro);
		setNumero(numero);
		setCEP(CEP);
		setComplemento(complemento);
	}

	public Endereco(String nomeDaRua, String logradouro, short numero, String CEP, String complemento)
			throws InvalidFieldException {
		setNomeDaRua(nomeDaRua);
		setLogradouro(logradouro);
		setNumero(numero);
		setCEP(CEP);
		setComplemento(complemento);
	}

	/*
	 * public String getTipoDaVia() { return tipoDaVia; }
	 * 
	 * public void setTipoDaVia(String tipoDaVia) throws InvalidFieldException {
	 * 
	 * if (tipoDaVia.isEmpty() || tipoDaVia.isBlank()) throw new
	 * InvalidFieldException("Campo nulo");
	 * 
	 * this.tipoDaVia = tipoDaVia; }
	 */

	public Long getId() {
		return id;
	}

	public String getTipoDaVia() {
		return tipoDaVia;
	}

	public String getNomeDaRua() {
		return nomeDaRua;
	}

	public Localidade getLocalidade() {
		return localidade;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTipoDaVia(String tipoDaVia) {
		this.tipoDaVia = tipoDaVia;
	}

	public void setNomeDaRua(String nomeDaRua) {
		this.nomeDaRua = nomeDaRua;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(short numero) {
		this.numero = numero;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String CEP) {
		this.CEP = CEP;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) throws InvalidFieldException {
		if (complemento.isEmpty())
			throw new InvalidFieldException("Campo nulo");
		this.complemento = complemento;
	}

	/*
	 * public String getNomeDaRua() { return nomeDaRua; }
	 * 
	 * public void setNomeDaRua(String nomeDaRua) throws InvalidFieldException { if
	 * (nomeDaRua.isBlank() || nomeDaRua.isEmpty()) throw new
	 * InvalidFieldException("Campo nulo"); this.nomeDaRua = nomeDaRua; }
	 */

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

}
