package model.entities.users;

import model.entities.users.information.Contato;
import model.entities.users.information.Localidade;

public class Fornecedor extends Usuario {

	private String raz�oSocial;
	private String CNPJ;

	public Fornecedor(String raz�oSocial, String CNPJ, Localidade localidade, String login, String senha,
			Contato contato) {
		super(localidade, login, senha, contato);
		setRaz�oSocial(raz�oSocial);
		setCNPJ(CNPJ);
	}

	public String getRaz�oSocial() {
		return raz�oSocial;
	}

	public void setRaz�oSocial(String raz�oSocial) {

		this.raz�oSocial = raz�oSocial;

	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String CNPJ) {

		this.CNPJ = CNPJ;
	}

}
