package modelo.entitidades.usuarios.information;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import model.exception.users.information.CountryInvalidException;
import modelo.entitidades.usuarios.Usuario;

@Entity
public class Localidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_localidade")
	private Long id;

//	Estes atributos dizem respeito a base de dados ainda n�o implemenntada
//	N�o fazer altera��es nessa classe
	
	
	@ManyToMany(mappedBy = "localidades")
	private List<Usuario>usuarios = new ArrayList<Usuario>();
	

	@Column(name = "pais", length = 25, nullable = false, unique = false)
	private String pais;

	@Column(name = "estado", length = 25, nullable = false, unique = false)
	private String estado;

	@Column(name = "", length = 25, nullable = false, unique = false)
	private String provincia;

	@Column(name = "cotinente", length = 25, nullable = false, unique = false)
	private String continente;

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "endereco", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<Endereco> enderecos = new ArrayList<Endereco>();

	public Localidade(String pais, String estado, String provincia, String continente) throws CountryInvalidException {
		setPais(pais);
		setEstado(estado);
		setProvincia(provincia);
		setContinente(continente);

	}

	
	public Localidade() {
		// TODO Auto-generated constructor stub
	}

	
	public Long getId() {
		return id;
	}


	public List<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}


	public String getPais() {
		return pais;
	}

	public void setPais(String pais) throws CountryInvalidException {
		if (pais.isEmpty())
			throw new CountryInvalidException("Campo nulo");
		this.pais = pais;

	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getContinente() {
		return continente;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}

}
