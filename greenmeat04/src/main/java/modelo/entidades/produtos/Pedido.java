package modelo.entidades.produtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import modelo.entitidades.usuarios.Cliente;
import modelo.entitidades.usuarios.Usuario;

@Entity
@Table(name = "pedido")
public class Pedido {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long id;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Item> itens = new ArrayList<Item>();

	@Enumerated(EnumType.STRING)
	private Status status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente; // dono da lista de compras

	@Column(name = "data_entrega")
	private LocalDate dataEntrega;

	@Column(name = "valor_total_pedido")
	private float valorTotal; // soma do valor total de todos os itens do pedido

	public Pedido(Cliente cliente) {
		setValorTotal(calcularValorTotalPedido());
		setCliente(cliente); // um cliente pode ter mais de um pedido aberto? (ao mesmo tempo)
		setStatus(Status.PEDIDO_EM_ABERTO);
	}

	public Pedido(Cliente cliente, List<Item> itens) {
		setCliente(cliente);
		setItens(itens);
		setValorTotal(calcularValorTotalPedido());
	}

	public Pedido() {

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

//	Adicionar produto � lista de produtos
// item.preco = produto * quantidade

	public void adicionarItem(Item item) {

		if (itens.contains(item.getProduto()))
			System.out.println("Produto j� est� neste pedido!");
		else {
			setValorTotal(getValorTotal() + item.getValorTotal());
			itens.add(item); // adicionando um "item" � lista de itens
		}
		// ESTE M�TODO SER� ALTERADO CASO A RE��O ENTRE PEDIDO E ITEM SE TORNAR
		// BIDIRECIONAL
	}

//	Aqui ele remove um item da Lista  (Pedido, neste caso)

	public void removerItemDaLista(Item item) {

		itens.remove(item);
		setValorTotal(getValorTotal() - item.getValorTotal());
	}

	public void finalizarPedido(String idPedido) {
		setStatus(Status.PEDIDO_FINALIZADO);
	}

//	O m�todo a seguir calcula o valor total de um pedido somando o valor total de cada item

	public float calcularValorTotalPedido() {
		int soma = 0;
		for (int i = 0; i < itens.size(); i++) {
			soma += itens.get(i).calculaValorTotal();
		}
		return soma;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
