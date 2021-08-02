package model.entities.users;

import model.entities.users.information.Contato;
import model.entities.users.information.Localidade;
import model.exceptions.InvalidFieldException;

public class Fornecedor extends Usuario {

//	 precisa de algum atributo para identificar o fornecedor

	private String nomeFantasia;
	private String raz�oSocial;
	private String CNPJ; // Falta validar CNPJ

	public Fornecedor(String nomeFantasia, String raz�oSocial, String CNPJ, Localidade localidade, String login,
			String senha, Contato contato) throws InvalidFieldException {
		super(localidade, login, senha, contato);
		setNomeFantasia(nomeFantasia);
		setRaz�oSocial(raz�oSocial);
		setCNPJ(CNPJ);
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) throws InvalidFieldException {
		if (nomeFantasia.isBlank() || nomeFantasia.isEmpty())
			throw new InvalidFieldException("Campo nulo ");
		this.nomeFantasia = nomeFantasia;
	}

	public String getRaz�oSocial() {
		return raz�oSocial;
	}

	public void setRaz�oSocial(String raz�oSocial) throws InvalidFieldException {
		if (raz�oSocial.isBlank() || raz�oSocial.isEmpty())
			throw new InvalidFieldException("Campo nulo ");
		this.raz�oSocial = raz�oSocial;

	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String CNPJ) { // Validar CNPJ aqui

		this.CNPJ = CNPJ;
	}

}
