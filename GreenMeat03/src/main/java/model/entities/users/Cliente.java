package model.entities.users;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import model.entities.products.Pedido;
import model.entities.users.information.Contato;
import model.entities.users.information.Localidade;



@Entity
@Table(name = "cliente")
public class Cliente extends PessoaFisica {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "id_cliente")
//	private Long id;
//	
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Pedido> Pedidos = new ArrayList<Pedido>();
	
    /* adicionar lista de pedidos */

	public Cliente(Localidade endereco, String login, String senha, Contato contato, String nome, String sobrenome,
			String CPF, LocalDate dataDeNascimento) {
		super(login, senha, contato, nome, sobrenome, CPF, dataDeNascimento);
		// TODO Auto-generated constructor stub
	}

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

//	Cliente (ainda?) n�o possui nenhum atributo
//	criar uma fun��o para validar cpf	
// Falta validar cpf // cpf � um atributo repetido na classe Funcionario e Cliente

	
}

