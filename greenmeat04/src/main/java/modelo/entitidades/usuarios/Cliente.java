package modelo.entitidades.usuarios;

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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.criteria.Join;

import modelo.entidades.produtos.Pedido;
import modelo.entitidades.usuarios.information.Contato;
import modelo.entitidades.usuarios.information.Localidade;



@Entity
@Table(name = "cliente")
public class Cliente extends PessoaFisica {
	private static final long serialVersionUID = 1L;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Pedido> Pedidos = new ArrayList<Pedido>();

	public Cliente(Localidade endereco, String login, String senha, Contato contato, String nome, String sobrenome,
			String CPF, LocalDate dataDeNascimento) {
		super(login, senha, contato, nome, sobrenome, CPF, dataDeNascimento);
		// TODO Auto-generated constructor stub
	}

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public List<Pedido> getPedidos() {
		return Pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		Pedidos = pedidos;
	}

	

//	Cliente (ainda?) n�o possui nenhum atributo
//	criar uma fun��o para validar cpf	
// Falta validar cpf // cpf � um atributo repetido na classe Funcionario e Cliente

	
}

