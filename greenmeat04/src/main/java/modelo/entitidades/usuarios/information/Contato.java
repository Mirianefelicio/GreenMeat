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

import model.exception.users.information.EmailInvalidException;
import model.exception.users.information.PhoneNumberInvalidException;
import modelo.entitidades.usuarios.Usuario;

@Entity
@Table(name = "contato")
public class Contato implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contato")
	private Long id;

	@Column(name = "email")
	private String email;
		
	@Column(name = "telefone")
	private String telefone;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	
//	H� um erro aqui
//	@Column(name = "usuario")
//	@MapsId
//	@JoinColumn(name = "id_usuario")
//	private Usuario usuario;
	
//	private String 
	

	public Contato(String email, String telefone) throws EmailInvalidException, PhoneNumberInvalidException {
		setEmail(email);
		setTelefone(telefone);
	}
	
	public Contato() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws EmailInvalidException {
		if (email.isEmpty())
			throw new EmailInvalidException("Campo nulo");
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) throws PhoneNumberInvalidException {
		if (telefone.isEmpty())
			throw new PhoneNumberInvalidException("Campo nulo");
		this.telefone = telefone;
	}

//	public Usuario getUsuario() {
//		return usuario;
//	}
//
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}

}
